/*
 *
 * License Terms
 *
 * Copyright (c) 2014-2016, California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * *   Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * *   Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the
 *    distribution.
 *
 * *   Neither the name of Caltech nor its operating division, the Jet
 *    Propulsion Laboratory, nor the names of its contributors may be
 *    used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.json.common

import scalaz.Tag

/**
  * Use Scalaz' Tagged type technique, `A @@ T`, enables partitioning the use of a reference type,
  * `A` into disjoint types according to the tag type `T` without adding a runtime overhead in the
  * representation of partitioned values of `A`.
  *
  * In an object-oriented perspective, it is as if `A @@ T` were defined as a subclass of
  * the class type `A` such that `A @@ T1` and `A @@ T2` would be disjoint subclasses of `A`
  *
  * In OTI, this is used for partitioning the use of the type `String` as the representation
  * for disjoint types in OTI: URI, URL ID, UUID, NS Prefix, UUID Prefix
  */
object OTIPrimitiveTypes {

  /**
    * The type `String @@ OTI_URI` is the partition of strings representing `OTI_URI` values.
    *
    * OTI_URI is the type of strings representing UML::Package::uri.
    */
  sealed trait OTI_URI
  val OTI_URI = Tag.of[OTI_URI]

  /**
    * The type `String @@ OTI_URL` is the partition of strings representing `OTI_URL` values.
    *
    * OTI_URL is the type of strings representing the external location of a loadable/serializable MOF resource
    * (a MOF resource is often called a "model"; however, this term can be confusing because it could be
    *  referring to a particular kind of UML element, specifically, an instance of the UML::Model metaclass).
    */
  sealed trait OTI_URL
  val OTI_URL = Tag.of[OTI_URL]

  /**
    * The type `String @@ OTI_NS_PREFIX` is the partition of strings representing `OTI_NS_PREFIX` values.
    *
    * The OMG XMI specification uses an XML namespace prefix for abbreviating URLs with fragments.
    * INstead of a URL of the form: `<document URL>#<element ID fragment>`,
    * the abbreviated URL is of the form: `<ns prefix>#<element ID fragment>`
    */
  sealed trait OTI_NS_PREFIX
  val OTI_NS_PREFIX = Tag.of[OTI_NS_PREFIX]

  /**
    * The type `String @@ OTI_UUID_PREFIX` is the partition of strings representing `OTI_UUID_PREFIX` values.
    *
    * For a UML Element in the context of an OTI Document, the OTI Canonical XMI ID Generation algorithm computes
    * the OTI UUID for that UML Element by prepending the OTI Document UUID Prefix
    * to the OTI ID generated for that UML Element.
    */
  sealed trait OTI_UUID_PREFIX
  val OTI_UUID_PREFIX = Tag.of[OTI_UUID_PREFIX]

  /**
    * The type `String @@ OTI_ID` is the partition of strings representing `OTI_ID` values.
    *
    * This is the type of strings corresponding to OTI IDs generated for UML Elements in the context
    * of a containing OTI Document UML Package.
    */
  sealed trait OTI_ID
  val OTI_ID = Tag.of[OTI_ID]

  /**
    * The type `String @@ OTI_UUID` is the partition of strings representing `OTI_UUID` values.
    *
    * This is the type of strings corresponding to OTI UUIDs generated for UML Elements in the context
    * of a containing OTI Document UML Package.
    */
  sealed trait OTI_UUID
  val OTI_UUID = Tag.of[OTI_UUID]
  
  /**
    * The type `String @@ TOOL_SPECIFIC_ID` is the partition of strings representing `TOOL_SPECIFIC_ID` values.
    *
    * A `TOOL_SPECIFIC_ID` string value represents a tool-specific ID
    */
  sealed trait TOOL_SPECIFIC_ID
  val TOOL_SPECIFIC_ID = Tag.of[TOOL_SPECIFIC_ID]

  /**
    * The type `String @@ TOOL_SPECIFIC_UUID` is the partition of strings representing `TOOL_SPECIFIC_UUID` values.
    *
    * A `TOOL_SPECIFIC_UUID` string value represents a tool-specific UUID
    */
  sealed trait TOOL_SPECIFIC_UUID
  val TOOL_SPECIFIC_UUID = Tag.of[TOOL_SPECIFIC_UUID]

  /**
    * The type `String @@ TOOL_SPECIFIC_URL` is the partition of strings representing `TOOL_SPECIFIC_URL` values.
    *
    * A `TOOL_SPECIFIC_URL` string value represents a tool-specific element URL
    */
  sealed trait TOOL_SPECIFIC_URL
  val TOOL_SPECIFIC_URL = Tag.of[TOOL_SPECIFIC_URL]
  
}