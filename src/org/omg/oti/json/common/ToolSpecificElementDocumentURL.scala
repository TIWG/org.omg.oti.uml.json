package org.omg.oti.json.common

import scala.Predef.String
import scalaz.@@

/**
  * Tool-specific Element/Document Location
  */
case class ToolSpecificElementDocumentURL
( element_id: String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID,
  document_url: String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_URL ) 
{}