package org.omg.oti.json.common

import org.omg.oti.json.common.OTIPrimitiveTypes._
import scala.Option
import scala.Predef.require

/**
  * In OMG MOF 2.5, a MOF Element is an instance of exactly 1 MOF metaclass.
  * This means that for serializing a MOF Element, it is sufficient to have support for concrete MOF metaclasses.
  * OTIElement is intended to be the single parent of case classes, 1 case class per distinct concrete MOF metaclass.
  * OTIElement provides the common data attributes necessary for uniquely identifying a MOF Element that is an
  * instance of a single MOF metaclass in an OMG CMOF metamodel (e.g., OMG UML 2.5).
  * The information about the MOF metaclass will be represented as a JSon `type` field 
  * (this field is not in the OTIElement trait per se because it is generated as part of the Play/JSon serialization support)
  */
trait OTIElement {
  
  val toolSpecific_id_uuid_url: Option[TOOL_SPECIFIC_ID_UUID_URL]
  val oti_id_uuid: Option[OTI_ID_UUID]
  
  require(toolSpecific_id_uuid_url.isDefined || oti_id_uuid.isDefined)
  
}