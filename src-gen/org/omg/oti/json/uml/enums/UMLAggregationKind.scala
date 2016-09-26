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
  * AggregationKind is an Enumeration for specifying the kind of aggregation of a Property.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
sealed trait UMLAggregationKind {}

object UMLAggregationKind {

  /**
    * Indicates that the Property is aggregated compositely, i.e., the composite object has responsibility for the existence and storage of the composed objects (parts).
    *
    * <!-- Start of user code doc for composite -->
    * <!-- End of user code doc for composite -->
    */
  case object composite extends UMLAggregationKind {}

  /**
    * Indicates that the Property has no aggregation.
    *
    * <!-- Start of user code doc for none -->
    * <!-- End of user code doc for none -->
    */
  case object none extends UMLAggregationKind {}

  /**
    * Indicates that the Property has shared aggregation.
    *
    * <!-- Start of user code doc for shared -->
    * <!-- End of user code doc for shared -->
    */
  case object shared extends UMLAggregationKind {}
 
  implicit val writesUMLAggregationKind
  : Writes[UMLAggregationKind]
  = Variants.writes[UMLAggregationKind]((__ \ "type").format[String])

  implicit val readsUMLAggregationKind
  : Reads[UMLAggregationKind]
  = Variants.reads[UMLAggregationKind]((__ \ "type").format[String])

  implicit val formatsUMLAggregationKind
  : Format[UMLAggregationKind]
  = Variants.format[UMLAggregationKind]((__ \ "type").format[String])
  
}
