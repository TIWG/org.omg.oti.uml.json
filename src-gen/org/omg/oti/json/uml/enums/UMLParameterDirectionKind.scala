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
  * ParameterDirectionKind is an Enumeration that defines literals used to specify direction of parameters.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
sealed trait UMLParameterDirectionKind {}

object UMLParameterDirectionKind {

  /**
    * Indicates that Parameter values are passed as return values back to the caller.
    *
    * <!-- Start of user code doc for _return -->
    * <!-- End of user code doc for _return -->
    */
  case object _return extends UMLParameterDirectionKind {}

  /**
    * Indicates that Parameter values are passed in by the caller. 
    *
    * <!-- Start of user code doc for in -->
    * <!-- End of user code doc for in -->
    */
  case object in extends UMLParameterDirectionKind {}

  /**
    * Indicates that Parameter values are passed in by the caller and (possibly different) values passed out to the caller.
    *
    * <!-- Start of user code doc for inout -->
    * <!-- End of user code doc for inout -->
    */
  case object inout extends UMLParameterDirectionKind {}

  /**
    * Indicates that Parameter values are passed out to the caller.
    *
    * <!-- Start of user code doc for out -->
    * <!-- End of user code doc for out -->
    */
  case object out extends UMLParameterDirectionKind {}
 
  implicit val writesUMLParameterDirectionKind
  : Writes[UMLParameterDirectionKind]
  = Variants.writes[UMLParameterDirectionKind]((__ \ "type").format[String])

  implicit val readsUMLParameterDirectionKind
  : Reads[UMLParameterDirectionKind]
  = Variants.reads[UMLParameterDirectionKind]((__ \ "type").format[String])

  implicit val formatsUMLParameterDirectionKind
  : Format[UMLParameterDirectionKind]
  = Variants.format[UMLParameterDirectionKind]((__ \ "type").format[String])
  
}
