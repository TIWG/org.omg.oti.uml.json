package org.omg.oti.json.common

import play.json.extra._
import play.api.libs.json._

import scala.{Int,Ordering}
import scala.Predef.String
import scalaz.@@

/**
  * A reference to an Element located in the context of a Document.
  *
  * There are several variations according to:
  * - how to identify an element
  *   -- with an OTI ID
  *   -- with a tool-specific ID
  * - how to identify the location of the identified element
  *   -- implicitly
  *   -- explicitly with an OTI Document URL
  *   -- explicitly, with a tool-specific URL location of the identified element in a tool-specific resource
  */
sealed trait ElementLocation {}

/**
  * Element Location based on OTI ID when the OTI Document context is known.
  *
  * @param element_id    The OTI ID of the UML Element contained in the OTI Document UML Package/Profile context
  */
case class ElementLocation_OTI_ID
( element_id: String @@ OTIPrimitiveTypes.OTI_ID )
  extends ElementLocation
{}

/**
  * Element Location based on OTI ID & OTI Document URL
  *
  * @param element_id    The OTI ID of the UML Element contained in an OTI Document UML Package
  * @param document_url  The OTI URL of the external OTI Document UML Package resource containing the identified element
  */
case class ElementLocation_OTI_ID_OTI_URL
( element_id: String @@ OTIPrimitiveTypes.OTI_ID,
  document_url: String @@ OTIPrimitiveTypes.OTI_URL)
extends ElementLocation
{}

/**
  * Element Location based on Tool-specific ID & OTI Document URL
  *
  * @param element_id    The tool-specific ID of the UML Element contained in an OTI Document UML Package
  * @param document_url  The OTI URL of the external OTI Document UML Package resource containing the identified element
  */
case class ElementLocation_ToolSpecific_ID_OTI_URL
( element_id: String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID,
  document_url: String @@ OTIPrimitiveTypes.OTI_URL)
  extends ElementLocation
{}

/**
  *
  * Element Location based on Tool-specific ID & URL
  *
  * @param element_id    The tool-specific ID of the UML Element contained in an OTI Document UML Package
  * @param location_url  The tool-specific URL location of the identified element in a tool-specific resource
  */
case class ElementLocation_ToolSpecific_ID_URL
( element_id: String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID,
  location_url: String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_URL)
  extends ElementLocation
{}

object ElementLocation {

  implicit val ordering
  : Ordering[ElementLocation]
  = new Ordering[ElementLocation] {

    def compare(x: ElementLocation, y: ElementLocation)
    : Int
    = x match {
      case xel: ElementLocation_OTI_ID =>
        y match {
          case yel: ElementLocation_OTI_ID =>
            ElementLocation_OTI_ID.ordering.compare(xel, yel)
          case _ =>
            -1
        }

      case xel: ElementLocation_OTI_ID_OTI_URL =>
        y match {
          case yel: ElementLocation_OTI_ID_OTI_URL =>
            ElementLocation_OTI_ID_OTI_URL.ordering.compare(xel, yel)
          case _: ElementLocation_OTI_ID =>
            1
          case _ =>
            -1
        }

      case xel: ElementLocation_ToolSpecific_ID_OTI_URL =>
        y match {
          case yel: ElementLocation_ToolSpecific_ID_OTI_URL =>
            ElementLocation_ToolSpecific_ID_OTI_URL.ordering.compare(xel, yel)
          case _ @ (_: ElementLocation_OTI_ID | _: ElementLocation_OTI_ID_OTI_URL) =>
            1
          case _ =>
            -1
        }

      case xel: ElementLocation_ToolSpecific_ID_URL =>
        y match {
          case yel: ElementLocation_ToolSpecific_ID_URL =>
            ElementLocation_ToolSpecific_ID_URL.ordering.compare(xel, yel)
          case _ @ (_: ElementLocation_OTI_ID | _: ElementLocation_OTI_ID_OTI_URL | _: ElementLocation_ToolSpecific_ID_OTI_URL) =>
            1
        }
    }

  }

  implicit val writes
  : Writes[ElementLocation]
  = Variants.writes[ElementLocation]((__ \ "type").write[String])

  implicit val reads
  : Reads[ElementLocation]
  = Variants.reads[ElementLocation]((__ \ "type").read[String])

  implicit val formats
  : Format[ElementLocation]
  = Variants.format[ElementLocation]((__ \ "type").format[String])

}

object ElementLocation_OTI_ID {

