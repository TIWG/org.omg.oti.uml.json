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

import org.omg.oti.json.common.OTIPrimitiveTypes._

import scala.{Int,Ordering}
import scala.Predef.String
import scalaz.{@@,Tag}

/**
  * The OTI characteristics for a UML Package specifying the root of an OTI Document of some kind.
  *
  * @param packageURI the Package::URI characteristic
  * @param documentURL the URL where the OTI document is externally accessible as a resource
  * @param artifactKind the kind of the OTI document
  * @param nsPrefix the XML namespace prefix for the contents of the OTI document
  * @param uuidPrefix the XMI uuid prefix for all the contents of the OTI document
  */
case class OTISpecificationRootCharacteristics
(packageURI: String @@ OTI_URI,
 documentURL: String @@ OTI_URL,
 artifactKind: OTIArtifactKind,
 nsPrefix: String @@ OTI_NS_PREFIX,
 uuidPrefix: String @@ OTI_UUID_PREFIX)

object OTISpecificationRootCharacteristics {

  implicit val ordering
  : Ordering[OTISpecificationRootCharacteristics]
  = new Ordering[OTISpecificationRootCharacteristics] {

    def compare(x: OTISpecificationRootCharacteristics, y: OTISpecificationRootCharacteristics)
    : Int
    = Tag.unwrap(x.packageURI).compareTo(Tag.unwrap(y.packageURI)) match {
      case 0 =>
        Tag.unwrap(x.documentURL).compareTo(Tag.unwrap(y.documentURL))
      case c =>
        c
    }
  }

  implicit def formats
  : Format[OTISpecificationRootCharacteristics]
  = Json.format[OTISpecificationRootCharacteristics]

}