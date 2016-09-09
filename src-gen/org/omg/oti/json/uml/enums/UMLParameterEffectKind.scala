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
  * ParameterEffectKind is an Enumeration that indicates the effect of a Behavior on values passed in or out of its parameters.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
sealed trait UMLParameterEffectKind {}

object UMLParameterEffectKind {

  /**
    * Indicates that the behavior creates values.
    *
    * <!-- Start of user code doc for create -->
    * <!-- End of user code doc for create -->
    */
  case object create extends UMLParameterEffectKind {}

  /**
    * Indicates objects that are values of the parameter do not exist after executions of the behavior are finished.
    *
    * <!-- Start of user code doc for delete -->
    * <!-- End of user code doc for delete -->
    */
  case object delete extends UMLParameterEffectKind {}

  /**
    * Indicates objects that are values of the parameter have values of their properties, or links in which they participate, or their classifiers retrieved during executions of the behavior.
    *
    * <!-- Start of user code doc for read -->
    * <!-- End of user code doc for read -->
    */
  case object read extends UMLParameterEffectKind {}

  /**
    * Indicates objects that are values of the parameter have values of their properties, or links in which they participate, or their classification changed during executions of the behavior.
    *
    * <!-- Start of user code doc for update -->
    * <!-- End of user code doc for update -->
    */
  case object update extends UMLParameterEffectKind {}
 
  implicit val writesUMLParameterEffectKind
  : Writes[UMLParameterEffectKind]
  = Variants.writes[UMLParameterEffectKind]((__ \ "type").format[String])

  implicit val readsUMLParameterEffectKind
  : Reads[UMLParameterEffectKind]
  = Variants.reads[UMLParameterEffectKind]((__ \ "type").format[String])

  implicit val formatsUMLParameterEffectKind
  : Format[UMLParameterEffectKind]
  = Variants.format[UMLParameterEffectKind]((__ \ "type").format[String])
  
}
