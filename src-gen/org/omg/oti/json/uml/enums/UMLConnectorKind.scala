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
  * ConnectorKind is an enumeration that defines whether a Connector is an assembly or a delegation.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
sealed trait UMLConnectorKind {}

object UMLConnectorKind {

  /**
    * Indicates that the Connector is an assembly Connector.
    *
    * <!-- Start of user code doc for assembly -->
    * <!-- End of user code doc for assembly -->
    */
  case object assembly extends UMLConnectorKind {}

  /**
    * Indicates that the Connector is a delegation Connector.
    *
    * <!-- Start of user code doc for delegation -->
    * <!-- End of user code doc for delegation -->
    */
  case object delegation extends UMLConnectorKind {}
 
  implicit val writesUMLConnectorKind
  : Writes[UMLConnectorKind]
  = Variants.writes[UMLConnectorKind]((__ \ "type").format[String])

  implicit val readsUMLConnectorKind
  : Reads[UMLConnectorKind]
  = Variants.reads[UMLConnectorKind]((__ \ "type").format[String])

  implicit val formatsUMLConnectorKind
  : Format[UMLConnectorKind]
  = Variants.format[UMLConnectorKind]((__ \ "type").format[String])
  
}
