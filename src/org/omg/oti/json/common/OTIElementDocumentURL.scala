package org.omg.oti.json.common

import scala.Predef.String
import scalaz.@@

/**
  * OTI Element/Document Location
  */
case class OTIElementDocumentURL
( element_id: String @@ OTIPrimitiveTypes.OTI_ID,
  document_url: String @@ OTIPrimitiveTypes.OTI_URL)
{}
