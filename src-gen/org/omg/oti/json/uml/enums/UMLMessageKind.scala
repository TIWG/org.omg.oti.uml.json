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
  * This is an enumerated type that identifies the type of Message.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
sealed trait UMLMessageKind {}

object UMLMessageKind {

  /**
    * sendEvent and receiveEvent are present
    *
    * <!-- Start of user code doc for complete -->
    * <!-- End of user code doc for complete -->
    */
  case object complete extends UMLMessageKind {}

  /**
    * sendEvent absent and receiveEvent present
    *
    * <!-- Start of user code doc for found -->
    * <!-- End of user code doc for found -->
    */
  case object found extends UMLMessageKind {}

  /**
    * sendEvent present and receiveEvent absent
    *
    * <!-- Start of user code doc for lost -->
    * <!-- End of user code doc for lost -->
    */
  case object lost extends UMLMessageKind {}

  /**
    * sendEvent and receiveEvent absent (should not appear)
    *
    * <!-- Start of user code doc for unknown -->
    * <!-- End of user code doc for unknown -->
    */
  case object unknown extends UMLMessageKind {}
 
  implicit val writesUMLMessageKind
  : Writes[UMLMessageKind]
  = Variants.writes[UMLMessageKind]((__ \ "type").format[String])

  implicit val readsUMLMessageKind
  : Reads[UMLMessageKind]
  = Variants.reads[UMLMessageKind]((__ \ "type").format[String])

  implicit val formatsUMLMessageKind
  : Format[UMLMessageKind]
  = Variants.format[UMLMessageKind]((__ \ "type").format[String])
  
}
