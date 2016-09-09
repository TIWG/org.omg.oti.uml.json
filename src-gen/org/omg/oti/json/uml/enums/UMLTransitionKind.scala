/*
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omg.oti.json.uml.enums

import play.json.extra._
import play.api.libs.json._

import scala.Predef.String

/**
  * TransitionKind is an Enumeration type used to differentiate the various kinds of Transitions.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
sealed trait UMLTransitionKind {}

object UMLTransitionKind {

  /**
    * Implies that the Transition, if triggered, will exit the composite (source) State.
    *
    * <!-- Start of user code doc for external -->
    * <!-- End of user code doc for external -->
    */
  case object external extends UMLTransitionKind {}

  /**
    * Implies that the Transition, if triggered, occurs without exiting or entering the source State (i.e., it does not cause a state change). This means that the entry or exit condition of the source State will not be invoked. An internal Transition can be taken even if the SateMachine is in one or more Regions nested within the associated State.
    *
    * <!-- Start of user code doc for internal -->
    * <!-- End of user code doc for internal -->
    */
  case object internal extends UMLTransitionKind {}

  /**
    * Implies that the Transition, if triggered, will not exit the composite (source) State, but it will exit and re-enter any state within the composite State that is in the current state configuration.
    *
    * <!-- Start of user code doc for local -->
    * <!-- End of user code doc for local -->
    */
  case object local extends UMLTransitionKind {}
 
  implicit val writesUMLTransitionKind
  : Writes[UMLTransitionKind]
  = Variants.writes[UMLTransitionKind]((__ \ "type").format[String])

  implicit val readsUMLTransitionKind
  : Reads[UMLTransitionKind]
  = Variants.reads[UMLTransitionKind]((__ \ "type").format[String])

  implicit val formatsUMLTransitionKind
  : Format[UMLTransitionKind]
  = Variants.format[UMLTransitionKind]((__ \ "type").format[String])
  
}
