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
  * PseudostateKind is an Enumeration type that is used to differentiate various kinds of Pseudostates.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
sealed trait UMLPseudostateKind {}

object UMLPseudostateKind {

  /**
    * 
    *
    * <!-- Start of user code doc for choice -->
    * <!-- End of user code doc for choice -->
    */
  case object choice extends UMLPseudostateKind {}

  /**
    * 
    *
    * <!-- Start of user code doc for deepHistory -->
    * <!-- End of user code doc for deepHistory -->
    */
  case object deepHistory extends UMLPseudostateKind {}

  /**
    * 
    *
    * <!-- Start of user code doc for entryPoint -->
    * <!-- End of user code doc for entryPoint -->
    */
  case object entryPoint extends UMLPseudostateKind {}

  /**
    * 
    *
    * <!-- Start of user code doc for exitPoint -->
    * <!-- End of user code doc for exitPoint -->
    */
  case object exitPoint extends UMLPseudostateKind {}

  /**
    * 
    *
    * <!-- Start of user code doc for fork -->
    * <!-- End of user code doc for fork -->
    */
  case object fork extends UMLPseudostateKind {}

  /**
    * 
    *
    * <!-- Start of user code doc for initial -->
    * <!-- End of user code doc for initial -->
    */
  case object initial extends UMLPseudostateKind {}

  /**
    * 
    *
    * <!-- Start of user code doc for join -->
    * <!-- End of user code doc for join -->
    */
  case object join extends UMLPseudostateKind {}

  /**
    * 
    *
    * <!-- Start of user code doc for junction -->
    * <!-- End of user code doc for junction -->
    */
  case object junction extends UMLPseudostateKind {}

  /**
    * 
    *
    * <!-- Start of user code doc for shallowHistory -->
    * <!-- End of user code doc for shallowHistory -->
    */
  case object shallowHistory extends UMLPseudostateKind {}

  /**
    * 
    *
    * <!-- Start of user code doc for terminate -->
    * <!-- End of user code doc for terminate -->
    */
  case object terminate extends UMLPseudostateKind {}
 
  implicit val writesUMLPseudostateKind
  : Writes[UMLPseudostateKind]
  = Variants.writes[UMLPseudostateKind]((__ \ "type").format[String])

  implicit val readsUMLPseudostateKind
  : Reads[UMLPseudostateKind]
  = Variants.reads[UMLPseudostateKind]((__ \ "type").format[String])

  implicit val formatsUMLPseudostateKind
  : Format[UMLPseudostateKind]
  = Variants.format[UMLPseudostateKind]((__ \ "type").format[String])
  
}
