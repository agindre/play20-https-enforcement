package controllers

import play.api.mvc._
import play.Play

trait ActionHttps {

	self: Controller =>
		//Define a action composition
		def enforceHttps[A](action: Action[A]): Action[A] = {
			Action(action.parser) {
				request =>
					//if the request is forwarded (eg: by a webserver)
					if (request.headers.get("x-forwarded-proto").isDefined) {
						//check if the original request was https
						request.headers.get("x-forwarded-proto") match {
							//if so then execute the request normally
							case Some("https") => action(request)
							//if not then redirect to the same ressource with https
							case _ => Redirect("https://" + request.headers.get("host").get + request.uri)
						}
					} else {
						//if it's not a case of forwarded requests, execute the request as usual
						action(request)
					}
			}
		}
}
