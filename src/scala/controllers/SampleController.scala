package controllers

import play.api.mvc._

object SampleController extends Controller with ActionHttps {
	//add enforceHttps to wrape the Action
	def test = enforceHttps {
		Action {
			Ok("With Https !")
		}
	}

}