package org.omg.oti.json.common

/**
  * Corresponds to a CMOF 2.5 Association with the additional restriction that it must be logically directed
  * from a source OTIElement to a target OTIElement.
  */
trait OTIRelationship {
  
  def source: OTIElement
  def target: OTIElement
  
}