  implicit val ordering
  : Ordering[ElementLocation_OTI_ID]
  = new Ordering[ElementLocation_OTI_ID] {

    def compare(x: ElementLocation_OTI_ID, y: ElementLocation_OTI_ID)
    : Int
    = taggedStringOrdering[OTIPrimitiveTypes.OTI_ID].compare(x.element_id, y.element_id)

  }

  implicit val writes
  : Writes[ElementLocation_OTI_ID]
  = Json.writes[ElementLocation_OTI_ID]

  implicit val reads
  : Reads[ElementLocation_OTI_ID]
  = Json.reads[ElementLocation_OTI_ID]

  implicit val formats
  : Format[ElementLocation_OTI_ID]
  = Json.format[ElementLocation_OTI_ID]

}

object ElementLocation_OTI_ID_OTI_URL {

  implicit val ordering
  : Ordering[ElementLocation_OTI_ID_OTI_URL]
  = new Ordering[ElementLocation_OTI_ID_OTI_URL] {

    def compare(x: ElementLocation_OTI_ID_OTI_URL, y: ElementLocation_OTI_ID_OTI_URL)
    : Int
    = {
      taggedStringOrdering[OTIPrimitiveTypes.OTI_URL].compare(x.document_url, y.document_url) match {
        case 0 =>
          taggedStringOrdering[OTIPrimitiveTypes.OTI_ID].compare(x.element_id, y.element_id)
        case c =>
          c
      }
    }

  }

  implicit val writes
  : Writes[ElementLocation_OTI_ID_OTI_URL]
  = Json.writes[ElementLocation_OTI_ID_OTI_URL]

  implicit val reads
  : Reads[ElementLocation_OTI_ID_OTI_URL]
  = Json.reads[ElementLocation_OTI_ID_OTI_URL]

  implicit val formats
  : Format[ElementLocation_OTI_ID_OTI_URL]
  = Json.format[ElementLocation_OTI_ID_OTI_URL]

}

object ElementLocation_ToolSpecific_ID_OTI_URL {

  implicit val ordering
  : Ordering[ElementLocation_ToolSpecific_ID_OTI_URL]
  = new Ordering[ElementLocation_ToolSpecific_ID_OTI_URL] {

    def compare(x: ElementLocation_ToolSpecific_ID_OTI_URL, y: ElementLocation_ToolSpecific_ID_OTI_URL)
    : Int
    = {
      taggedStringOrdering[OTIPrimitiveTypes.OTI_URL].compare(x.document_url, y.document_url) match {
        case 0 =>
          taggedStringOrdering[OTIPrimitiveTypes.TOOL_SPECIFIC_ID].compare(x.element_id, y.element_id)
        case c =>
          c
      }
    }

  }

  implicit val writes
  : Writes[ElementLocation_ToolSpecific_ID_OTI_URL]
  = Json.writes[ElementLocation_ToolSpecific_ID_OTI_URL]

  implicit val reads
  : Reads[ElementLocation_ToolSpecific_ID_OTI_URL]
  = Json.reads[ElementLocation_ToolSpecific_ID_OTI_URL]

  implicit val formats
  : Format[ElementLocation_ToolSpecific_ID_OTI_URL]
  = Json.format[ElementLocation_ToolSpecific_ID_OTI_URL]

}

object ElementLocation_ToolSpecific_ID_URL {

  implicit val ordering
  : Ordering[ElementLocation_ToolSpecific_ID_URL]
  = new Ordering[ElementLocation_ToolSpecific_ID_URL] {

    def compare(x: ElementLocation_ToolSpecific_ID_URL, y: ElementLocation_ToolSpecific_ID_URL)
    : Int
    = {
      taggedStringOrdering[OTIPrimitiveTypes.TOOL_SPECIFIC_URL].compare(x.location_url, y.location_url) match {
        case 0 =>
          taggedStringOrdering[OTIPrimitiveTypes.TOOL_SPECIFIC_ID].compare(x.element_id, y.element_id)
        case c =>
          c
      }
    }

  }

  implicit val writes
  : Writes[ElementLocation_ToolSpecific_ID_URL]
  = Json.writes[ElementLocation_ToolSpecific_ID_URL]

  implicit val reads
  : Reads[ElementLocation_ToolSpecific_ID_URL]
  = Json.reads[ElementLocation_ToolSpecific_ID_URL]

  implicit val formats
  : Format[ElementLocation_ToolSpecific_ID_URL]
  = Json.format[ElementLocation_ToolSpecific_ID_URL]

}