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

package org.omg.oti.json.common

import play.api.libs.json._

import scala.collection.immutable._

/**
  * @param documents: A set of OTIDocumentConfigurations for a set of
  *                   packages and/or profiles characterized as OTI Documents
  */
case class OTIDocumentSetConfiguration
( documents: Vector[OTIDocumentConfiguration] )
{}

object OTIDocumentSetConfiguration {

  def empty
  : OTIDocumentSetConfiguration
  = OTIDocumentSetConfiguration(documents=Vector.empty[OTIDocumentConfiguration])

  implicit def formats
  : Format[OTIDocumentSetConfiguration]
  = Json.format[OTIDocumentSetConfiguration]

}