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
  * VisibilityKind is an enumeration type that defines literals to determine the visibility of Elements in a model.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
sealed trait UMLVisibilityKind {}

object UMLVisibilityKind {

  /**
    * A NamedElement with package visibility is visible to all Elements within the nearest enclosing Package (given that other owning Elements have proper visibility). Outside the nearest enclosing Package, a NamedElement marked as having package visibility is not visible.  Only NamedElements that are not owned by Packages can be marked as having package visibility. 
    *
    * <!-- Start of user code doc for _package -->
    * <!-- End of user code doc for _package -->
    */
  case object _package extends UMLVisibilityKind {}

  /**
    * A NamedElement with private visibility is only visible inside the Namespace that owns it.
    *
    * <!-- Start of user code doc for _private -->
    * <!-- End of user code doc for _private -->
    */
  case object _private extends UMLVisibilityKind {}

  /**
    * A NamedElement with protected visibility is visible to Elements that have a generalization relationship to the Namespace that owns it.
    *
    * <!-- Start of user code doc for _protected -->
    * <!-- End of user code doc for _protected -->
    */
  case object _protected extends UMLVisibilityKind {}

  /**
    * A Named Element with public visibility is visible to all elements that can access the contents of the Namespace that owns it.
    *
    * <!-- Start of user code doc for public -->
    * <!-- End of user code doc for public -->
    */
  case object public extends UMLVisibilityKind {}
 
  implicit val writesUMLVisibilityKind
  : Writes[UMLVisibilityKind]
  = Variants.writes[UMLVisibilityKind]((__ \ "type").format[String])

  implicit val readsUMLVisibilityKind
  : Reads[UMLVisibilityKind]
  = Variants.reads[UMLVisibilityKind]((__ \ "type").format[String])

  implicit val formatsUMLVisibilityKind
  : Format[UMLVisibilityKind]
  = Variants.format[UMLVisibilityKind]((__ \ "type").format[String])
  
}
