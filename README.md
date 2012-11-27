play20-https-enforcement
========================

This piece of code is used to force to use https connections for play 2.x app behind webserver.

It's very usefull for app hosted on cloud provider (such as heroku for example).

It's easy to use ! Add the src/scala/controller/ActionHttps.scala into you app/controller directory. 
Then add it to your controller by extend it. 

Example:


	package controllers

	import play.api.mvc._

	object MyController extends Controller with ActionHttps {

		def test(param1: String) = enforceHttps {
			Action {
				Ok("Https !")
			}
		}
	}

You can find another example in src/scala/controller/SampleController.scala.