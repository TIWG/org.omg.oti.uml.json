/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.json.uml
/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */ 

// <!-- Start of user code imports -->
import org.omg.oti.json.common._
import org.omg.oti.json.common.OTIPrimitiveTypes._

import play.json.extra._
import play.api.libs.json._
import play.api.libs.functional.syntax._

import scala.{Int,Ordering}
import scala.Predef.String
// <!-- End of user code imports -->

/**
  * <!-- Start of user code OTIMOFLink -->
  * Corresponds to a CMOF 2.5 Link with the additional restriction that it must be logically directed
  * from a source OTIMOFElement to a target OTIMOFElement.
  *
  * Each specialization of OTIMOFLink includes a description of:
  * - the name of the OMG UML 2.5 association
  * - the characteristics of the end1 and end2 association member end properties
  *
  * The description of the characteristics of each member end property has the following form:
  * [<multiplicity range>] { <ordering> <unicity> <aggregation> }
  * where:
  * <multiplicity range> follows the notation defined in OMG UML 2.5 section 7.5.4.1
  * <ordering> follows the notation defined in OMG UML 2.5 section 7.5.4.1
  * <unicity> follows the notation defined in OMG UML 2.5 section 7.5.4.1
  * <aggregation> is either 'composite' or 'reference'. 
  * Note that per OMF MOF 2.5, section 9.3, constraint [10], only one end may be 'composite'.
  * That is, either 
  * - both ends are 'reference', or
  * - one end is 'composite' and the other is 'reference'.
  * 
  * <!-- End of user code OTIMOFLink -->
  */
sealed trait OTIMOFLink {

  def end1: ElementLocation
  def end2: ElementLocation

}

/**
  * <!-- Start of user code OTIMOFCompositeLink -->
  * A MOF link for an association with one end that has composite aggregation and the other non-composite aggregation
  * <!-- End of user code OTIMOFCompositeLink -->
  */
sealed trait OTIMOFCompositeLinkAspect {}

/**
  * <!-- Start of user code OTIMOFReferenceLink -->
  * A MOF link for an association with both ends having non-composite aggregation
  * <!-- End of user code OTIMOFReferenceLink -->
  */
sealed trait OTIMOFReferenceLinkAspect {}

/**
  * <!-- Start of user code OTIMOFOrderedLink -->
  * <!-- End of user code OTIMOFOrderedLink -->
  */
sealed trait OTIMOFOrderedLinkAspect {
  def end2Index: Int
}

sealed trait OTIMOFCompositeLink 
  extends OTIMOFLink 
  with OTIMOFCompositeLinkAspect
{}

sealed trait OTIMOFCompositeOrderedLink
  extends OTIMOFLink
  with OTIMOFCompositeLinkAspect
  with OTIMOFOrderedLinkAspect
{}

sealed trait OTIMOFReferenceLink 
  extends OTIMOFLink 
  with OTIMOFReferenceLinkAspect
{}

sealed trait OTIMOFReferenceOrderedLink
  extends OTIMOFLink
  with OTIMOFReferenceLinkAspect
  with OTIMOFOrderedLinkAspect
{}

object OTIMOFLink {
  
  /**
    * A_action_interaction
    *
    * @param: end1 A_action_interaction::interaction: Interaction [0..1] { unordered, unique, reference }
    * @param: end2 Interaction::action: Action [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_action_interaction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_action_interaction {
     
    implicit def reads
    : Reads[OTIUMLA_action_interaction]
    = Json.reads[OTIUMLA_action_interaction]
  
    implicit def writes
    : Writes[OTIUMLA_action_interaction]
    = Json.writes[OTIUMLA_action_interaction]
  
    implicit def formats
    : Format[OTIUMLA_action_interaction]
    = Json.format[OTIUMLA_action_interaction]

  }

  /**
    * A_actualGate_interactionUse
    *
    * @param: end1 A_actualGate_interactionUse::interactionUse: InteractionUse [0..1] { unordered, unique, reference }
    * @param: end2 InteractionUse::actualGate: Gate [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_actualGate_interactionUse
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_actualGate_interactionUse {
     
    implicit def reads
    : Reads[OTIUMLA_actualGate_interactionUse]
    = Json.reads[OTIUMLA_actualGate_interactionUse]
  
    implicit def writes
    : Writes[OTIUMLA_actualGate_interactionUse]
    = Json.writes[OTIUMLA_actualGate_interactionUse]
  
    implicit def formats
    : Format[OTIUMLA_actualGate_interactionUse]
    = Json.format[OTIUMLA_actualGate_interactionUse]

  }

  /**
    * A_argument_interactionUse
    *
    * @param: end1 A_argument_interactionUse::interactionUse: InteractionUse [0..1] { unordered, unique, reference }
    * @param: end2 InteractionUse::argument: ValueSpecification [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_argument_interactionUse
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_argument_interactionUse {
     
    implicit def reads
    : Reads[OTIUMLA_argument_interactionUse]
    = Json.reads[OTIUMLA_argument_interactionUse]
  
    implicit def writes
    : Writes[OTIUMLA_argument_interactionUse]
    = Json.writes[OTIUMLA_argument_interactionUse]
  
    implicit def formats
    : Format[OTIUMLA_argument_interactionUse]
    = Json.format[OTIUMLA_argument_interactionUse]

  }

  /**
    * A_argument_invocationAction
    *
    * @param: end1 A_argument_invocationAction::invocationAction: InvocationAction [0..1] { unordered, unique, reference }
    * @param: end2 InvocationAction::argument: InputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_argument_invocationAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_argument_invocationAction {
     
    implicit def reads
    : Reads[OTIUMLA_argument_invocationAction]
    = Json.reads[OTIUMLA_argument_invocationAction]
  
    implicit def writes
    : Writes[OTIUMLA_argument_invocationAction]
    = Json.writes[OTIUMLA_argument_invocationAction]
  
    implicit def formats
    : Format[OTIUMLA_argument_invocationAction]
    = Json.format[OTIUMLA_argument_invocationAction]

  }

  /**
    * A_argument_message
    *
    * @param: end1 A_argument_message::message: Message [0..1] { unordered, unique, reference }
    * @param: end2 Message::argument: ValueSpecification [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_argument_message
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_argument_message {
     
    implicit def reads
    : Reads[OTIUMLA_argument_message]
    = Json.reads[OTIUMLA_argument_message]
  
    implicit def writes
    : Writes[OTIUMLA_argument_message]
    = Json.writes[OTIUMLA_argument_message]
  
    implicit def formats
    : Format[OTIUMLA_argument_message]
    = Json.format[OTIUMLA_argument_message]

  }

  /**
    * A_bodyCondition_bodyContext
    *
    * @param: end1 A_bodyCondition_bodyContext::bodyContext: Operation [0..1] { unordered, unique, reference }
    * @param: end2 Operation::bodyCondition: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_bodyCondition_bodyContext
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_bodyCondition_bodyContext {
     
    implicit def reads
    : Reads[OTIUMLA_bodyCondition_bodyContext]
    = Json.reads[OTIUMLA_bodyCondition_bodyContext]
  
    implicit def writes
    : Writes[OTIUMLA_bodyCondition_bodyContext]
    = Json.writes[OTIUMLA_bodyCondition_bodyContext]
  
    implicit def formats
    : Format[OTIUMLA_bodyCondition_bodyContext]
    = Json.format[OTIUMLA_bodyCondition_bodyContext]

  }

  /**
    * A_cfragmentGate_combinedFragment
    *
    * @param: end1 A_cfragmentGate_combinedFragment::combinedFragment: CombinedFragment [0..1] { unordered, unique, reference }
    * @param: end2 CombinedFragment::cfragmentGate: Gate [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_cfragmentGate_combinedFragment
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_cfragmentGate_combinedFragment {
     
    implicit def reads
    : Reads[OTIUMLA_cfragmentGate_combinedFragment]
    = Json.reads[OTIUMLA_cfragmentGate_combinedFragment]
  
    implicit def writes
    : Writes[OTIUMLA_cfragmentGate_combinedFragment]
    = Json.writes[OTIUMLA_cfragmentGate_combinedFragment]
  
    implicit def formats
    : Format[OTIUMLA_cfragmentGate_combinedFragment]
    = Json.format[OTIUMLA_cfragmentGate_combinedFragment]

  }

  /**
    * A_changeExpression_changeEvent
    *
    * @param: end1 A_changeExpression_changeEvent::changeEvent: ChangeEvent [0..1] { unordered, unique, reference }
    * @param: end2 ChangeEvent::changeExpression: ValueSpecification [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_changeExpression_changeEvent
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_changeExpression_changeEvent {
     
    implicit def reads
    : Reads[OTIUMLA_changeExpression_changeEvent]
    = Json.reads[OTIUMLA_changeExpression_changeEvent]
  
    implicit def writes
    : Writes[OTIUMLA_changeExpression_changeEvent]
    = Json.writes[OTIUMLA_changeExpression_changeEvent]
  
    implicit def formats
    : Format[OTIUMLA_changeExpression_changeEvent]
    = Json.format[OTIUMLA_changeExpression_changeEvent]

  }

  /**
    * A_clause_conditionalNode
    *
    * @param: end1 A_clause_conditionalNode::conditionalNode: ConditionalNode [1..1] { unordered, unique, reference }
    * @param: end2 ConditionalNode::clause: Clause [1..*] { unordered, unique, composite }
    */
  case class OTIUMLA_clause_conditionalNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_clause_conditionalNode {
     
    implicit def reads
    : Reads[OTIUMLA_clause_conditionalNode]
    = Json.reads[OTIUMLA_clause_conditionalNode]
  
    implicit def writes
    : Writes[OTIUMLA_clause_conditionalNode]
    = Json.writes[OTIUMLA_clause_conditionalNode]
  
    implicit def formats
    : Format[OTIUMLA_clause_conditionalNode]
    = Json.format[OTIUMLA_clause_conditionalNode]

  }

  /**
    * A_collaborationUse_classifier
    *
    * @param: end1 A_collaborationUse_classifier::classifier: Classifier [0..1] { unordered, unique, reference }
    * @param: end2 Classifier::collaborationUse: CollaborationUse [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_collaborationUse_classifier
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_collaborationUse_classifier {
     
    implicit def reads
    : Reads[OTIUMLA_collaborationUse_classifier]
    = Json.reads[OTIUMLA_collaborationUse_classifier]
  
    implicit def writes
    : Writes[OTIUMLA_collaborationUse_classifier]
    = Json.writes[OTIUMLA_collaborationUse_classifier]
  
    implicit def formats
    : Format[OTIUMLA_collaborationUse_classifier]
    = Json.format[OTIUMLA_collaborationUse_classifier]

  }

  /**
    * A_collection_reduceAction
    *
    * @param: end1 A_collection_reduceAction::reduceAction: ReduceAction [0..1] { unordered, unique, reference }
    * @param: end2 ReduceAction::collection: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_collection_reduceAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_collection_reduceAction {
     
    implicit def reads
    : Reads[OTIUMLA_collection_reduceAction]
    = Json.reads[OTIUMLA_collection_reduceAction]
  
    implicit def writes
    : Writes[OTIUMLA_collection_reduceAction]
    = Json.writes[OTIUMLA_collection_reduceAction]
  
    implicit def formats
    : Format[OTIUMLA_collection_reduceAction]
    = Json.format[OTIUMLA_collection_reduceAction]

  }

  /**
    * A_condition_extend
    *
    * @param: end1 A_condition_extend::extend: Extend [0..1] { unordered, unique, reference }
    * @param: end2 Extend::condition: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_condition_extend
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_condition_extend {
     
    implicit def reads
    : Reads[OTIUMLA_condition_extend]
    = Json.reads[OTIUMLA_condition_extend]
  
    implicit def writes
    : Writes[OTIUMLA_condition_extend]
    = Json.writes[OTIUMLA_condition_extend]
  
    implicit def formats
    : Format[OTIUMLA_condition_extend]
    = Json.format[OTIUMLA_condition_extend]

  }

  /**
    * A_condition_parameterSet
    *
    * @param: end1 A_condition_parameterSet::parameterSet: ParameterSet [0..1] { unordered, unique, reference }
    * @param: end2 ParameterSet::condition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_condition_parameterSet
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_condition_parameterSet {
     
    implicit def reads
    : Reads[OTIUMLA_condition_parameterSet]
    = Json.reads[OTIUMLA_condition_parameterSet]
  
    implicit def writes
    : Writes[OTIUMLA_condition_parameterSet]
    = Json.writes[OTIUMLA_condition_parameterSet]
  
    implicit def formats
    : Format[OTIUMLA_condition_parameterSet]
    = Json.format[OTIUMLA_condition_parameterSet]

  }

  /**
    * A_configuration_deployment
    *
    * @param: end1 DeploymentSpecification::deployment: Deployment [0..1] { unordered, unique, reference }
    * @param: end2 Deployment::configuration: DeploymentSpecification [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_configuration_deployment
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_configuration_deployment {
     
    implicit def reads
    : Reads[OTIUMLA_configuration_deployment]
    = Json.reads[OTIUMLA_configuration_deployment]
  
    implicit def writes
    : Writes[OTIUMLA_configuration_deployment]
    = Json.writes[OTIUMLA_configuration_deployment]
  
    implicit def formats
    : Format[OTIUMLA_configuration_deployment]
    = Json.format[OTIUMLA_configuration_deployment]

  }

  /**
    * A_conformance_specificMachine
    *
    * @param: end1 ProtocolConformance::specificMachine: ProtocolStateMachine [1..1] { unordered, unique, reference }
    * @param: end2 ProtocolStateMachine::conformance: ProtocolConformance [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_conformance_specificMachine
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_conformance_specificMachine {
     
    implicit def reads
    : Reads[OTIUMLA_conformance_specificMachine]
    = Json.reads[OTIUMLA_conformance_specificMachine]
  
    implicit def writes
    : Writes[OTIUMLA_conformance_specificMachine]
    = Json.writes[OTIUMLA_conformance_specificMachine]
  
    implicit def formats
    : Format[OTIUMLA_conformance_specificMachine]
    = Json.format[OTIUMLA_conformance_specificMachine]

  }

  /**
    * A_connectionPoint_state
    *
    * @param: end1 Pseudostate::state: State [0..1] { unordered, unique, reference }
    * @param: end2 State::connectionPoint: Pseudostate [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_connectionPoint_state
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_connectionPoint_state {
     
    implicit def reads
    : Reads[OTIUMLA_connectionPoint_state]
    = Json.reads[OTIUMLA_connectionPoint_state]
  
    implicit def writes
    : Writes[OTIUMLA_connectionPoint_state]
    = Json.writes[OTIUMLA_connectionPoint_state]
  
    implicit def formats
    : Format[OTIUMLA_connectionPoint_state]
    = Json.format[OTIUMLA_connectionPoint_state]

  }

  /**
    * A_connectionPoint_stateMachine
    *
    * @param: end1 Pseudostate::stateMachine: StateMachine [0..1] { unordered, unique, reference }
    * @param: end2 StateMachine::connectionPoint: Pseudostate [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_connectionPoint_stateMachine
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_connectionPoint_stateMachine {
     
    implicit def reads
    : Reads[OTIUMLA_connectionPoint_stateMachine]
    = Json.reads[OTIUMLA_connectionPoint_stateMachine]
  
    implicit def writes
    : Writes[OTIUMLA_connectionPoint_stateMachine]
    = Json.writes[OTIUMLA_connectionPoint_stateMachine]
  
    implicit def formats
    : Format[OTIUMLA_connectionPoint_stateMachine]
    = Json.format[OTIUMLA_connectionPoint_stateMachine]

  }

  /**
    * A_connection_state
    *
    * @param: end1 ConnectionPointReference::state: State [0..1] { unordered, unique, reference }
    * @param: end2 State::connection: ConnectionPointReference [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_connection_state
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_connection_state {
     
    implicit def reads
    : Reads[OTIUMLA_connection_state]
    = Json.reads[OTIUMLA_connection_state]
  
    implicit def writes
    : Writes[OTIUMLA_connection_state]
    = Json.writes[OTIUMLA_connection_state]
  
    implicit def formats
    : Format[OTIUMLA_connection_state]
    = Json.format[OTIUMLA_connection_state]

  }

  /**
    * A_defaultValue_owningParameter
    *
    * @param: end1 A_defaultValue_owningParameter::owningParameter: Parameter [0..1] { unordered, unique, reference }
    * @param: end2 Parameter::defaultValue: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_defaultValue_owningParameter
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_defaultValue_owningParameter {
     
    implicit def reads
    : Reads[OTIUMLA_defaultValue_owningParameter]
    = Json.reads[OTIUMLA_defaultValue_owningParameter]
  
    implicit def writes
    : Writes[OTIUMLA_defaultValue_owningParameter]
    = Json.writes[OTIUMLA_defaultValue_owningParameter]
  
    implicit def formats
    : Format[OTIUMLA_defaultValue_owningParameter]
    = Json.format[OTIUMLA_defaultValue_owningParameter]

  }

  /**
    * A_defaultValue_owningProperty
    *
    * @param: end1 A_defaultValue_owningProperty::owningProperty: Property [0..1] { unordered, unique, reference }
    * @param: end2 Property::defaultValue: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_defaultValue_owningProperty
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_defaultValue_owningProperty {
     
    implicit def reads
    : Reads[OTIUMLA_defaultValue_owningProperty]
    = Json.reads[OTIUMLA_defaultValue_owningProperty]
  
    implicit def writes
    : Writes[OTIUMLA_defaultValue_owningProperty]
    = Json.writes[OTIUMLA_defaultValue_owningProperty]
  
    implicit def formats
    : Format[OTIUMLA_defaultValue_owningProperty]
    = Json.format[OTIUMLA_defaultValue_owningProperty]

  }

  /**
    * A_deferrableTrigger_state
    *
    * @param: end1 A_deferrableTrigger_state::state: State [0..1] { unordered, unique, reference }
    * @param: end2 State::deferrableTrigger: Trigger [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_deferrableTrigger_state
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_deferrableTrigger_state {
     
    implicit def reads
    : Reads[OTIUMLA_deferrableTrigger_state]
    = Json.reads[OTIUMLA_deferrableTrigger_state]
  
    implicit def writes
    : Writes[OTIUMLA_deferrableTrigger_state]
    = Json.writes[OTIUMLA_deferrableTrigger_state]
  
    implicit def formats
    : Format[OTIUMLA_deferrableTrigger_state]
    = Json.format[OTIUMLA_deferrableTrigger_state]

  }

  /**
    * A_deployment_location
    *
    * @param: end1 Deployment::location: DeploymentTarget [1..1] { unordered, unique, reference }
    * @param: end2 DeploymentTarget::deployment: Deployment [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_deployment_location
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_deployment_location {
     
    implicit def reads
    : Reads[OTIUMLA_deployment_location]
    = Json.reads[OTIUMLA_deployment_location]
  
    implicit def writes
    : Writes[OTIUMLA_deployment_location]
    = Json.writes[OTIUMLA_deployment_location]
  
    implicit def formats
    : Format[OTIUMLA_deployment_location]
    = Json.format[OTIUMLA_deployment_location]

  }

  /**
    * A_doActivity_state
    *
    * @param: end1 A_doActivity_state::state: State [0..1] { unordered, unique, reference }
    * @param: end2 State::doActivity: Behavior [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_doActivity_state
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_doActivity_state {
     
    implicit def reads
    : Reads[OTIUMLA_doActivity_state]
    = Json.reads[OTIUMLA_doActivity_state]
  
    implicit def writes
    : Writes[OTIUMLA_doActivity_state]
    = Json.writes[OTIUMLA_doActivity_state]
  
    implicit def formats
    : Format[OTIUMLA_doActivity_state]
    = Json.format[OTIUMLA_doActivity_state]

  }

  /**
    * A_edge_activity
    *
    * @param: end1 ActivityEdge::activity: Activity [0..1] { unordered, unique, reference }
    * @param: end2 Activity::edge: ActivityEdge [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_edge_activity
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_edge_activity {
     
    implicit def reads
    : Reads[OTIUMLA_edge_activity]
    = Json.reads[OTIUMLA_edge_activity]
  
    implicit def writes
    : Writes[OTIUMLA_edge_activity]
    = Json.writes[OTIUMLA_edge_activity]
  
    implicit def formats
    : Format[OTIUMLA_edge_activity]
    = Json.format[OTIUMLA_edge_activity]

  }

  /**
    * A_edge_inStructuredNode
    *
    * @param: end1 ActivityEdge::inStructuredNode: StructuredActivityNode [0..1] { unordered, unique, reference }
    * @param: end2 StructuredActivityNode::edge: ActivityEdge [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_edge_inStructuredNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_edge_inStructuredNode {
     
    implicit def reads
    : Reads[OTIUMLA_edge_inStructuredNode]
    = Json.reads[OTIUMLA_edge_inStructuredNode]
  
    implicit def writes
    : Writes[OTIUMLA_edge_inStructuredNode]
    = Json.writes[OTIUMLA_edge_inStructuredNode]
  
    implicit def formats
    : Format[OTIUMLA_edge_inStructuredNode]
    = Json.format[OTIUMLA_edge_inStructuredNode]

  }

  /**
    * A_effect_transition
    *
    * @param: end1 A_effect_transition::transition: Transition [0..1] { unordered, unique, reference }
    * @param: end2 Transition::effect: Behavior [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_effect_transition
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_effect_transition {
     
    implicit def reads
    : Reads[OTIUMLA_effect_transition]
    = Json.reads[OTIUMLA_effect_transition]
  
    implicit def writes
    : Writes[OTIUMLA_effect_transition]
    = Json.writes[OTIUMLA_effect_transition]
  
    implicit def formats
    : Format[OTIUMLA_effect_transition]
    = Json.format[OTIUMLA_effect_transition]

  }

  /**
    * A_elementImport_importingNamespace
    *
    * @param: end1 ElementImport::importingNamespace: Namespace [1..1] { unordered, unique, reference }
    * @param: end2 Namespace::elementImport: ElementImport [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_elementImport_importingNamespace
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_elementImport_importingNamespace {
     
    implicit def reads
    : Reads[OTIUMLA_elementImport_importingNamespace]
    = Json.reads[OTIUMLA_elementImport_importingNamespace]
  
    implicit def writes
    : Writes[OTIUMLA_elementImport_importingNamespace]
    = Json.writes[OTIUMLA_elementImport_importingNamespace]
  
    implicit def formats
    : Format[OTIUMLA_elementImport_importingNamespace]
    = Json.format[OTIUMLA_elementImport_importingNamespace]

  }

  /**
    * A_endData_createLinkAction
    *
    * @param: end1 A_endData_createLinkAction::createLinkAction: CreateLinkAction [1..1] { unordered, unique, reference }
    * @param: end2 CreateLinkAction::endData: LinkEndCreationData [2..*] { unordered, unique, composite }
    */
  case class OTIUMLA_endData_createLinkAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_endData_createLinkAction {
     
    implicit def reads
    : Reads[OTIUMLA_endData_createLinkAction]
    = Json.reads[OTIUMLA_endData_createLinkAction]
  
    implicit def writes
    : Writes[OTIUMLA_endData_createLinkAction]
    = Json.writes[OTIUMLA_endData_createLinkAction]
  
    implicit def formats
    : Format[OTIUMLA_endData_createLinkAction]
    = Json.format[OTIUMLA_endData_createLinkAction]

  }

  /**
    * A_endData_destroyLinkAction
    *
    * @param: end1 A_endData_destroyLinkAction::destroyLinkAction: DestroyLinkAction [1..1] { unordered, unique, reference }
    * @param: end2 DestroyLinkAction::endData: LinkEndDestructionData [2..*] { unordered, unique, composite }
    */
  case class OTIUMLA_endData_destroyLinkAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_endData_destroyLinkAction {
     
    implicit def reads
    : Reads[OTIUMLA_endData_destroyLinkAction]
    = Json.reads[OTIUMLA_endData_destroyLinkAction]
  
    implicit def writes
    : Writes[OTIUMLA_endData_destroyLinkAction]
    = Json.writes[OTIUMLA_endData_destroyLinkAction]
  
    implicit def formats
    : Format[OTIUMLA_endData_destroyLinkAction]
    = Json.format[OTIUMLA_endData_destroyLinkAction]

  }

  /**
    * A_endData_linkAction
    *
    * @param: end1 A_endData_linkAction::linkAction: LinkAction [1..1] { unordered, unique, reference }
    * @param: end2 LinkAction::endData: LinkEndData [2..*] { unordered, unique, composite }
    */
  case class OTIUMLA_endData_linkAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_endData_linkAction {
     
    implicit def reads
    : Reads[OTIUMLA_endData_linkAction]
    = Json.reads[OTIUMLA_endData_linkAction]
  
    implicit def writes
    : Writes[OTIUMLA_endData_linkAction]
    = Json.writes[OTIUMLA_endData_linkAction]
  
    implicit def formats
    : Format[OTIUMLA_endData_linkAction]
    = Json.format[OTIUMLA_endData_linkAction]

  }

  /**
    * A_end_connector
    *
    * @param: end1 A_end_connector::connector: Connector [1..1] { unordered, unique, reference }
    * @param: end2 Connector::end: ConnectorEnd [2..*] { ordered, unique, composite }
    */
  case class OTIUMLA_end_connector
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_end_connector {
     
    implicit def reads
    : Reads[OTIUMLA_end_connector]
    = Json.reads[OTIUMLA_end_connector]
  
    implicit def writes
    : Writes[OTIUMLA_end_connector]
    = Json.writes[OTIUMLA_end_connector]
  
    implicit def formats
    : Format[OTIUMLA_end_connector]
    = Json.format[OTIUMLA_end_connector]

  }

  /**
    * A_entry_state
    *
    * @param: end1 A_entry_state::state: State [0..1] { unordered, unique, reference }
    * @param: end2 State::entry: Behavior [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_entry_state
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_entry_state {
     
    implicit def reads
    : Reads[OTIUMLA_entry_state]
    = Json.reads[OTIUMLA_entry_state]
  
    implicit def writes
    : Writes[OTIUMLA_entry_state]
    = Json.writes[OTIUMLA_entry_state]
  
    implicit def formats
    : Format[OTIUMLA_entry_state]
    = Json.format[OTIUMLA_entry_state]

  }

  /**
    * A_exception_raiseExceptionAction
    *
    * @param: end1 A_exception_raiseExceptionAction::raiseExceptionAction: RaiseExceptionAction [0..1] { unordered, unique, reference }
    * @param: end2 RaiseExceptionAction::exception: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_exception_raiseExceptionAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_exception_raiseExceptionAction {
     
    implicit def reads
    : Reads[OTIUMLA_exception_raiseExceptionAction]
    = Json.reads[OTIUMLA_exception_raiseExceptionAction]
  
    implicit def writes
    : Writes[OTIUMLA_exception_raiseExceptionAction]
    = Json.writes[OTIUMLA_exception_raiseExceptionAction]
  
    implicit def formats
    : Format[OTIUMLA_exception_raiseExceptionAction]
    = Json.format[OTIUMLA_exception_raiseExceptionAction]

  }

  /**
    * A_executableNode_sequenceNode
    *
    * @param: end1 A_executableNode_sequenceNode::sequenceNode: SequenceNode [0..1] { unordered, unique, reference }
    * @param: end2 SequenceNode::executableNode: ExecutableNode [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_executableNode_sequenceNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_executableNode_sequenceNode {
     
    implicit def reads
    : Reads[OTIUMLA_executableNode_sequenceNode]
    = Json.reads[OTIUMLA_executableNode_sequenceNode]
  
    implicit def writes
    : Writes[OTIUMLA_executableNode_sequenceNode]
    = Json.writes[OTIUMLA_executableNode_sequenceNode]
  
    implicit def formats
    : Format[OTIUMLA_executableNode_sequenceNode]
    = Json.format[OTIUMLA_executableNode_sequenceNode]

  }

  /**
    * A_exit_state
    *
    * @param: end1 A_exit_state::state: State [0..1] { unordered, unique, reference }
    * @param: end2 State::exit: Behavior [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_exit_state
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_exit_state {
     
    implicit def reads
    : Reads[OTIUMLA_exit_state]
    = Json.reads[OTIUMLA_exit_state]
  
    implicit def writes
    : Writes[OTIUMLA_exit_state]
    = Json.writes[OTIUMLA_exit_state]
  
    implicit def formats
    : Format[OTIUMLA_exit_state]
    = Json.format[OTIUMLA_exit_state]

  }

  /**
    * A_expr_duration
    *
    * @param: end1 A_expr_duration::duration: Duration [0..1] { unordered, unique, reference }
    * @param: end2 Duration::expr: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_expr_duration
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_expr_duration {
     
    implicit def reads
    : Reads[OTIUMLA_expr_duration]
    = Json.reads[OTIUMLA_expr_duration]
  
    implicit def writes
    : Writes[OTIUMLA_expr_duration]
    = Json.writes[OTIUMLA_expr_duration]
  
    implicit def formats
    : Format[OTIUMLA_expr_duration]
    = Json.format[OTIUMLA_expr_duration]

  }

  /**
    * A_expr_timeExpression
    *
    * @param: end1 A_expr_timeExpression::timeExpression: TimeExpression [0..1] { unordered, unique, reference }
    * @param: end2 TimeExpression::expr: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_expr_timeExpression
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_expr_timeExpression {
     
    implicit def reads
    : Reads[OTIUMLA_expr_timeExpression]
    = Json.reads[OTIUMLA_expr_timeExpression]
  
    implicit def writes
    : Writes[OTIUMLA_expr_timeExpression]
    = Json.writes[OTIUMLA_expr_timeExpression]
  
    implicit def formats
    : Format[OTIUMLA_expr_timeExpression]
    = Json.format[OTIUMLA_expr_timeExpression]

  }

  /**
    * A_extend_extension
    *
    * @param: end1 Extend::extension: UseCase [1..1] { unordered, unique, reference }
    * @param: end2 UseCase::extend: Extend [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_extend_extension
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_extend_extension {
     
    implicit def reads
    : Reads[OTIUMLA_extend_extension]
    = Json.reads[OTIUMLA_extend_extension]
  
    implicit def writes
    : Writes[OTIUMLA_extend_extension]
    = Json.writes[OTIUMLA_extend_extension]
  
    implicit def formats
    : Format[OTIUMLA_extend_extension]
    = Json.format[OTIUMLA_extend_extension]

  }

  /**
    * A_extensionPoint_useCase
    *
    * @param: end1 ExtensionPoint::useCase: UseCase [1..1] { unordered, unique, reference }
    * @param: end2 UseCase::extensionPoint: ExtensionPoint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_extensionPoint_useCase
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_extensionPoint_useCase {
     
    implicit def reads
    : Reads[OTIUMLA_extensionPoint_useCase]
    = Json.reads[OTIUMLA_extensionPoint_useCase]
  
    implicit def writes
    : Writes[OTIUMLA_extensionPoint_useCase]
    = Json.writes[OTIUMLA_extensionPoint_useCase]
  
    implicit def formats
    : Format[OTIUMLA_extensionPoint_useCase]
    = Json.format[OTIUMLA_extensionPoint_useCase]

  }

  /**
    * A_first_testIdentityAction
    *
    * @param: end1 A_first_testIdentityAction::testIdentityAction: TestIdentityAction [0..1] { unordered, unique, reference }
    * @param: end2 TestIdentityAction::first: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_first_testIdentityAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_first_testIdentityAction {
     
    implicit def reads
    : Reads[OTIUMLA_first_testIdentityAction]
    = Json.reads[OTIUMLA_first_testIdentityAction]
  
    implicit def writes
    : Writes[OTIUMLA_first_testIdentityAction]
    = Json.writes[OTIUMLA_first_testIdentityAction]
  
    implicit def formats
    : Format[OTIUMLA_first_testIdentityAction]
    = Json.format[OTIUMLA_first_testIdentityAction]

  }

  /**
    * A_formalGate_interaction
    *
    * @param: end1 A_formalGate_interaction::interaction: Interaction [0..1] { unordered, unique, reference }
    * @param: end2 Interaction::formalGate: Gate [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_formalGate_interaction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_formalGate_interaction {
     
    implicit def reads
    : Reads[OTIUMLA_formalGate_interaction]
    = Json.reads[OTIUMLA_formalGate_interaction]
  
    implicit def writes
    : Writes[OTIUMLA_formalGate_interaction]
    = Json.writes[OTIUMLA_formalGate_interaction]
  
    implicit def formats
    : Format[OTIUMLA_formalGate_interaction]
    = Json.format[OTIUMLA_formalGate_interaction]

  }

  /**
    * A_fragment_enclosingInteraction
    *
    * @param: end1 InteractionFragment::enclosingInteraction: Interaction [0..1] { unordered, unique, reference }
    * @param: end2 Interaction::fragment: InteractionFragment [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_fragment_enclosingInteraction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_fragment_enclosingInteraction {
     
    implicit def reads
    : Reads[OTIUMLA_fragment_enclosingInteraction]
    = Json.reads[OTIUMLA_fragment_enclosingInteraction]
  
    implicit def writes
    : Writes[OTIUMLA_fragment_enclosingInteraction]
    = Json.writes[OTIUMLA_fragment_enclosingInteraction]
  
    implicit def formats
    : Format[OTIUMLA_fragment_enclosingInteraction]
    = Json.format[OTIUMLA_fragment_enclosingInteraction]

  }

  /**
    * A_fragment_enclosingOperand
    *
    * @param: end1 InteractionFragment::enclosingOperand: InteractionOperand [0..1] { unordered, unique, reference }
    * @param: end2 InteractionOperand::fragment: InteractionFragment [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_fragment_enclosingOperand
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_fragment_enclosingOperand {
     
    implicit def reads
    : Reads[OTIUMLA_fragment_enclosingOperand]
    = Json.reads[OTIUMLA_fragment_enclosingOperand]
  
    implicit def writes
    : Writes[OTIUMLA_fragment_enclosingOperand]
    = Json.writes[OTIUMLA_fragment_enclosingOperand]
  
    implicit def formats
    : Format[OTIUMLA_fragment_enclosingOperand]
    = Json.format[OTIUMLA_fragment_enclosingOperand]

  }

  /**
    * A_fromAction_actionInputPin
    *
    * @param: end1 A_fromAction_actionInputPin::actionInputPin: ActionInputPin [0..1] { unordered, unique, reference }
    * @param: end2 ActionInputPin::fromAction: Action [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_fromAction_actionInputPin
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_fromAction_actionInputPin {
     
    implicit def reads
    : Reads[OTIUMLA_fromAction_actionInputPin]
    = Json.reads[OTIUMLA_fromAction_actionInputPin]
  
    implicit def writes
    : Writes[OTIUMLA_fromAction_actionInputPin]
    = Json.writes[OTIUMLA_fromAction_actionInputPin]
  
    implicit def formats
    : Format[OTIUMLA_fromAction_actionInputPin]
    = Json.format[OTIUMLA_fromAction_actionInputPin]

  }

  /**
    * A_generalOrdering_interactionFragment
    *
    * @param: end1 A_generalOrdering_interactionFragment::interactionFragment: InteractionFragment [0..1] { unordered, unique, reference }
    * @param: end2 InteractionFragment::generalOrdering: GeneralOrdering [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_generalOrdering_interactionFragment
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_generalOrdering_interactionFragment {
     
    implicit def reads
    : Reads[OTIUMLA_generalOrdering_interactionFragment]
    = Json.reads[OTIUMLA_generalOrdering_interactionFragment]
  
    implicit def writes
    : Writes[OTIUMLA_generalOrdering_interactionFragment]
    = Json.writes[OTIUMLA_generalOrdering_interactionFragment]
  
    implicit def formats
    : Format[OTIUMLA_generalOrdering_interactionFragment]
    = Json.format[OTIUMLA_generalOrdering_interactionFragment]

  }

  /**
    * A_generalization_specific
    *
    * @param: end1 Generalization::specific: Classifier [1..1] { unordered, unique, reference }
    * @param: end2 Classifier::generalization: Generalization [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_generalization_specific
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_generalization_specific {
     
    implicit def reads
    : Reads[OTIUMLA_generalization_specific]
    = Json.reads[OTIUMLA_generalization_specific]
  
    implicit def writes
    : Writes[OTIUMLA_generalization_specific]
    = Json.writes[OTIUMLA_generalization_specific]
  
    implicit def formats
    : Format[OTIUMLA_generalization_specific]
    = Json.format[OTIUMLA_generalization_specific]

  }

  /**
    * A_group_inActivity
    *
    * @param: end1 ActivityGroup::inActivity: Activity [0..1] { unordered, unique, reference }
    * @param: end2 Activity::group: ActivityGroup [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_group_inActivity
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_group_inActivity {
     
    implicit def reads
    : Reads[OTIUMLA_group_inActivity]
    = Json.reads[OTIUMLA_group_inActivity]
  
    implicit def writes
    : Writes[OTIUMLA_group_inActivity]
    = Json.writes[OTIUMLA_group_inActivity]
  
    implicit def formats
    : Format[OTIUMLA_group_inActivity]
    = Json.format[OTIUMLA_group_inActivity]

  }

  /**
    * A_guard_activityEdge
    *
    * @param: end1 A_guard_activityEdge::activityEdge: ActivityEdge [0..1] { unordered, unique, reference }
    * @param: end2 ActivityEdge::guard: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_guard_activityEdge
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_guard_activityEdge {
     
    implicit def reads
    : Reads[OTIUMLA_guard_activityEdge]
    = Json.reads[OTIUMLA_guard_activityEdge]
  
    implicit def writes
    : Writes[OTIUMLA_guard_activityEdge]
    = Json.writes[OTIUMLA_guard_activityEdge]
  
    implicit def formats
    : Format[OTIUMLA_guard_activityEdge]
    = Json.format[OTIUMLA_guard_activityEdge]

  }

  /**
    * A_guard_interactionOperand
    *
    * @param: end1 A_guard_interactionOperand::interactionOperand: InteractionOperand [1..1] { unordered, unique, reference }
    * @param: end2 InteractionOperand::guard: InteractionConstraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_guard_interactionOperand
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_guard_interactionOperand {
     
    implicit def reads
    : Reads[OTIUMLA_guard_interactionOperand]
    = Json.reads[OTIUMLA_guard_interactionOperand]
  
    implicit def writes
    : Writes[OTIUMLA_guard_interactionOperand]
    = Json.writes[OTIUMLA_guard_interactionOperand]
  
    implicit def formats
    : Format[OTIUMLA_guard_interactionOperand]
    = Json.format[OTIUMLA_guard_interactionOperand]

  }

  /**
    * A_guard_transition
    *
    * @param: end1 A_guard_transition::transition: Transition [0..1] { unordered, unique, reference }
    * @param: end2 Transition::guard: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_guard_transition
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_guard_transition {
     
    implicit def reads
    : Reads[OTIUMLA_guard_transition]
    = Json.reads[OTIUMLA_guard_transition]
  
    implicit def writes
    : Writes[OTIUMLA_guard_transition]
    = Json.writes[OTIUMLA_guard_transition]
  
    implicit def formats
    : Format[OTIUMLA_guard_transition]
    = Json.format[OTIUMLA_guard_transition]

  }

  /**
    * A_handler_protectedNode
    *
    * @param: end1 ExceptionHandler::protectedNode: ExecutableNode [1..1] { unordered, unique, reference }
    * @param: end2 ExecutableNode::handler: ExceptionHandler [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_handler_protectedNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_handler_protectedNode {
     
    implicit def reads
    : Reads[OTIUMLA_handler_protectedNode]
    = Json.reads[OTIUMLA_handler_protectedNode]
  
    implicit def writes
    : Writes[OTIUMLA_handler_protectedNode]
    = Json.writes[OTIUMLA_handler_protectedNode]
  
    implicit def formats
    : Format[OTIUMLA_handler_protectedNode]
    = Json.format[OTIUMLA_handler_protectedNode]

  }

  /**
    * A_icon_stereotype
    *
    * @param: end1 A_icon_stereotype::stereotype: Stereotype [0..1] { unordered, unique, reference }
    * @param: end2 Stereotype::icon: Image [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_icon_stereotype
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_icon_stereotype {
     
    implicit def reads
    : Reads[OTIUMLA_icon_stereotype]
    = Json.reads[OTIUMLA_icon_stereotype]
  
    implicit def writes
    : Writes[OTIUMLA_icon_stereotype]
    = Json.writes[OTIUMLA_icon_stereotype]
  
    implicit def formats
    : Format[OTIUMLA_icon_stereotype]
    = Json.format[OTIUMLA_icon_stereotype]

  }

  /**
    * A_include_includingCase
    *
    * @param: end1 Include::includingCase: UseCase [1..1] { unordered, unique, reference }
    * @param: end2 UseCase::include: Include [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_include_includingCase
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_include_includingCase {
     
    implicit def reads
    : Reads[OTIUMLA_include_includingCase]
    = Json.reads[OTIUMLA_include_includingCase]
  
    implicit def writes
    : Writes[OTIUMLA_include_includingCase]
    = Json.writes[OTIUMLA_include_includingCase]
  
    implicit def formats
    : Format[OTIUMLA_include_includingCase]
    = Json.format[OTIUMLA_include_includingCase]

  }

  /**
    * A_inputValue_linkAction
    *
    * @param: end1 A_inputValue_linkAction::linkAction: LinkAction [0..1] { unordered, unique, reference }
    * @param: end2 LinkAction::inputValue: InputPin [1..*] { unordered, unique, composite }
    */
  case class OTIUMLA_inputValue_linkAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_inputValue_linkAction {
     
    implicit def reads
    : Reads[OTIUMLA_inputValue_linkAction]
    = Json.reads[OTIUMLA_inputValue_linkAction]
  
    implicit def writes
    : Writes[OTIUMLA_inputValue_linkAction]
    = Json.writes[OTIUMLA_inputValue_linkAction]
  
    implicit def formats
    : Format[OTIUMLA_inputValue_linkAction]
    = Json.format[OTIUMLA_inputValue_linkAction]

  }

  /**
    * A_inputValue_opaqueAction
    *
    * @param: end1 A_inputValue_opaqueAction::opaqueAction: OpaqueAction [0..1] { unordered, unique, reference }
    * @param: end2 OpaqueAction::inputValue: InputPin [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_inputValue_opaqueAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_inputValue_opaqueAction {
     
    implicit def reads
    : Reads[OTIUMLA_inputValue_opaqueAction]
    = Json.reads[OTIUMLA_inputValue_opaqueAction]
  
    implicit def writes
    : Writes[OTIUMLA_inputValue_opaqueAction]
    = Json.writes[OTIUMLA_inputValue_opaqueAction]
  
    implicit def formats
    : Format[OTIUMLA_inputValue_opaqueAction]
    = Json.format[OTIUMLA_inputValue_opaqueAction]

  }

  /**
    * A_insertAt_addStructuralFeatureValueAction
    *
    * @param: end1 A_insertAt_addStructuralFeatureValueAction::addStructuralFeatureValueAction: AddStructuralFeatureValueAction [0..1] { unordered, unique, reference }
    * @param: end2 AddStructuralFeatureValueAction::insertAt: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_insertAt_addStructuralFeatureValueAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_insertAt_addStructuralFeatureValueAction {
     
    implicit def reads
    : Reads[OTIUMLA_insertAt_addStructuralFeatureValueAction]
    = Json.reads[OTIUMLA_insertAt_addStructuralFeatureValueAction]
  
    implicit def writes
    : Writes[OTIUMLA_insertAt_addStructuralFeatureValueAction]
    = Json.writes[OTIUMLA_insertAt_addStructuralFeatureValueAction]
  
    implicit def formats
    : Format[OTIUMLA_insertAt_addStructuralFeatureValueAction]
    = Json.format[OTIUMLA_insertAt_addStructuralFeatureValueAction]

  }

  /**
    * A_insertAt_addVariableValueAction
    *
    * @param: end1 A_insertAt_addVariableValueAction::addVariableValueAction: AddVariableValueAction [0..1] { unordered, unique, reference }
    * @param: end2 AddVariableValueAction::insertAt: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_insertAt_addVariableValueAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_insertAt_addVariableValueAction {
     
    implicit def reads
    : Reads[OTIUMLA_insertAt_addVariableValueAction]
    = Json.reads[OTIUMLA_insertAt_addVariableValueAction]
  
    implicit def writes
    : Writes[OTIUMLA_insertAt_addVariableValueAction]
    = Json.writes[OTIUMLA_insertAt_addVariableValueAction]
  
    implicit def formats
    : Format[OTIUMLA_insertAt_addVariableValueAction]
    = Json.format[OTIUMLA_insertAt_addVariableValueAction]

  }

  /**
    * A_interfaceRealization_implementingClassifier
    *
    * @param: end1 InterfaceRealization::implementingClassifier: BehavioredClassifier [1..1] { unordered, unique, reference }
    * @param: end2 BehavioredClassifier::interfaceRealization: InterfaceRealization [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_interfaceRealization_implementingClassifier
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_interfaceRealization_implementingClassifier {
     
    implicit def reads
    : Reads[OTIUMLA_interfaceRealization_implementingClassifier]
    = Json.reads[OTIUMLA_interfaceRealization_implementingClassifier]
  
    implicit def writes
    : Writes[OTIUMLA_interfaceRealization_implementingClassifier]
    = Json.writes[OTIUMLA_interfaceRealization_implementingClassifier]
  
    implicit def formats
    : Format[OTIUMLA_interfaceRealization_implementingClassifier]
    = Json.format[OTIUMLA_interfaceRealization_implementingClassifier]

  }

  /**
    * A_invariant_stateInvariant
    *
    * @param: end1 A_invariant_stateInvariant::stateInvariant: StateInvariant [0..1] { unordered, unique, reference }
    * @param: end2 StateInvariant::invariant: Constraint [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_invariant_stateInvariant
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_invariant_stateInvariant {
     
    implicit def reads
    : Reads[OTIUMLA_invariant_stateInvariant]
    = Json.reads[OTIUMLA_invariant_stateInvariant]
  
    implicit def writes
    : Writes[OTIUMLA_invariant_stateInvariant]
    = Json.writes[OTIUMLA_invariant_stateInvariant]
  
    implicit def formats
    : Format[OTIUMLA_invariant_stateInvariant]
    = Json.format[OTIUMLA_invariant_stateInvariant]

  }

  /**
    * A_joinSpec_joinNode
    *
    * @param: end1 A_joinSpec_joinNode::joinNode: JoinNode [0..1] { unordered, unique, reference }
    * @param: end2 JoinNode::joinSpec: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_joinSpec_joinNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_joinSpec_joinNode {
     
    implicit def reads
    : Reads[OTIUMLA_joinSpec_joinNode]
    = Json.reads[OTIUMLA_joinSpec_joinNode]
  
    implicit def writes
    : Writes[OTIUMLA_joinSpec_joinNode]
    = Json.writes[OTIUMLA_joinSpec_joinNode]
  
    implicit def formats
    : Format[OTIUMLA_joinSpec_joinNode]
    = Json.format[OTIUMLA_joinSpec_joinNode]

  }

  /**
    * A_lifeline_interaction
    *
    * @param: end1 Lifeline::interaction: Interaction [1..1] { unordered, unique, reference }
    * @param: end2 Interaction::lifeline: Lifeline [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_lifeline_interaction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_lifeline_interaction {
     
    implicit def reads
    : Reads[OTIUMLA_lifeline_interaction]
    = Json.reads[OTIUMLA_lifeline_interaction]
  
    implicit def writes
    : Writes[OTIUMLA_lifeline_interaction]
    = Json.writes[OTIUMLA_lifeline_interaction]
  
    implicit def formats
    : Format[OTIUMLA_lifeline_interaction]
    = Json.format[OTIUMLA_lifeline_interaction]

  }

  /**
    * A_localPostcondition_action
    *
    * @param: end1 A_localPostcondition_action::action: Action [0..1] { unordered, unique, reference }
    * @param: end2 Action::localPostcondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_localPostcondition_action
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_localPostcondition_action {
     
    implicit def reads
    : Reads[OTIUMLA_localPostcondition_action]
    = Json.reads[OTIUMLA_localPostcondition_action]
  
    implicit def writes
    : Writes[OTIUMLA_localPostcondition_action]
    = Json.writes[OTIUMLA_localPostcondition_action]
  
    implicit def formats
    : Format[OTIUMLA_localPostcondition_action]
    = Json.format[OTIUMLA_localPostcondition_action]

  }

  /**
    * A_localPrecondition_action
    *
    * @param: end1 A_localPrecondition_action::action: Action [0..1] { unordered, unique, reference }
    * @param: end2 Action::localPrecondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_localPrecondition_action
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_localPrecondition_action {
     
    implicit def reads
    : Reads[OTIUMLA_localPrecondition_action]
    = Json.reads[OTIUMLA_localPrecondition_action]
  
    implicit def writes
    : Writes[OTIUMLA_localPrecondition_action]
    = Json.writes[OTIUMLA_localPrecondition_action]
  
    implicit def formats
    : Format[OTIUMLA_localPrecondition_action]
    = Json.format[OTIUMLA_localPrecondition_action]

  }

  /**
    * A_loopVariableInput_loopNode
    *
    * @param: end1 A_loopVariableInput_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param: end2 LoopNode::loopVariableInput: InputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_loopVariableInput_loopNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_loopVariableInput_loopNode {
     
    implicit def reads
    : Reads[OTIUMLA_loopVariableInput_loopNode]
    = Json.reads[OTIUMLA_loopVariableInput_loopNode]
  
    implicit def writes
    : Writes[OTIUMLA_loopVariableInput_loopNode]
    = Json.writes[OTIUMLA_loopVariableInput_loopNode]
  
    implicit def formats
    : Format[OTIUMLA_loopVariableInput_loopNode]
    = Json.format[OTIUMLA_loopVariableInput_loopNode]

  }

  /**
    * A_loopVariable_loopNode
    *
    * @param: end1 A_loopVariable_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param: end2 LoopNode::loopVariable: OutputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_loopVariable_loopNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_loopVariable_loopNode {
     
    implicit def reads
    : Reads[OTIUMLA_loopVariable_loopNode]
    = Json.reads[OTIUMLA_loopVariable_loopNode]
  
    implicit def writes
    : Writes[OTIUMLA_loopVariable_loopNode]
    = Json.writes[OTIUMLA_loopVariable_loopNode]
  
    implicit def formats
    : Format[OTIUMLA_loopVariable_loopNode]
    = Json.format[OTIUMLA_loopVariable_loopNode]

  }

  /**
    * A_lowerValue_owningLower
    *
    * @param: end1 A_lowerValue_owningLower::owningLower: MultiplicityElement [0..1] { unordered, unique, reference }
    * @param: end2 MultiplicityElement::lowerValue: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_lowerValue_owningLower
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_lowerValue_owningLower {
     
    implicit def reads
    : Reads[OTIUMLA_lowerValue_owningLower]
    = Json.reads[OTIUMLA_lowerValue_owningLower]
  
    implicit def writes
    : Writes[OTIUMLA_lowerValue_owningLower]
    = Json.writes[OTIUMLA_lowerValue_owningLower]
  
    implicit def formats
    : Format[OTIUMLA_lowerValue_owningLower]
    = Json.format[OTIUMLA_lowerValue_owningLower]

  }

  /**
    * A_manifestation_artifact
    *
    * @param: end1 A_manifestation_artifact::artifact: Artifact [1..1] { unordered, unique, reference }
    * @param: end2 Artifact::manifestation: Manifestation [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_manifestation_artifact
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_manifestation_artifact {
     
    implicit def reads
    : Reads[OTIUMLA_manifestation_artifact]
    = Json.reads[OTIUMLA_manifestation_artifact]
  
    implicit def writes
    : Writes[OTIUMLA_manifestation_artifact]
    = Json.writes[OTIUMLA_manifestation_artifact]
  
    implicit def formats
    : Format[OTIUMLA_manifestation_artifact]
    = Json.format[OTIUMLA_manifestation_artifact]

  }

  /**
    * A_mapping_abstraction
    *
    * @param: end1 A_mapping_abstraction::abstraction: Abstraction [0..1] { unordered, unique, reference }
    * @param: end2 Abstraction::mapping: OpaqueExpression [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_mapping_abstraction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_mapping_abstraction {
     
    implicit def reads
    : Reads[OTIUMLA_mapping_abstraction]
    = Json.reads[OTIUMLA_mapping_abstraction]
  
    implicit def writes
    : Writes[OTIUMLA_mapping_abstraction]
    = Json.writes[OTIUMLA_mapping_abstraction]
  
    implicit def formats
    : Format[OTIUMLA_mapping_abstraction]
    = Json.format[OTIUMLA_mapping_abstraction]

  }

  /**
    * A_maxint_interactionConstraint
    *
    * @param: end1 A_maxint_interactionConstraint::interactionConstraint: InteractionConstraint [0..1] { unordered, unique, reference }
    * @param: end2 InteractionConstraint::maxint: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_maxint_interactionConstraint
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_maxint_interactionConstraint {
     
    implicit def reads
    : Reads[OTIUMLA_maxint_interactionConstraint]
    = Json.reads[OTIUMLA_maxint_interactionConstraint]
  
    implicit def writes
    : Writes[OTIUMLA_maxint_interactionConstraint]
    = Json.writes[OTIUMLA_maxint_interactionConstraint]
  
    implicit def formats
    : Format[OTIUMLA_maxint_interactionConstraint]
    = Json.format[OTIUMLA_maxint_interactionConstraint]

  }

  /**
    * A_message_interaction
    *
    * @param: end1 Message::interaction: Interaction [1..1] { unordered, unique, reference }
    * @param: end2 Interaction::message: Message [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_message_interaction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_message_interaction {
     
    implicit def reads
    : Reads[OTIUMLA_message_interaction]
    = Json.reads[OTIUMLA_message_interaction]
  
    implicit def writes
    : Writes[OTIUMLA_message_interaction]
    = Json.writes[OTIUMLA_message_interaction]
  
    implicit def formats
    : Format[OTIUMLA_message_interaction]
    = Json.format[OTIUMLA_message_interaction]

  }

  /**
    * A_metaclassReference_profile
    *
    * @param: end1 A_metaclassReference_profile::profile: Profile [0..1] { unordered, unique, reference }
    * @param: end2 Profile::metaclassReference: ElementImport [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_metaclassReference_profile
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_metaclassReference_profile {
     
    implicit def reads
    : Reads[OTIUMLA_metaclassReference_profile]
    = Json.reads[OTIUMLA_metaclassReference_profile]
  
    implicit def writes
    : Writes[OTIUMLA_metaclassReference_profile]
    = Json.writes[OTIUMLA_metaclassReference_profile]
  
    implicit def formats
    : Format[OTIUMLA_metaclassReference_profile]
    = Json.format[OTIUMLA_metaclassReference_profile]

  }

  /**
    * A_metamodelReference_profile
    *
    * @param: end1 A_metamodelReference_profile::profile: Profile [0..1] { unordered, unique, reference }
    * @param: end2 Profile::metamodelReference: PackageImport [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_metamodelReference_profile
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_metamodelReference_profile {
     
    implicit def reads
    : Reads[OTIUMLA_metamodelReference_profile]
    = Json.reads[OTIUMLA_metamodelReference_profile]
  
    implicit def writes
    : Writes[OTIUMLA_metamodelReference_profile]
    = Json.writes[OTIUMLA_metamodelReference_profile]
  
    implicit def formats
    : Format[OTIUMLA_metamodelReference_profile]
    = Json.format[OTIUMLA_metamodelReference_profile]

  }

  /**
    * A_minint_interactionConstraint
    *
    * @param: end1 A_minint_interactionConstraint::interactionConstraint: InteractionConstraint [0..1] { unordered, unique, reference }
    * @param: end2 InteractionConstraint::minint: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_minint_interactionConstraint
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_minint_interactionConstraint {
     
    implicit def reads
    : Reads[OTIUMLA_minint_interactionConstraint]
    = Json.reads[OTIUMLA_minint_interactionConstraint]
  
    implicit def writes
    : Writes[OTIUMLA_minint_interactionConstraint]
    = Json.writes[OTIUMLA_minint_interactionConstraint]
  
    implicit def formats
    : Format[OTIUMLA_minint_interactionConstraint]
    = Json.format[OTIUMLA_minint_interactionConstraint]

  }

  /**
    * A_nameExpression_namedElement
    *
    * @param: end1 A_nameExpression_namedElement::namedElement: NamedElement [0..1] { unordered, unique, reference }
    * @param: end2 NamedElement::nameExpression: StringExpression [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_nameExpression_namedElement
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_nameExpression_namedElement {
     
    implicit def reads
    : Reads[OTIUMLA_nameExpression_namedElement]
    = Json.reads[OTIUMLA_nameExpression_namedElement]
  
    implicit def writes
    : Writes[OTIUMLA_nameExpression_namedElement]
    = Json.writes[OTIUMLA_nameExpression_namedElement]
  
    implicit def formats
    : Format[OTIUMLA_nameExpression_namedElement]
    = Json.format[OTIUMLA_nameExpression_namedElement]

  }

  /**
    * A_nestedArtifact_artifact
    *
    * @param: end1 A_nestedArtifact_artifact::artifact: Artifact [0..1] { unordered, unique, reference }
    * @param: end2 Artifact::nestedArtifact: Artifact [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_nestedArtifact_artifact
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_nestedArtifact_artifact {
     
    implicit def reads
    : Reads[OTIUMLA_nestedArtifact_artifact]
    = Json.reads[OTIUMLA_nestedArtifact_artifact]
  
    implicit def writes
    : Writes[OTIUMLA_nestedArtifact_artifact]
    = Json.writes[OTIUMLA_nestedArtifact_artifact]
  
    implicit def formats
    : Format[OTIUMLA_nestedArtifact_artifact]
    = Json.format[OTIUMLA_nestedArtifact_artifact]

  }

  /**
    * A_nestedClassifier_interface
    *
    * @param: end1 A_nestedClassifier_interface::interface: Interface [0..1] { unordered, unique, reference }
    * @param: end2 Interface::nestedClassifier: Classifier [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_nestedClassifier_interface
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_nestedClassifier_interface {
     
    implicit def reads
    : Reads[OTIUMLA_nestedClassifier_interface]
    = Json.reads[OTIUMLA_nestedClassifier_interface]
  
    implicit def writes
    : Writes[OTIUMLA_nestedClassifier_interface]
    = Json.writes[OTIUMLA_nestedClassifier_interface]
  
    implicit def formats
    : Format[OTIUMLA_nestedClassifier_interface]
    = Json.format[OTIUMLA_nestedClassifier_interface]

  }

  /**
    * A_nestedClassifier_nestingClass
    *
    * @param: end1 A_nestedClassifier_nestingClass::nestingClass: Class [0..1] { unordered, unique, reference }
    * @param: end2 Class::nestedClassifier: Classifier [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_nestedClassifier_nestingClass
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_nestedClassifier_nestingClass {
     
    implicit def reads
    : Reads[OTIUMLA_nestedClassifier_nestingClass]
    = Json.reads[OTIUMLA_nestedClassifier_nestingClass]
  
    implicit def writes
    : Writes[OTIUMLA_nestedClassifier_nestingClass]
    = Json.writes[OTIUMLA_nestedClassifier_nestingClass]
  
    implicit def formats
    : Format[OTIUMLA_nestedClassifier_nestingClass]
    = Json.format[OTIUMLA_nestedClassifier_nestingClass]

  }

  /**
    * A_nestedNode_node
    *
    * @param: end1 A_nestedNode_node::node: Node [0..1] { unordered, unique, reference }
    * @param: end2 Node::nestedNode: Node [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_nestedNode_node
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_nestedNode_node {
     
    implicit def reads
    : Reads[OTIUMLA_nestedNode_node]
    = Json.reads[OTIUMLA_nestedNode_node]
  
    implicit def writes
    : Writes[OTIUMLA_nestedNode_node]
    = Json.writes[OTIUMLA_nestedNode_node]
  
    implicit def formats
    : Format[OTIUMLA_nestedNode_node]
    = Json.format[OTIUMLA_nestedNode_node]

  }

  /**
    * A_node_activity
    *
    * @param: end1 ActivityNode::activity: Activity [0..1] { unordered, unique, reference }
    * @param: end2 Activity::node: ActivityNode [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_node_activity
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_node_activity {
     
    implicit def reads
    : Reads[OTIUMLA_node_activity]
    = Json.reads[OTIUMLA_node_activity]
  
    implicit def writes
    : Writes[OTIUMLA_node_activity]
    = Json.writes[OTIUMLA_node_activity]
  
    implicit def formats
    : Format[OTIUMLA_node_activity]
    = Json.format[OTIUMLA_node_activity]

  }

  /**
    * A_node_inStructuredNode
    *
    * @param: end1 ActivityNode::inStructuredNode: StructuredActivityNode [0..1] { unordered, unique, reference }
    * @param: end2 StructuredActivityNode::node: ActivityNode [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_node_inStructuredNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_node_inStructuredNode {
     
    implicit def reads
    : Reads[OTIUMLA_node_inStructuredNode]
    = Json.reads[OTIUMLA_node_inStructuredNode]
  
    implicit def writes
    : Writes[OTIUMLA_node_inStructuredNode]
    = Json.writes[OTIUMLA_node_inStructuredNode]
  
    implicit def formats
    : Format[OTIUMLA_node_inStructuredNode]
    = Json.format[OTIUMLA_node_inStructuredNode]

  }

  /**
    * A_object_clearAssociationAction
    *
    * @param: end1 A_object_clearAssociationAction::clearAssociationAction: ClearAssociationAction [0..1] { unordered, unique, reference }
    * @param: end2 ClearAssociationAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_clearAssociationAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_object_clearAssociationAction {
     
    implicit def reads
    : Reads[OTIUMLA_object_clearAssociationAction]
    = Json.reads[OTIUMLA_object_clearAssociationAction]
  
    implicit def writes
    : Writes[OTIUMLA_object_clearAssociationAction]
    = Json.writes[OTIUMLA_object_clearAssociationAction]
  
    implicit def formats
    : Format[OTIUMLA_object_clearAssociationAction]
    = Json.format[OTIUMLA_object_clearAssociationAction]

  }

  /**
    * A_object_readIsClassifiedObjectAction
    *
    * @param: end1 A_object_readIsClassifiedObjectAction::readIsClassifiedObjectAction: ReadIsClassifiedObjectAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadIsClassifiedObjectAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_readIsClassifiedObjectAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_object_readIsClassifiedObjectAction {
     
    implicit def reads
    : Reads[OTIUMLA_object_readIsClassifiedObjectAction]
    = Json.reads[OTIUMLA_object_readIsClassifiedObjectAction]
  
    implicit def writes
    : Writes[OTIUMLA_object_readIsClassifiedObjectAction]
    = Json.writes[OTIUMLA_object_readIsClassifiedObjectAction]
  
    implicit def formats
    : Format[OTIUMLA_object_readIsClassifiedObjectAction]
    = Json.format[OTIUMLA_object_readIsClassifiedObjectAction]

  }

  /**
    * A_object_readLinkObjectEndAction
    *
    * @param: end1 A_object_readLinkObjectEndAction::readLinkObjectEndAction: ReadLinkObjectEndAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadLinkObjectEndAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_readLinkObjectEndAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_object_readLinkObjectEndAction {
     
    implicit def reads
    : Reads[OTIUMLA_object_readLinkObjectEndAction]
    = Json.reads[OTIUMLA_object_readLinkObjectEndAction]
  
    implicit def writes
    : Writes[OTIUMLA_object_readLinkObjectEndAction]
    = Json.writes[OTIUMLA_object_readLinkObjectEndAction]
  
    implicit def formats
    : Format[OTIUMLA_object_readLinkObjectEndAction]
    = Json.format[OTIUMLA_object_readLinkObjectEndAction]

  }

  /**
    * A_object_readLinkObjectEndQualifierAction
    *
    * @param: end1 A_object_readLinkObjectEndQualifierAction::readLinkObjectEndQualifierAction: ReadLinkObjectEndQualifierAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadLinkObjectEndQualifierAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_readLinkObjectEndQualifierAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_object_readLinkObjectEndQualifierAction {
     
    implicit def reads
    : Reads[OTIUMLA_object_readLinkObjectEndQualifierAction]
    = Json.reads[OTIUMLA_object_readLinkObjectEndQualifierAction]
  
    implicit def writes
    : Writes[OTIUMLA_object_readLinkObjectEndQualifierAction]
    = Json.writes[OTIUMLA_object_readLinkObjectEndQualifierAction]
  
    implicit def formats
    : Format[OTIUMLA_object_readLinkObjectEndQualifierAction]
    = Json.format[OTIUMLA_object_readLinkObjectEndQualifierAction]

  }

  /**
    * A_object_reclassifyObjectAction
    *
    * @param: end1 A_object_reclassifyObjectAction::reclassifyObjectAction: ReclassifyObjectAction [0..1] { unordered, unique, reference }
    * @param: end2 ReclassifyObjectAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_reclassifyObjectAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_object_reclassifyObjectAction {
     
    implicit def reads
    : Reads[OTIUMLA_object_reclassifyObjectAction]
    = Json.reads[OTIUMLA_object_reclassifyObjectAction]
  
    implicit def writes
    : Writes[OTIUMLA_object_reclassifyObjectAction]
    = Json.writes[OTIUMLA_object_reclassifyObjectAction]
  
    implicit def formats
    : Format[OTIUMLA_object_reclassifyObjectAction]
    = Json.format[OTIUMLA_object_reclassifyObjectAction]

  }

  /**
    * A_object_startClassifierBehaviorAction
    *
    * @param: end1 A_object_startClassifierBehaviorAction::startClassifierBehaviorAction: StartClassifierBehaviorAction [0..1] { unordered, unique, reference }
    * @param: end2 StartClassifierBehaviorAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_startClassifierBehaviorAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_object_startClassifierBehaviorAction {
     
    implicit def reads
    : Reads[OTIUMLA_object_startClassifierBehaviorAction]
    = Json.reads[OTIUMLA_object_startClassifierBehaviorAction]
  
    implicit def writes
    : Writes[OTIUMLA_object_startClassifierBehaviorAction]
    = Json.writes[OTIUMLA_object_startClassifierBehaviorAction]
  
    implicit def formats
    : Format[OTIUMLA_object_startClassifierBehaviorAction]
    = Json.format[OTIUMLA_object_startClassifierBehaviorAction]

  }

  /**
    * A_object_startObjectBehaviorAction
    *
    * @param: end1 A_object_startObjectBehaviorAction::startObjectBehaviorAction: StartObjectBehaviorAction [0..1] { unordered, unique, reference }
    * @param: end2 StartObjectBehaviorAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_startObjectBehaviorAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_object_startObjectBehaviorAction {
     
    implicit def reads
    : Reads[OTIUMLA_object_startObjectBehaviorAction]
    = Json.reads[OTIUMLA_object_startObjectBehaviorAction]
  
    implicit def writes
    : Writes[OTIUMLA_object_startObjectBehaviorAction]
    = Json.writes[OTIUMLA_object_startObjectBehaviorAction]
  
    implicit def formats
    : Format[OTIUMLA_object_startObjectBehaviorAction]
    = Json.format[OTIUMLA_object_startObjectBehaviorAction]

  }

  /**
    * A_object_structuralFeatureAction
    *
    * @param: end1 A_object_structuralFeatureAction::structuralFeatureAction: StructuralFeatureAction [0..1] { unordered, unique, reference }
    * @param: end2 StructuralFeatureAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_structuralFeatureAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_object_structuralFeatureAction {
     
    implicit def reads
    : Reads[OTIUMLA_object_structuralFeatureAction]
    = Json.reads[OTIUMLA_object_structuralFeatureAction]
  
    implicit def writes
    : Writes[OTIUMLA_object_structuralFeatureAction]
    = Json.writes[OTIUMLA_object_structuralFeatureAction]
  
    implicit def formats
    : Format[OTIUMLA_object_structuralFeatureAction]
    = Json.format[OTIUMLA_object_structuralFeatureAction]

  }

  /**
    * A_object_unmarshallAction
    *
    * @param: end1 A_object_unmarshallAction::unmarshallAction: UnmarshallAction [0..1] { unordered, unique, reference }
    * @param: end2 UnmarshallAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_unmarshallAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_object_unmarshallAction {
     
    implicit def reads
    : Reads[OTIUMLA_object_unmarshallAction]
    = Json.reads[OTIUMLA_object_unmarshallAction]
  
    implicit def writes
    : Writes[OTIUMLA_object_unmarshallAction]
    = Json.writes[OTIUMLA_object_unmarshallAction]
  
    implicit def formats
    : Format[OTIUMLA_object_unmarshallAction]
    = Json.format[OTIUMLA_object_unmarshallAction]

  }

  /**
    * A_operand_combinedFragment
    *
    * @param: end1 A_operand_combinedFragment::combinedFragment: CombinedFragment [0..1] { unordered, unique, reference }
    * @param: end2 CombinedFragment::operand: InteractionOperand [1..*] { ordered, unique, composite }
    */
  case class OTIUMLA_operand_combinedFragment
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_operand_combinedFragment {
     
    implicit def reads
    : Reads[OTIUMLA_operand_combinedFragment]
    = Json.reads[OTIUMLA_operand_combinedFragment]
  
    implicit def writes
    : Writes[OTIUMLA_operand_combinedFragment]
    = Json.writes[OTIUMLA_operand_combinedFragment]
  
    implicit def formats
    : Format[OTIUMLA_operand_combinedFragment]
    = Json.format[OTIUMLA_operand_combinedFragment]

  }

  /**
    * A_operand_expression
    *
    * @param: end1 A_operand_expression::expression: Expression [0..1] { unordered, unique, reference }
    * @param: end2 Expression::operand: ValueSpecification [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_operand_expression
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_operand_expression {
     
    implicit def reads
    : Reads[OTIUMLA_operand_expression]
    = Json.reads[OTIUMLA_operand_expression]
  
    implicit def writes
    : Writes[OTIUMLA_operand_expression]
    = Json.writes[OTIUMLA_operand_expression]
  
    implicit def formats
    : Format[OTIUMLA_operand_expression]
    = Json.format[OTIUMLA_operand_expression]

  }

  /**
    * A_outputValue_opaqueAction
    *
    * @param: end1 A_outputValue_opaqueAction::opaqueAction: OpaqueAction [0..1] { unordered, unique, reference }
    * @param: end2 OpaqueAction::outputValue: OutputPin [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_outputValue_opaqueAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_outputValue_opaqueAction {
     
    implicit def reads
    : Reads[OTIUMLA_outputValue_opaqueAction]
    = Json.reads[OTIUMLA_outputValue_opaqueAction]
  
    implicit def writes
    : Writes[OTIUMLA_outputValue_opaqueAction]
    = Json.writes[OTIUMLA_outputValue_opaqueAction]
  
    implicit def formats
    : Format[OTIUMLA_outputValue_opaqueAction]
    = Json.format[OTIUMLA_outputValue_opaqueAction]

  }

  /**
    * A_ownedActual_owningTemplateParameterSubstitution
    *
    * @param: end1 A_ownedActual_owningTemplateParameterSubstitution::owningTemplateParameterSubstitution: TemplateParameterSubstitution [0..1] { unordered, unique, reference }
    * @param: end2 TemplateParameterSubstitution::ownedActual: ParameterableElement [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedActual_owningTemplateParameterSubstitution
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedActual_owningTemplateParameterSubstitution {
     
    implicit def reads
    : Reads[OTIUMLA_ownedActual_owningTemplateParameterSubstitution]
    = Json.reads[OTIUMLA_ownedActual_owningTemplateParameterSubstitution]
  
    implicit def writes
    : Writes[OTIUMLA_ownedActual_owningTemplateParameterSubstitution]
    = Json.writes[OTIUMLA_ownedActual_owningTemplateParameterSubstitution]
  
    implicit def formats
    : Format[OTIUMLA_ownedActual_owningTemplateParameterSubstitution]
    = Json.format[OTIUMLA_ownedActual_owningTemplateParameterSubstitution]

  }

  /**
    * A_ownedAttribute_artifact
    *
    * @param: end1 A_ownedAttribute_artifact::artifact: Artifact [0..1] { unordered, unique, reference }
    * @param: end2 Artifact::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_artifact
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedAttribute_artifact {
     
    implicit def reads
    : Reads[OTIUMLA_ownedAttribute_artifact]
    = Json.reads[OTIUMLA_ownedAttribute_artifact]
  
    implicit def writes
    : Writes[OTIUMLA_ownedAttribute_artifact]
    = Json.writes[OTIUMLA_ownedAttribute_artifact]
  
    implicit def formats
    : Format[OTIUMLA_ownedAttribute_artifact]
    = Json.format[OTIUMLA_ownedAttribute_artifact]

  }

  /**
    * A_ownedAttribute_class
    *
    * @param: end1 Property::class: Class [0..1] { unordered, unique, reference }
    * @param: end2 Class::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_class
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedAttribute_class {
     
    implicit def reads
    : Reads[OTIUMLA_ownedAttribute_class]
    = Json.reads[OTIUMLA_ownedAttribute_class]
  
    implicit def writes
    : Writes[OTIUMLA_ownedAttribute_class]
    = Json.writes[OTIUMLA_ownedAttribute_class]
  
    implicit def formats
    : Format[OTIUMLA_ownedAttribute_class]
    = Json.format[OTIUMLA_ownedAttribute_class]

  }

  /**
    * A_ownedAttribute_datatype
    *
    * @param: end1 Property::datatype: DataType [0..1] { unordered, unique, reference }
    * @param: end2 DataType::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_datatype
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedAttribute_datatype {
     
    implicit def reads
    : Reads[OTIUMLA_ownedAttribute_datatype]
    = Json.reads[OTIUMLA_ownedAttribute_datatype]
  
    implicit def writes
    : Writes[OTIUMLA_ownedAttribute_datatype]
    = Json.writes[OTIUMLA_ownedAttribute_datatype]
  
    implicit def formats
    : Format[OTIUMLA_ownedAttribute_datatype]
    = Json.format[OTIUMLA_ownedAttribute_datatype]

  }

  /**
    * A_ownedAttribute_interface
    *
    * @param: end1 Property::interface: Interface [0..1] { unordered, unique, reference }
    * @param: end2 Interface::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_interface
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedAttribute_interface {
     
    implicit def reads
    : Reads[OTIUMLA_ownedAttribute_interface]
    = Json.reads[OTIUMLA_ownedAttribute_interface]
  
    implicit def writes
    : Writes[OTIUMLA_ownedAttribute_interface]
    = Json.writes[OTIUMLA_ownedAttribute_interface]
  
    implicit def formats
    : Format[OTIUMLA_ownedAttribute_interface]
    = Json.format[OTIUMLA_ownedAttribute_interface]

  }

  /**
    * A_ownedAttribute_owningSignal
    *
    * @param: end1 A_ownedAttribute_owningSignal::owningSignal: Signal [0..1] { unordered, unique, reference }
    * @param: end2 Signal::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_owningSignal
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedAttribute_owningSignal {
     
    implicit def reads
    : Reads[OTIUMLA_ownedAttribute_owningSignal]
    = Json.reads[OTIUMLA_ownedAttribute_owningSignal]
  
    implicit def writes
    : Writes[OTIUMLA_ownedAttribute_owningSignal]
    = Json.writes[OTIUMLA_ownedAttribute_owningSignal]
  
    implicit def formats
    : Format[OTIUMLA_ownedAttribute_owningSignal]
    = Json.format[OTIUMLA_ownedAttribute_owningSignal]

  }

  /**
    * A_ownedAttribute_structuredClassifier
    *
    * @param: end1 A_ownedAttribute_structuredClassifier::structuredClassifier: StructuredClassifier [0..1] { unordered, unique, reference }
    * @param: end2 StructuredClassifier::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_structuredClassifier
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedAttribute_structuredClassifier {
     
    implicit def reads
    : Reads[OTIUMLA_ownedAttribute_structuredClassifier]
    = Json.reads[OTIUMLA_ownedAttribute_structuredClassifier]
  
    implicit def writes
    : Writes[OTIUMLA_ownedAttribute_structuredClassifier]
    = Json.writes[OTIUMLA_ownedAttribute_structuredClassifier]
  
    implicit def formats
    : Format[OTIUMLA_ownedAttribute_structuredClassifier]
    = Json.format[OTIUMLA_ownedAttribute_structuredClassifier]

  }

  /**
    * A_ownedBehavior_behavioredClassifier
    *
    * @param: end1 A_ownedBehavior_behavioredClassifier::behavioredClassifier: BehavioredClassifier [0..1] { unordered, unique, reference }
    * @param: end2 BehavioredClassifier::ownedBehavior: Behavior [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedBehavior_behavioredClassifier
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedBehavior_behavioredClassifier {
     
    implicit def reads
    : Reads[OTIUMLA_ownedBehavior_behavioredClassifier]
    = Json.reads[OTIUMLA_ownedBehavior_behavioredClassifier]
  
    implicit def writes
    : Writes[OTIUMLA_ownedBehavior_behavioredClassifier]
    = Json.writes[OTIUMLA_ownedBehavior_behavioredClassifier]
  
    implicit def formats
    : Format[OTIUMLA_ownedBehavior_behavioredClassifier]
    = Json.format[OTIUMLA_ownedBehavior_behavioredClassifier]

  }

  /**
    * A_ownedComment_owningElement
    *
    * @param: end1 A_ownedComment_owningElement::owningElement: Element [0..1] { unordered, unique, reference }
    * @param: end2 Element::ownedComment: Comment [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedComment_owningElement
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedComment_owningElement {
     
    implicit def reads
    : Reads[OTIUMLA_ownedComment_owningElement]
    = Json.reads[OTIUMLA_ownedComment_owningElement]
  
    implicit def writes
    : Writes[OTIUMLA_ownedComment_owningElement]
    = Json.writes[OTIUMLA_ownedComment_owningElement]
  
    implicit def formats
    : Format[OTIUMLA_ownedComment_owningElement]
    = Json.format[OTIUMLA_ownedComment_owningElement]

  }

  /**
    * A_ownedConnector_structuredClassifier
    *
    * @param: end1 A_ownedConnector_structuredClassifier::structuredClassifier: StructuredClassifier [0..1] { unordered, unique, reference }
    * @param: end2 StructuredClassifier::ownedConnector: Connector [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedConnector_structuredClassifier
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedConnector_structuredClassifier {
     
    implicit def reads
    : Reads[OTIUMLA_ownedConnector_structuredClassifier]
    = Json.reads[OTIUMLA_ownedConnector_structuredClassifier]
  
    implicit def writes
    : Writes[OTIUMLA_ownedConnector_structuredClassifier]
    = Json.writes[OTIUMLA_ownedConnector_structuredClassifier]
  
    implicit def formats
    : Format[OTIUMLA_ownedConnector_structuredClassifier]
    = Json.format[OTIUMLA_ownedConnector_structuredClassifier]

  }

  /**
    * A_ownedDefault_templateParameter
    *
    * @param: end1 A_ownedDefault_templateParameter::templateParameter: TemplateParameter [0..1] { unordered, unique, reference }
    * @param: end2 TemplateParameter::ownedDefault: ParameterableElement [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedDefault_templateParameter
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedDefault_templateParameter {
     
    implicit def reads
    : Reads[OTIUMLA_ownedDefault_templateParameter]
    = Json.reads[OTIUMLA_ownedDefault_templateParameter]
  
    implicit def writes
    : Writes[OTIUMLA_ownedDefault_templateParameter]
    = Json.writes[OTIUMLA_ownedDefault_templateParameter]
  
    implicit def formats
    : Format[OTIUMLA_ownedDefault_templateParameter]
    = Json.format[OTIUMLA_ownedDefault_templateParameter]

  }

  /**
    * A_ownedEnd_extension
    *
    * @param: end1 A_ownedEnd_extension::extension: Extension [1..1] { unordered, unique, reference }
    * @param: end2 Extension::ownedEnd: ExtensionEnd [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedEnd_extension
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedEnd_extension {
     
    implicit def reads
    : Reads[OTIUMLA_ownedEnd_extension]
    = Json.reads[OTIUMLA_ownedEnd_extension]
  
    implicit def writes
    : Writes[OTIUMLA_ownedEnd_extension]
    = Json.writes[OTIUMLA_ownedEnd_extension]
  
    implicit def formats
    : Format[OTIUMLA_ownedEnd_extension]
    = Json.format[OTIUMLA_ownedEnd_extension]

  }

  /**
    * A_ownedEnd_owningAssociation
    *
    * @param: end1 Property::owningAssociation: Association [0..1] { unordered, unique, reference }
    * @param: end2 Association::ownedEnd: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedEnd_owningAssociation
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedEnd_owningAssociation {
     
    implicit def reads
    : Reads[OTIUMLA_ownedEnd_owningAssociation]
    = Json.reads[OTIUMLA_ownedEnd_owningAssociation]
  
    implicit def writes
    : Writes[OTIUMLA_ownedEnd_owningAssociation]
    = Json.writes[OTIUMLA_ownedEnd_owningAssociation]
  
    implicit def formats
    : Format[OTIUMLA_ownedEnd_owningAssociation]
    = Json.format[OTIUMLA_ownedEnd_owningAssociation]

  }

  /**
    * A_ownedLiteral_enumeration
    *
    * @param: end1 EnumerationLiteral::enumeration: Enumeration [1..1] { unordered, unique, reference }
    * @param: end2 Enumeration::ownedLiteral: EnumerationLiteral [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedLiteral_enumeration
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedLiteral_enumeration {
     
    implicit def reads
    : Reads[OTIUMLA_ownedLiteral_enumeration]
    = Json.reads[OTIUMLA_ownedLiteral_enumeration]
  
    implicit def writes
    : Writes[OTIUMLA_ownedLiteral_enumeration]
    = Json.writes[OTIUMLA_ownedLiteral_enumeration]
  
    implicit def formats
    : Format[OTIUMLA_ownedLiteral_enumeration]
    = Json.format[OTIUMLA_ownedLiteral_enumeration]

  }

  /**
    * A_ownedOperation_artifact
    *
    * @param: end1 A_ownedOperation_artifact::artifact: Artifact [0..1] { unordered, unique, reference }
    * @param: end2 Artifact::ownedOperation: Operation [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedOperation_artifact
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedOperation_artifact {
     
    implicit def reads
    : Reads[OTIUMLA_ownedOperation_artifact]
    = Json.reads[OTIUMLA_ownedOperation_artifact]
  
    implicit def writes
    : Writes[OTIUMLA_ownedOperation_artifact]
    = Json.writes[OTIUMLA_ownedOperation_artifact]
  
    implicit def formats
    : Format[OTIUMLA_ownedOperation_artifact]
    = Json.format[OTIUMLA_ownedOperation_artifact]

  }

  /**
    * A_ownedOperation_class
    *
    * @param: end1 Operation::class: Class [0..1] { unordered, unique, reference }
    * @param: end2 Class::ownedOperation: Operation [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedOperation_class
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedOperation_class {
     
    implicit def reads
    : Reads[OTIUMLA_ownedOperation_class]
    = Json.reads[OTIUMLA_ownedOperation_class]
  
    implicit def writes
    : Writes[OTIUMLA_ownedOperation_class]
    = Json.writes[OTIUMLA_ownedOperation_class]
  
    implicit def formats
    : Format[OTIUMLA_ownedOperation_class]
    = Json.format[OTIUMLA_ownedOperation_class]

  }

  /**
    * A_ownedOperation_datatype
    *
    * @param: end1 Operation::datatype: DataType [0..1] { unordered, unique, reference }
    * @param: end2 DataType::ownedOperation: Operation [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedOperation_datatype
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedOperation_datatype {
     
    implicit def reads
    : Reads[OTIUMLA_ownedOperation_datatype]
    = Json.reads[OTIUMLA_ownedOperation_datatype]
  
    implicit def writes
    : Writes[OTIUMLA_ownedOperation_datatype]
    = Json.writes[OTIUMLA_ownedOperation_datatype]
  
    implicit def formats
    : Format[OTIUMLA_ownedOperation_datatype]
    = Json.format[OTIUMLA_ownedOperation_datatype]

  }

  /**
    * A_ownedOperation_interface
    *
    * @param: end1 Operation::interface: Interface [0..1] { unordered, unique, reference }
    * @param: end2 Interface::ownedOperation: Operation [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedOperation_interface
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedOperation_interface {
     
    implicit def reads
    : Reads[OTIUMLA_ownedOperation_interface]
    = Json.reads[OTIUMLA_ownedOperation_interface]
  
    implicit def writes
    : Writes[OTIUMLA_ownedOperation_interface]
    = Json.writes[OTIUMLA_ownedOperation_interface]
  
    implicit def formats
    : Format[OTIUMLA_ownedOperation_interface]
    = Json.format[OTIUMLA_ownedOperation_interface]

  }

  /**
    * A_ownedParameterSet_behavior
    *
    * @param: end1 A_ownedParameterSet_behavior::behavior: Behavior [0..1] { unordered, unique, reference }
    * @param: end2 Behavior::ownedParameterSet: ParameterSet [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedParameterSet_behavior
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedParameterSet_behavior {
     
    implicit def reads
    : Reads[OTIUMLA_ownedParameterSet_behavior]
    = Json.reads[OTIUMLA_ownedParameterSet_behavior]
  
    implicit def writes
    : Writes[OTIUMLA_ownedParameterSet_behavior]
    = Json.writes[OTIUMLA_ownedParameterSet_behavior]
  
    implicit def formats
    : Format[OTIUMLA_ownedParameterSet_behavior]
    = Json.format[OTIUMLA_ownedParameterSet_behavior]

  }

  /**
    * A_ownedParameterSet_behavioralFeature
    *
    * @param: end1 A_ownedParameterSet_behavioralFeature::behavioralFeature: BehavioralFeature [0..1] { unordered, unique, reference }
    * @param: end2 BehavioralFeature::ownedParameterSet: ParameterSet [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedParameterSet_behavioralFeature
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedParameterSet_behavioralFeature {
     
    implicit def reads
    : Reads[OTIUMLA_ownedParameterSet_behavioralFeature]
    = Json.reads[OTIUMLA_ownedParameterSet_behavioralFeature]
  
    implicit def writes
    : Writes[OTIUMLA_ownedParameterSet_behavioralFeature]
    = Json.writes[OTIUMLA_ownedParameterSet_behavioralFeature]
  
    implicit def formats
    : Format[OTIUMLA_ownedParameterSet_behavioralFeature]
    = Json.format[OTIUMLA_ownedParameterSet_behavioralFeature]

  }

  /**
    * A_ownedParameter_behavior
    *
    * @param: end1 A_ownedParameter_behavior::behavior: Behavior [0..1] { unordered, unique, reference }
    * @param: end2 Behavior::ownedParameter: Parameter [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedParameter_behavior
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedParameter_behavior {
     
    implicit def reads
    : Reads[OTIUMLA_ownedParameter_behavior]
    = Json.reads[OTIUMLA_ownedParameter_behavior]
  
    implicit def writes
    : Writes[OTIUMLA_ownedParameter_behavior]
    = Json.writes[OTIUMLA_ownedParameter_behavior]
  
    implicit def formats
    : Format[OTIUMLA_ownedParameter_behavior]
    = Json.format[OTIUMLA_ownedParameter_behavior]

  }

  /**
    * A_ownedParameter_operation
    *
    * @param: end1 Parameter::operation: Operation [0..1] { unordered, unique, reference }
    * @param: end2 Operation::ownedParameter: Parameter [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedParameter_operation
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedParameter_operation {
     
    implicit def reads
    : Reads[OTIUMLA_ownedParameter_operation]
    = Json.reads[OTIUMLA_ownedParameter_operation]
  
    implicit def writes
    : Writes[OTIUMLA_ownedParameter_operation]
    = Json.writes[OTIUMLA_ownedParameter_operation]
  
    implicit def formats
    : Format[OTIUMLA_ownedParameter_operation]
    = Json.format[OTIUMLA_ownedParameter_operation]

  }

  /**
    * A_ownedParameter_ownerFormalParam
    *
    * @param: end1 A_ownedParameter_ownerFormalParam::ownerFormalParam: BehavioralFeature [0..1] { unordered, unique, reference }
    * @param: end2 BehavioralFeature::ownedParameter: Parameter [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedParameter_ownerFormalParam
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedParameter_ownerFormalParam {
     
    implicit def reads
    : Reads[OTIUMLA_ownedParameter_ownerFormalParam]
    = Json.reads[OTIUMLA_ownedParameter_ownerFormalParam]
  
    implicit def writes
    : Writes[OTIUMLA_ownedParameter_ownerFormalParam]
    = Json.writes[OTIUMLA_ownedParameter_ownerFormalParam]
  
    implicit def formats
    : Format[OTIUMLA_ownedParameter_ownerFormalParam]
    = Json.format[OTIUMLA_ownedParameter_ownerFormalParam]

  }

  /**
    * A_ownedParameter_signature
    *
    * @param: end1 TemplateParameter::signature: TemplateSignature [1..1] { unordered, unique, reference }
    * @param: end2 TemplateSignature::ownedParameter: TemplateParameter [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedParameter_signature
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_ownedParameter_signature {
     
    implicit def reads
    : Reads[OTIUMLA_ownedParameter_signature]
    = Json.reads[OTIUMLA_ownedParameter_signature]
  
    implicit def writes
    : Writes[OTIUMLA_ownedParameter_signature]
    = Json.writes[OTIUMLA_ownedParameter_signature]
  
    implicit def formats
    : Format[OTIUMLA_ownedParameter_signature]
    = Json.format[OTIUMLA_ownedParameter_signature]

  }

  /**
    * A_ownedParameteredElement_owningTemplateParameter
    *
    * @param: end1 ParameterableElement::owningTemplateParameter: TemplateParameter [0..1] { unordered, unique, reference }
    * @param: end2 TemplateParameter::ownedParameteredElement: ParameterableElement [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedParameteredElement_owningTemplateParameter
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedParameteredElement_owningTemplateParameter {
     
    implicit def reads
    : Reads[OTIUMLA_ownedParameteredElement_owningTemplateParameter]
    = Json.reads[OTIUMLA_ownedParameteredElement_owningTemplateParameter]
  
    implicit def writes
    : Writes[OTIUMLA_ownedParameteredElement_owningTemplateParameter]
    = Json.writes[OTIUMLA_ownedParameteredElement_owningTemplateParameter]
  
    implicit def formats
    : Format[OTIUMLA_ownedParameteredElement_owningTemplateParameter]
    = Json.format[OTIUMLA_ownedParameteredElement_owningTemplateParameter]

  }

  /**
    * A_ownedReception_class
    *
    * @param: end1 A_ownedReception_class::class: Class [0..1] { unordered, unique, reference }
    * @param: end2 Class::ownedReception: Reception [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedReception_class
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedReception_class {
     
    implicit def reads
    : Reads[OTIUMLA_ownedReception_class]
    = Json.reads[OTIUMLA_ownedReception_class]
  
    implicit def writes
    : Writes[OTIUMLA_ownedReception_class]
    = Json.writes[OTIUMLA_ownedReception_class]
  
    implicit def formats
    : Format[OTIUMLA_ownedReception_class]
    = Json.format[OTIUMLA_ownedReception_class]

  }

  /**
    * A_ownedReception_interface
    *
    * @param: end1 A_ownedReception_interface::interface: Interface [0..1] { unordered, unique, reference }
    * @param: end2 Interface::ownedReception: Reception [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedReception_interface
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedReception_interface {
     
    implicit def reads
    : Reads[OTIUMLA_ownedReception_interface]
    = Json.reads[OTIUMLA_ownedReception_interface]
  
    implicit def writes
    : Writes[OTIUMLA_ownedReception_interface]
    = Json.writes[OTIUMLA_ownedReception_interface]
  
    implicit def formats
    : Format[OTIUMLA_ownedReception_interface]
    = Json.format[OTIUMLA_ownedReception_interface]

  }

  /**
    * A_ownedRule_context
    *
    * @param: end1 Constraint::context: Namespace [0..1] { unordered, unique, reference }
    * @param: end2 Namespace::ownedRule: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedRule_context
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedRule_context {
     
    implicit def reads
    : Reads[OTIUMLA_ownedRule_context]
    = Json.reads[OTIUMLA_ownedRule_context]
  
    implicit def writes
    : Writes[OTIUMLA_ownedRule_context]
    = Json.writes[OTIUMLA_ownedRule_context]
  
    implicit def formats
    : Format[OTIUMLA_ownedRule_context]
    = Json.format[OTIUMLA_ownedRule_context]

  }

  /**
    * A_ownedTemplateSignature_classifier
    *
    * @param: end1 RedefinableTemplateSignature::classifier: Classifier [1..1] { unordered, unique, reference }
    * @param: end2 Classifier::ownedTemplateSignature: RedefinableTemplateSignature [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedTemplateSignature_classifier
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedTemplateSignature_classifier {
     
    implicit def reads
    : Reads[OTIUMLA_ownedTemplateSignature_classifier]
    = Json.reads[OTIUMLA_ownedTemplateSignature_classifier]
  
    implicit def writes
    : Writes[OTIUMLA_ownedTemplateSignature_classifier]
    = Json.writes[OTIUMLA_ownedTemplateSignature_classifier]
  
    implicit def formats
    : Format[OTIUMLA_ownedTemplateSignature_classifier]
    = Json.format[OTIUMLA_ownedTemplateSignature_classifier]

  }

  /**
    * A_ownedTemplateSignature_template
    *
    * @param: end1 TemplateSignature::template: TemplateableElement [1..1] { unordered, unique, reference }
    * @param: end2 TemplateableElement::ownedTemplateSignature: TemplateSignature [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedTemplateSignature_template
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedTemplateSignature_template {
     
    implicit def reads
    : Reads[OTIUMLA_ownedTemplateSignature_template]
    = Json.reads[OTIUMLA_ownedTemplateSignature_template]
  
    implicit def writes
    : Writes[OTIUMLA_ownedTemplateSignature_template]
    = Json.writes[OTIUMLA_ownedTemplateSignature_template]
  
    implicit def formats
    : Format[OTIUMLA_ownedTemplateSignature_template]
    = Json.format[OTIUMLA_ownedTemplateSignature_template]

  }

  /**
    * A_ownedUseCase_classifier
    *
    * @param: end1 A_ownedUseCase_classifier::classifier: Classifier [0..1] { unordered, unique, reference }
    * @param: end2 Classifier::ownedUseCase: UseCase [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedUseCase_classifier
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_ownedUseCase_classifier {
     
    implicit def reads
    : Reads[OTIUMLA_ownedUseCase_classifier]
    = Json.reads[OTIUMLA_ownedUseCase_classifier]
  
    implicit def writes
    : Writes[OTIUMLA_ownedUseCase_classifier]
    = Json.writes[OTIUMLA_ownedUseCase_classifier]
  
    implicit def formats
    : Format[OTIUMLA_ownedUseCase_classifier]
    = Json.format[OTIUMLA_ownedUseCase_classifier]

  }

  /**
    * A_packageImport_importingNamespace
    *
    * @param: end1 PackageImport::importingNamespace: Namespace [1..1] { unordered, unique, reference }
    * @param: end2 Namespace::packageImport: PackageImport [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_packageImport_importingNamespace
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_packageImport_importingNamespace {
     
    implicit def reads
    : Reads[OTIUMLA_packageImport_importingNamespace]
    = Json.reads[OTIUMLA_packageImport_importingNamespace]
  
    implicit def writes
    : Writes[OTIUMLA_packageImport_importingNamespace]
    = Json.writes[OTIUMLA_packageImport_importingNamespace]
  
    implicit def formats
    : Format[OTIUMLA_packageImport_importingNamespace]
    = Json.format[OTIUMLA_packageImport_importingNamespace]

  }

  /**
    * A_packageMerge_receivingPackage
    *
    * @param: end1 PackageMerge::receivingPackage: Package [1..1] { unordered, unique, reference }
    * @param: end2 Package::packageMerge: PackageMerge [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_packageMerge_receivingPackage
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_packageMerge_receivingPackage {
     
    implicit def reads
    : Reads[OTIUMLA_packageMerge_receivingPackage]
    = Json.reads[OTIUMLA_packageMerge_receivingPackage]
  
    implicit def writes
    : Writes[OTIUMLA_packageMerge_receivingPackage]
    = Json.writes[OTIUMLA_packageMerge_receivingPackage]
  
    implicit def formats
    : Format[OTIUMLA_packageMerge_receivingPackage]
    = Json.format[OTIUMLA_packageMerge_receivingPackage]

  }

  /**
    * A_packagedElement_component
    *
    * @param: end1 A_packagedElement_component::component: Component [0..1] { unordered, unique, reference }
    * @param: end2 Component::packagedElement: PackageableElement [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_packagedElement_component
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_packagedElement_component {
     
    implicit def reads
    : Reads[OTIUMLA_packagedElement_component]
    = Json.reads[OTIUMLA_packagedElement_component]
  
    implicit def writes
    : Writes[OTIUMLA_packagedElement_component]
    = Json.writes[OTIUMLA_packagedElement_component]
  
    implicit def formats
    : Format[OTIUMLA_packagedElement_component]
    = Json.format[OTIUMLA_packagedElement_component]

  }

  /**
    * A_packagedElement_owningPackage
    *
    * @param: end1 A_packagedElement_owningPackage::owningPackage: Package [0..1] { unordered, unique, reference }
    * @param: end2 Package::packagedElement: PackageableElement [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_packagedElement_owningPackage
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_packagedElement_owningPackage {
     
    implicit def reads
    : Reads[OTIUMLA_packagedElement_owningPackage]
    = Json.reads[OTIUMLA_packagedElement_owningPackage]
  
    implicit def writes
    : Writes[OTIUMLA_packagedElement_owningPackage]
    = Json.writes[OTIUMLA_packagedElement_owningPackage]
  
    implicit def formats
    : Format[OTIUMLA_packagedElement_owningPackage]
    = Json.format[OTIUMLA_packagedElement_owningPackage]

  }

  /**
    * A_parameterSubstitution_templateBinding
    *
    * @param: end1 TemplateParameterSubstitution::templateBinding: TemplateBinding [1..1] { unordered, unique, reference }
    * @param: end2 TemplateBinding::parameterSubstitution: TemplateParameterSubstitution [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_parameterSubstitution_templateBinding
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_parameterSubstitution_templateBinding {
     
    implicit def reads
    : Reads[OTIUMLA_parameterSubstitution_templateBinding]
    = Json.reads[OTIUMLA_parameterSubstitution_templateBinding]
  
    implicit def writes
    : Writes[OTIUMLA_parameterSubstitution_templateBinding]
    = Json.writes[OTIUMLA_parameterSubstitution_templateBinding]
  
    implicit def formats
    : Format[OTIUMLA_parameterSubstitution_templateBinding]
    = Json.format[OTIUMLA_parameterSubstitution_templateBinding]

  }

  /**
    * A_postCondition_owningTransition
    *
    * @param: end1 A_postCondition_owningTransition::owningTransition: ProtocolTransition [0..1] { unordered, unique, reference }
    * @param: end2 ProtocolTransition::postCondition: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_postCondition_owningTransition
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_postCondition_owningTransition {
     
    implicit def reads
    : Reads[OTIUMLA_postCondition_owningTransition]
    = Json.reads[OTIUMLA_postCondition_owningTransition]
  
    implicit def writes
    : Writes[OTIUMLA_postCondition_owningTransition]
    = Json.writes[OTIUMLA_postCondition_owningTransition]
  
    implicit def formats
    : Format[OTIUMLA_postCondition_owningTransition]
    = Json.format[OTIUMLA_postCondition_owningTransition]

  }

  /**
    * A_postcondition_behavior
    *
    * @param: end1 A_postcondition_behavior::behavior: Behavior [0..1] { unordered, unique, reference }
    * @param: end2 Behavior::postcondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_postcondition_behavior
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_postcondition_behavior {
     
    implicit def reads
    : Reads[OTIUMLA_postcondition_behavior]
    = Json.reads[OTIUMLA_postcondition_behavior]
  
    implicit def writes
    : Writes[OTIUMLA_postcondition_behavior]
    = Json.writes[OTIUMLA_postcondition_behavior]
  
    implicit def formats
    : Format[OTIUMLA_postcondition_behavior]
    = Json.format[OTIUMLA_postcondition_behavior]

  }

  /**
    * A_postcondition_postContext
    *
    * @param: end1 A_postcondition_postContext::postContext: Operation [0..1] { unordered, unique, reference }
    * @param: end2 Operation::postcondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_postcondition_postContext
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_postcondition_postContext {
     
    implicit def reads
    : Reads[OTIUMLA_postcondition_postContext]
    = Json.reads[OTIUMLA_postcondition_postContext]
  
    implicit def writes
    : Writes[OTIUMLA_postcondition_postContext]
    = Json.writes[OTIUMLA_postcondition_postContext]
  
    implicit def formats
    : Format[OTIUMLA_postcondition_postContext]
    = Json.format[OTIUMLA_postcondition_postContext]

  }

  /**
    * A_preCondition_protocolTransition
    *
    * @param: end1 A_preCondition_protocolTransition::protocolTransition: ProtocolTransition [0..1] { unordered, unique, reference }
    * @param: end2 ProtocolTransition::preCondition: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_preCondition_protocolTransition
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_preCondition_protocolTransition {
     
    implicit def reads
    : Reads[OTIUMLA_preCondition_protocolTransition]
    = Json.reads[OTIUMLA_preCondition_protocolTransition]
  
    implicit def writes
    : Writes[OTIUMLA_preCondition_protocolTransition]
    = Json.writes[OTIUMLA_preCondition_protocolTransition]
  
    implicit def formats
    : Format[OTIUMLA_preCondition_protocolTransition]
    = Json.format[OTIUMLA_preCondition_protocolTransition]

  }

  /**
    * A_precondition_behavior
    *
    * @param: end1 A_precondition_behavior::behavior: Behavior [0..1] { unordered, unique, reference }
    * @param: end2 Behavior::precondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_precondition_behavior
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_precondition_behavior {
     
    implicit def reads
    : Reads[OTIUMLA_precondition_behavior]
    = Json.reads[OTIUMLA_precondition_behavior]
  
    implicit def writes
    : Writes[OTIUMLA_precondition_behavior]
    = Json.writes[OTIUMLA_precondition_behavior]
  
    implicit def formats
    : Format[OTIUMLA_precondition_behavior]
    = Json.format[OTIUMLA_precondition_behavior]

  }

  /**
    * A_precondition_preContext
    *
    * @param: end1 A_precondition_preContext::preContext: Operation [0..1] { unordered, unique, reference }
    * @param: end2 Operation::precondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_precondition_preContext
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_precondition_preContext {
     
    implicit def reads
    : Reads[OTIUMLA_precondition_preContext]
    = Json.reads[OTIUMLA_precondition_preContext]
  
    implicit def writes
    : Writes[OTIUMLA_precondition_preContext]
    = Json.writes[OTIUMLA_precondition_preContext]
  
    implicit def formats
    : Format[OTIUMLA_precondition_preContext]
    = Json.format[OTIUMLA_precondition_preContext]

  }

  /**
    * A_profileApplication_applyingPackage
    *
    * @param: end1 ProfileApplication::applyingPackage: Package [1..1] { unordered, unique, reference }
    * @param: end2 Package::profileApplication: ProfileApplication [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_profileApplication_applyingPackage
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_profileApplication_applyingPackage {
     
    implicit def reads
    : Reads[OTIUMLA_profileApplication_applyingPackage]
    = Json.reads[OTIUMLA_profileApplication_applyingPackage]
  
    implicit def writes
    : Writes[OTIUMLA_profileApplication_applyingPackage]
    = Json.writes[OTIUMLA_profileApplication_applyingPackage]
  
    implicit def formats
    : Format[OTIUMLA_profileApplication_applyingPackage]
    = Json.format[OTIUMLA_profileApplication_applyingPackage]

  }

  /**
    * A_protocol_interface
    *
    * @param: end1 A_protocol_interface::interface: Interface [0..1] { unordered, unique, reference }
    * @param: end2 Interface::protocol: ProtocolStateMachine [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_protocol_interface
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_protocol_interface {
     
    implicit def reads
    : Reads[OTIUMLA_protocol_interface]
    = Json.reads[OTIUMLA_protocol_interface]
  
    implicit def writes
    : Writes[OTIUMLA_protocol_interface]
    = Json.writes[OTIUMLA_protocol_interface]
  
    implicit def formats
    : Format[OTIUMLA_protocol_interface]
    = Json.format[OTIUMLA_protocol_interface]

  }

  /**
    * A_qualifier_associationEnd
    *
    * @param: end1 Property::associationEnd: Property [0..1] { unordered, unique, reference }
    * @param: end2 Property::qualifier: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_qualifier_associationEnd
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_qualifier_associationEnd {
     
    implicit def reads
    : Reads[OTIUMLA_qualifier_associationEnd]
    = Json.reads[OTIUMLA_qualifier_associationEnd]
  
    implicit def writes
    : Writes[OTIUMLA_qualifier_associationEnd]
    = Json.writes[OTIUMLA_qualifier_associationEnd]
  
    implicit def formats
    : Format[OTIUMLA_qualifier_associationEnd]
    = Json.format[OTIUMLA_qualifier_associationEnd]

  }

  /**
    * A_qualifier_linkEndData
    *
    * @param: end1 A_qualifier_linkEndData::linkEndData: LinkEndData [1..1] { unordered, unique, reference }
    * @param: end2 LinkEndData::qualifier: QualifierValue [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_qualifier_linkEndData
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_qualifier_linkEndData {
     
    implicit def reads
    : Reads[OTIUMLA_qualifier_linkEndData]
    = Json.reads[OTIUMLA_qualifier_linkEndData]
  
    implicit def writes
    : Writes[OTIUMLA_qualifier_linkEndData]
    = Json.writes[OTIUMLA_qualifier_linkEndData]
  
    implicit def formats
    : Format[OTIUMLA_qualifier_linkEndData]
    = Json.format[OTIUMLA_qualifier_linkEndData]

  }

  /**
    * A_realization_abstraction_component
    *
    * @param: end1 ComponentRealization::abstraction: Component [0..1] { unordered, unique, reference }
    * @param: end2 Component::realization: ComponentRealization [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_realization_abstraction_component
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_realization_abstraction_component {
     
    implicit def reads
    : Reads[OTIUMLA_realization_abstraction_component]
    = Json.reads[OTIUMLA_realization_abstraction_component]
  
    implicit def writes
    : Writes[OTIUMLA_realization_abstraction_component]
    = Json.writes[OTIUMLA_realization_abstraction_component]
  
    implicit def formats
    : Format[OTIUMLA_realization_abstraction_component]
    = Json.format[OTIUMLA_realization_abstraction_component]

  }

  /**
    * A_region_state
    *
    * @param: end1 Region::state: State [0..1] { unordered, unique, reference }
    * @param: end2 State::region: Region [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_region_state
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_region_state {
     
    implicit def reads
    : Reads[OTIUMLA_region_state]
    = Json.reads[OTIUMLA_region_state]
  
    implicit def writes
    : Writes[OTIUMLA_region_state]
    = Json.writes[OTIUMLA_region_state]
  
    implicit def formats
    : Format[OTIUMLA_region_state]
    = Json.format[OTIUMLA_region_state]

  }

  /**
    * A_region_stateMachine
    *
    * @param: end1 Region::stateMachine: StateMachine [0..1] { unordered, unique, reference }
    * @param: end2 StateMachine::region: Region [1..*] { unordered, unique, composite }
    */
  case class OTIUMLA_region_stateMachine
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_region_stateMachine {
     
    implicit def reads
    : Reads[OTIUMLA_region_stateMachine]
    = Json.reads[OTIUMLA_region_stateMachine]
  
    implicit def writes
    : Writes[OTIUMLA_region_stateMachine]
    = Json.writes[OTIUMLA_region_stateMachine]
  
    implicit def formats
    : Format[OTIUMLA_region_stateMachine]
    = Json.format[OTIUMLA_region_stateMachine]

  }

  /**
    * A_removeAt_removeStructuralFeatureValueAction
    *
    * @param: end1 A_removeAt_removeStructuralFeatureValueAction::removeStructuralFeatureValueAction: RemoveStructuralFeatureValueAction [0..1] { unordered, unique, reference }
    * @param: end2 RemoveStructuralFeatureValueAction::removeAt: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_removeAt_removeStructuralFeatureValueAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_removeAt_removeStructuralFeatureValueAction {
     
    implicit def reads
    : Reads[OTIUMLA_removeAt_removeStructuralFeatureValueAction]
    = Json.reads[OTIUMLA_removeAt_removeStructuralFeatureValueAction]
  
    implicit def writes
    : Writes[OTIUMLA_removeAt_removeStructuralFeatureValueAction]
    = Json.writes[OTIUMLA_removeAt_removeStructuralFeatureValueAction]
  
    implicit def formats
    : Format[OTIUMLA_removeAt_removeStructuralFeatureValueAction]
    = Json.format[OTIUMLA_removeAt_removeStructuralFeatureValueAction]

  }

  /**
    * A_removeAt_removeVariableValueAction
    *
    * @param: end1 A_removeAt_removeVariableValueAction::removeVariableValueAction: RemoveVariableValueAction [0..1] { unordered, unique, reference }
    * @param: end2 RemoveVariableValueAction::removeAt: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_removeAt_removeVariableValueAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_removeAt_removeVariableValueAction {
     
    implicit def reads
    : Reads[OTIUMLA_removeAt_removeVariableValueAction]
    = Json.reads[OTIUMLA_removeAt_removeVariableValueAction]
  
    implicit def writes
    : Writes[OTIUMLA_removeAt_removeVariableValueAction]
    = Json.writes[OTIUMLA_removeAt_removeVariableValueAction]
  
    implicit def formats
    : Format[OTIUMLA_removeAt_removeVariableValueAction]
    = Json.format[OTIUMLA_removeAt_removeVariableValueAction]

  }

  /**
    * A_replyValue_replyAction
    *
    * @param: end1 A_replyValue_replyAction::replyAction: ReplyAction [0..1] { unordered, unique, reference }
    * @param: end2 ReplyAction::replyValue: InputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_replyValue_replyAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_replyValue_replyAction {
     
    implicit def reads
    : Reads[OTIUMLA_replyValue_replyAction]
    = Json.reads[OTIUMLA_replyValue_replyAction]
  
    implicit def writes
    : Writes[OTIUMLA_replyValue_replyAction]
    = Json.writes[OTIUMLA_replyValue_replyAction]
  
    implicit def formats
    : Format[OTIUMLA_replyValue_replyAction]
    = Json.format[OTIUMLA_replyValue_replyAction]

  }

  /**
    * A_request_sendObjectAction
    *
    * @param: end1 A_request_sendObjectAction::sendObjectAction: SendObjectAction [0..1] { unordered, unique, reference }
    * @param: end2 SendObjectAction::request: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_request_sendObjectAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_request_sendObjectAction {
     
    implicit def reads
    : Reads[OTIUMLA_request_sendObjectAction]
    = Json.reads[OTIUMLA_request_sendObjectAction]
  
    implicit def writes
    : Writes[OTIUMLA_request_sendObjectAction]
    = Json.writes[OTIUMLA_request_sendObjectAction]
  
    implicit def formats
    : Format[OTIUMLA_request_sendObjectAction]
    = Json.format[OTIUMLA_request_sendObjectAction]

  }

  /**
    * A_result_acceptEventAction
    *
    * @param: end1 A_result_acceptEventAction::acceptEventAction: AcceptEventAction [0..1] { unordered, unique, reference }
    * @param: end2 AcceptEventAction::result: OutputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_result_acceptEventAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_result_acceptEventAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_acceptEventAction]
    = Json.reads[OTIUMLA_result_acceptEventAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_acceptEventAction]
    = Json.writes[OTIUMLA_result_acceptEventAction]
  
    implicit def formats
    : Format[OTIUMLA_result_acceptEventAction]
    = Json.format[OTIUMLA_result_acceptEventAction]

  }

  /**
    * A_result_callAction
    *
    * @param: end1 A_result_callAction::callAction: CallAction [0..1] { unordered, unique, reference }
    * @param: end2 CallAction::result: OutputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_result_callAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_result_callAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_callAction]
    = Json.reads[OTIUMLA_result_callAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_callAction]
    = Json.writes[OTIUMLA_result_callAction]
  
    implicit def formats
    : Format[OTIUMLA_result_callAction]
    = Json.format[OTIUMLA_result_callAction]

  }

  /**
    * A_result_clearStructuralFeatureAction
    *
    * @param: end1 A_result_clearStructuralFeatureAction::clearStructuralFeatureAction: ClearStructuralFeatureAction [0..1] { unordered, unique, reference }
    * @param: end2 ClearStructuralFeatureAction::result: OutputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_clearStructuralFeatureAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_clearStructuralFeatureAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_clearStructuralFeatureAction]
    = Json.reads[OTIUMLA_result_clearStructuralFeatureAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_clearStructuralFeatureAction]
    = Json.writes[OTIUMLA_result_clearStructuralFeatureAction]
  
    implicit def formats
    : Format[OTIUMLA_result_clearStructuralFeatureAction]
    = Json.format[OTIUMLA_result_clearStructuralFeatureAction]

  }

  /**
    * A_result_conditionalNode
    *
    * @param: end1 A_result_conditionalNode::conditionalNode: ConditionalNode [0..1] { unordered, unique, reference }
    * @param: end2 ConditionalNode::result: OutputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_result_conditionalNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_result_conditionalNode {
     
    implicit def reads
    : Reads[OTIUMLA_result_conditionalNode]
    = Json.reads[OTIUMLA_result_conditionalNode]
  
    implicit def writes
    : Writes[OTIUMLA_result_conditionalNode]
    = Json.writes[OTIUMLA_result_conditionalNode]
  
    implicit def formats
    : Format[OTIUMLA_result_conditionalNode]
    = Json.format[OTIUMLA_result_conditionalNode]

  }

  /**
    * A_result_createLinkObjectAction
    *
    * @param: end1 A_result_createLinkObjectAction::createLinkObjectAction: CreateLinkObjectAction [0..1] { unordered, unique, reference }
    * @param: end2 CreateLinkObjectAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_createLinkObjectAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_createLinkObjectAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_createLinkObjectAction]
    = Json.reads[OTIUMLA_result_createLinkObjectAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_createLinkObjectAction]
    = Json.writes[OTIUMLA_result_createLinkObjectAction]
  
    implicit def formats
    : Format[OTIUMLA_result_createLinkObjectAction]
    = Json.format[OTIUMLA_result_createLinkObjectAction]

  }

  /**
    * A_result_createObjectAction
    *
    * @param: end1 A_result_createObjectAction::createObjectAction: CreateObjectAction [0..1] { unordered, unique, reference }
    * @param: end2 CreateObjectAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_createObjectAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_createObjectAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_createObjectAction]
    = Json.reads[OTIUMLA_result_createObjectAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_createObjectAction]
    = Json.writes[OTIUMLA_result_createObjectAction]
  
    implicit def formats
    : Format[OTIUMLA_result_createObjectAction]
    = Json.format[OTIUMLA_result_createObjectAction]

  }

  /**
    * A_result_loopNode
    *
    * @param: end1 A_result_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param: end2 LoopNode::result: OutputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_result_loopNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_result_loopNode {
     
    implicit def reads
    : Reads[OTIUMLA_result_loopNode]
    = Json.reads[OTIUMLA_result_loopNode]
  
    implicit def writes
    : Writes[OTIUMLA_result_loopNode]
    = Json.writes[OTIUMLA_result_loopNode]
  
    implicit def formats
    : Format[OTIUMLA_result_loopNode]
    = Json.format[OTIUMLA_result_loopNode]

  }

  /**
    * A_result_readExtentAction
    *
    * @param: end1 A_result_readExtentAction::readExtentAction: ReadExtentAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadExtentAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readExtentAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_readExtentAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_readExtentAction]
    = Json.reads[OTIUMLA_result_readExtentAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_readExtentAction]
    = Json.writes[OTIUMLA_result_readExtentAction]
  
    implicit def formats
    : Format[OTIUMLA_result_readExtentAction]
    = Json.format[OTIUMLA_result_readExtentAction]

  }

  /**
    * A_result_readIsClassifiedObjectAction
    *
    * @param: end1 A_result_readIsClassifiedObjectAction::readIsClassifiedObjectAction: ReadIsClassifiedObjectAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadIsClassifiedObjectAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readIsClassifiedObjectAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_readIsClassifiedObjectAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_readIsClassifiedObjectAction]
    = Json.reads[OTIUMLA_result_readIsClassifiedObjectAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_readIsClassifiedObjectAction]
    = Json.writes[OTIUMLA_result_readIsClassifiedObjectAction]
  
    implicit def formats
    : Format[OTIUMLA_result_readIsClassifiedObjectAction]
    = Json.format[OTIUMLA_result_readIsClassifiedObjectAction]

  }

  /**
    * A_result_readLinkAction
    *
    * @param: end1 A_result_readLinkAction::readLinkAction: ReadLinkAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadLinkAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readLinkAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_readLinkAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_readLinkAction]
    = Json.reads[OTIUMLA_result_readLinkAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_readLinkAction]
    = Json.writes[OTIUMLA_result_readLinkAction]
  
    implicit def formats
    : Format[OTIUMLA_result_readLinkAction]
    = Json.format[OTIUMLA_result_readLinkAction]

  }

  /**
    * A_result_readLinkObjectEndAction
    *
    * @param: end1 A_result_readLinkObjectEndAction::readLinkObjectEndAction: ReadLinkObjectEndAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadLinkObjectEndAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readLinkObjectEndAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_readLinkObjectEndAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_readLinkObjectEndAction]
    = Json.reads[OTIUMLA_result_readLinkObjectEndAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_readLinkObjectEndAction]
    = Json.writes[OTIUMLA_result_readLinkObjectEndAction]
  
    implicit def formats
    : Format[OTIUMLA_result_readLinkObjectEndAction]
    = Json.format[OTIUMLA_result_readLinkObjectEndAction]

  }

  /**
    * A_result_readLinkObjectEndQualifierAction
    *
    * @param: end1 A_result_readLinkObjectEndQualifierAction::readLinkObjectEndQualifierAction: ReadLinkObjectEndQualifierAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadLinkObjectEndQualifierAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readLinkObjectEndQualifierAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_readLinkObjectEndQualifierAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_readLinkObjectEndQualifierAction]
    = Json.reads[OTIUMLA_result_readLinkObjectEndQualifierAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_readLinkObjectEndQualifierAction]
    = Json.writes[OTIUMLA_result_readLinkObjectEndQualifierAction]
  
    implicit def formats
    : Format[OTIUMLA_result_readLinkObjectEndQualifierAction]
    = Json.format[OTIUMLA_result_readLinkObjectEndQualifierAction]

  }

  /**
    * A_result_readSelfAction
    *
    * @param: end1 A_result_readSelfAction::readSelfAction: ReadSelfAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadSelfAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readSelfAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_readSelfAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_readSelfAction]
    = Json.reads[OTIUMLA_result_readSelfAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_readSelfAction]
    = Json.writes[OTIUMLA_result_readSelfAction]
  
    implicit def formats
    : Format[OTIUMLA_result_readSelfAction]
    = Json.format[OTIUMLA_result_readSelfAction]

  }

  /**
    * A_result_readStructuralFeatureAction
    *
    * @param: end1 A_result_readStructuralFeatureAction::readStructuralFeatureAction: ReadStructuralFeatureAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadStructuralFeatureAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readStructuralFeatureAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_readStructuralFeatureAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_readStructuralFeatureAction]
    = Json.reads[OTIUMLA_result_readStructuralFeatureAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_readStructuralFeatureAction]
    = Json.writes[OTIUMLA_result_readStructuralFeatureAction]
  
    implicit def formats
    : Format[OTIUMLA_result_readStructuralFeatureAction]
    = Json.format[OTIUMLA_result_readStructuralFeatureAction]

  }

  /**
    * A_result_readVariableAction
    *
    * @param: end1 A_result_readVariableAction::readVariableAction: ReadVariableAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadVariableAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readVariableAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_readVariableAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_readVariableAction]
    = Json.reads[OTIUMLA_result_readVariableAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_readVariableAction]
    = Json.writes[OTIUMLA_result_readVariableAction]
  
    implicit def formats
    : Format[OTIUMLA_result_readVariableAction]
    = Json.format[OTIUMLA_result_readVariableAction]

  }

  /**
    * A_result_reduceAction
    *
    * @param: end1 A_result_reduceAction::reduceAction: ReduceAction [0..1] { unordered, unique, reference }
    * @param: end2 ReduceAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_reduceAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_reduceAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_reduceAction]
    = Json.reads[OTIUMLA_result_reduceAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_reduceAction]
    = Json.writes[OTIUMLA_result_reduceAction]
  
    implicit def formats
    : Format[OTIUMLA_result_reduceAction]
    = Json.format[OTIUMLA_result_reduceAction]

  }

  /**
    * A_result_testIdentityAction
    *
    * @param: end1 A_result_testIdentityAction::testIdentityAction: TestIdentityAction [0..1] { unordered, unique, reference }
    * @param: end2 TestIdentityAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_testIdentityAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_testIdentityAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_testIdentityAction]
    = Json.reads[OTIUMLA_result_testIdentityAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_testIdentityAction]
    = Json.writes[OTIUMLA_result_testIdentityAction]
  
    implicit def formats
    : Format[OTIUMLA_result_testIdentityAction]
    = Json.format[OTIUMLA_result_testIdentityAction]

  }

  /**
    * A_result_unmarshallAction
    *
    * @param: end1 A_result_unmarshallAction::unmarshallAction: UnmarshallAction [0..1] { unordered, unique, reference }
    * @param: end2 UnmarshallAction::result: OutputPin [1..*] { ordered, unique, composite }
    */
  case class OTIUMLA_result_unmarshallAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_result_unmarshallAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_unmarshallAction]
    = Json.reads[OTIUMLA_result_unmarshallAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_unmarshallAction]
    = Json.writes[OTIUMLA_result_unmarshallAction]
  
    implicit def formats
    : Format[OTIUMLA_result_unmarshallAction]
    = Json.format[OTIUMLA_result_unmarshallAction]

  }

  /**
    * A_result_valueSpecificationAction
    *
    * @param: end1 A_result_valueSpecificationAction::valueSpecificationAction: ValueSpecificationAction [0..1] { unordered, unique, reference }
    * @param: end2 ValueSpecificationAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_valueSpecificationAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_valueSpecificationAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_valueSpecificationAction]
    = Json.reads[OTIUMLA_result_valueSpecificationAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_valueSpecificationAction]
    = Json.writes[OTIUMLA_result_valueSpecificationAction]
  
    implicit def formats
    : Format[OTIUMLA_result_valueSpecificationAction]
    = Json.format[OTIUMLA_result_valueSpecificationAction]

  }

  /**
    * A_result_writeStructuralFeatureAction
    *
    * @param: end1 A_result_writeStructuralFeatureAction::writeStructuralFeatureAction: WriteStructuralFeatureAction [0..1] { unordered, unique, reference }
    * @param: end2 WriteStructuralFeatureAction::result: OutputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_writeStructuralFeatureAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_result_writeStructuralFeatureAction {
     
    implicit def reads
    : Reads[OTIUMLA_result_writeStructuralFeatureAction]
    = Json.reads[OTIUMLA_result_writeStructuralFeatureAction]
  
    implicit def writes
    : Writes[OTIUMLA_result_writeStructuralFeatureAction]
    = Json.writes[OTIUMLA_result_writeStructuralFeatureAction]
  
    implicit def formats
    : Format[OTIUMLA_result_writeStructuralFeatureAction]
    = Json.format[OTIUMLA_result_writeStructuralFeatureAction]

  }

  /**
    * A_returnInformation_acceptCallAction
    *
    * @param: end1 A_returnInformation_acceptCallAction::acceptCallAction: AcceptCallAction [0..1] { unordered, unique, reference }
    * @param: end2 AcceptCallAction::returnInformation: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_returnInformation_acceptCallAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_returnInformation_acceptCallAction {
     
    implicit def reads
    : Reads[OTIUMLA_returnInformation_acceptCallAction]
    = Json.reads[OTIUMLA_returnInformation_acceptCallAction]
  
    implicit def writes
    : Writes[OTIUMLA_returnInformation_acceptCallAction]
    = Json.writes[OTIUMLA_returnInformation_acceptCallAction]
  
    implicit def formats
    : Format[OTIUMLA_returnInformation_acceptCallAction]
    = Json.format[OTIUMLA_returnInformation_acceptCallAction]

  }

  /**
    * A_returnInformation_replyAction
    *
    * @param: end1 A_returnInformation_replyAction::replyAction: ReplyAction [0..1] { unordered, unique, reference }
    * @param: end2 ReplyAction::returnInformation: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_returnInformation_replyAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_returnInformation_replyAction {
     
    implicit def reads
    : Reads[OTIUMLA_returnInformation_replyAction]
    = Json.reads[OTIUMLA_returnInformation_replyAction]
  
    implicit def writes
    : Writes[OTIUMLA_returnInformation_replyAction]
    = Json.writes[OTIUMLA_returnInformation_replyAction]
  
    implicit def formats
    : Format[OTIUMLA_returnInformation_replyAction]
    = Json.format[OTIUMLA_returnInformation_replyAction]

  }

  /**
    * A_returnValue_interactionUse
    *
    * @param: end1 A_returnValue_interactionUse::interactionUse: InteractionUse [0..1] { unordered, unique, reference }
    * @param: end2 InteractionUse::returnValue: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_returnValue_interactionUse
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_returnValue_interactionUse {
     
    implicit def reads
    : Reads[OTIUMLA_returnValue_interactionUse]
    = Json.reads[OTIUMLA_returnValue_interactionUse]
  
    implicit def writes
    : Writes[OTIUMLA_returnValue_interactionUse]
    = Json.writes[OTIUMLA_returnValue_interactionUse]
  
    implicit def formats
    : Format[OTIUMLA_returnValue_interactionUse]
    = Json.format[OTIUMLA_returnValue_interactionUse]

  }

  /**
    * A_roleBinding_collaborationUse
    *
    * @param: end1 A_roleBinding_collaborationUse::collaborationUse: CollaborationUse [0..1] { unordered, unique, reference }
    * @param: end2 CollaborationUse::roleBinding: Dependency [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_roleBinding_collaborationUse
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_roleBinding_collaborationUse {
     
    implicit def reads
    : Reads[OTIUMLA_roleBinding_collaborationUse]
    = Json.reads[OTIUMLA_roleBinding_collaborationUse]
  
    implicit def writes
    : Writes[OTIUMLA_roleBinding_collaborationUse]
    = Json.writes[OTIUMLA_roleBinding_collaborationUse]
  
    implicit def formats
    : Format[OTIUMLA_roleBinding_collaborationUse]
    = Json.format[OTIUMLA_roleBinding_collaborationUse]

  }

  /**
    * A_second_testIdentityAction
    *
    * @param: end1 A_second_testIdentityAction::testIdentityAction: TestIdentityAction [0..1] { unordered, unique, reference }
    * @param: end2 TestIdentityAction::second: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_second_testIdentityAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_second_testIdentityAction {
     
    implicit def reads
    : Reads[OTIUMLA_second_testIdentityAction]
    = Json.reads[OTIUMLA_second_testIdentityAction]
  
    implicit def writes
    : Writes[OTIUMLA_second_testIdentityAction]
    = Json.writes[OTIUMLA_second_testIdentityAction]
  
    implicit def formats
    : Format[OTIUMLA_second_testIdentityAction]
    = Json.format[OTIUMLA_second_testIdentityAction]

  }

  /**
    * A_selector_lifeline
    *
    * @param: end1 A_selector_lifeline::lifeline: Lifeline [0..1] { unordered, unique, reference }
    * @param: end2 Lifeline::selector: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_selector_lifeline
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_selector_lifeline {
     
    implicit def reads
    : Reads[OTIUMLA_selector_lifeline]
    = Json.reads[OTIUMLA_selector_lifeline]
  
    implicit def writes
    : Writes[OTIUMLA_selector_lifeline]
    = Json.writes[OTIUMLA_selector_lifeline]
  
    implicit def formats
    : Format[OTIUMLA_selector_lifeline]
    = Json.format[OTIUMLA_selector_lifeline]

  }

  /**
    * A_slot_owningInstance
    *
    * @param: end1 Slot::owningInstance: InstanceSpecification [1..1] { unordered, unique, reference }
    * @param: end2 InstanceSpecification::slot: Slot [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_slot_owningInstance
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_slot_owningInstance {
     
    implicit def reads
    : Reads[OTIUMLA_slot_owningInstance]
    = Json.reads[OTIUMLA_slot_owningInstance]
  
    implicit def writes
    : Writes[OTIUMLA_slot_owningInstance]
    = Json.writes[OTIUMLA_slot_owningInstance]
  
    implicit def formats
    : Format[OTIUMLA_slot_owningInstance]
    = Json.format[OTIUMLA_slot_owningInstance]

  }

  /**
    * A_specification_durationConstraint
    *
    * @param: end1 A_specification_durationConstraint::durationConstraint: DurationConstraint [0..1] { unordered, unique, reference }
    * @param: end2 DurationConstraint::specification: DurationInterval [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_specification_durationConstraint
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_specification_durationConstraint {
     
    implicit def reads
    : Reads[OTIUMLA_specification_durationConstraint]
    = Json.reads[OTIUMLA_specification_durationConstraint]
  
    implicit def writes
    : Writes[OTIUMLA_specification_durationConstraint]
    = Json.writes[OTIUMLA_specification_durationConstraint]
  
    implicit def formats
    : Format[OTIUMLA_specification_durationConstraint]
    = Json.format[OTIUMLA_specification_durationConstraint]

  }

  /**
    * A_specification_intervalConstraint
    *
    * @param: end1 A_specification_intervalConstraint::intervalConstraint: IntervalConstraint [0..1] { unordered, unique, reference }
    * @param: end2 IntervalConstraint::specification: Interval [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_specification_intervalConstraint
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_specification_intervalConstraint {
     
    implicit def reads
    : Reads[OTIUMLA_specification_intervalConstraint]
    = Json.reads[OTIUMLA_specification_intervalConstraint]
  
    implicit def writes
    : Writes[OTIUMLA_specification_intervalConstraint]
    = Json.writes[OTIUMLA_specification_intervalConstraint]
  
    implicit def formats
    : Format[OTIUMLA_specification_intervalConstraint]
    = Json.format[OTIUMLA_specification_intervalConstraint]

  }

  /**
    * A_specification_owningConstraint
    *
    * @param: end1 A_specification_owningConstraint::owningConstraint: Constraint [0..1] { unordered, unique, reference }
    * @param: end2 Constraint::specification: ValueSpecification [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_specification_owningConstraint
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_specification_owningConstraint {
     
    implicit def reads
    : Reads[OTIUMLA_specification_owningConstraint]
    = Json.reads[OTIUMLA_specification_owningConstraint]
  
    implicit def writes
    : Writes[OTIUMLA_specification_owningConstraint]
    = Json.writes[OTIUMLA_specification_owningConstraint]
  
    implicit def formats
    : Format[OTIUMLA_specification_owningConstraint]
    = Json.format[OTIUMLA_specification_owningConstraint]

  }

  /**
    * A_specification_owningInstanceSpec
    *
    * @param: end1 A_specification_owningInstanceSpec::owningInstanceSpec: InstanceSpecification [0..1] { unordered, unique, reference }
    * @param: end2 InstanceSpecification::specification: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_specification_owningInstanceSpec
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_specification_owningInstanceSpec {
     
    implicit def reads
    : Reads[OTIUMLA_specification_owningInstanceSpec]
    = Json.reads[OTIUMLA_specification_owningInstanceSpec]
  
    implicit def writes
    : Writes[OTIUMLA_specification_owningInstanceSpec]
    = Json.writes[OTIUMLA_specification_owningInstanceSpec]
  
    implicit def formats
    : Format[OTIUMLA_specification_owningInstanceSpec]
    = Json.format[OTIUMLA_specification_owningInstanceSpec]

  }

  /**
    * A_specification_timeConstraint
    *
    * @param: end1 A_specification_timeConstraint::timeConstraint: TimeConstraint [0..1] { unordered, unique, reference }
    * @param: end2 TimeConstraint::specification: TimeInterval [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_specification_timeConstraint
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_specification_timeConstraint {
     
    implicit def reads
    : Reads[OTIUMLA_specification_timeConstraint]
    = Json.reads[OTIUMLA_specification_timeConstraint]
  
    implicit def writes
    : Writes[OTIUMLA_specification_timeConstraint]
    = Json.writes[OTIUMLA_specification_timeConstraint]
  
    implicit def formats
    : Format[OTIUMLA_specification_timeConstraint]
    = Json.format[OTIUMLA_specification_timeConstraint]

  }

  /**
    * A_stateInvariant_owningState
    *
    * @param: end1 A_stateInvariant_owningState::owningState: State [0..1] { unordered, unique, reference }
    * @param: end2 State::stateInvariant: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_stateInvariant_owningState
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_stateInvariant_owningState {
     
    implicit def reads
    : Reads[OTIUMLA_stateInvariant_owningState]
    = Json.reads[OTIUMLA_stateInvariant_owningState]
  
    implicit def writes
    : Writes[OTIUMLA_stateInvariant_owningState]
    = Json.writes[OTIUMLA_stateInvariant_owningState]
  
    implicit def formats
    : Format[OTIUMLA_stateInvariant_owningState]
    = Json.format[OTIUMLA_stateInvariant_owningState]

  }

  /**
    * A_structuredNodeInput_structuredActivityNode
    *
    * @param: end1 A_structuredNodeInput_structuredActivityNode::structuredActivityNode: StructuredActivityNode [0..1] { unordered, unique, reference }
    * @param: end2 StructuredActivityNode::structuredNodeInput: InputPin [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_structuredNodeInput_structuredActivityNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_structuredNodeInput_structuredActivityNode {
     
    implicit def reads
    : Reads[OTIUMLA_structuredNodeInput_structuredActivityNode]
    = Json.reads[OTIUMLA_structuredNodeInput_structuredActivityNode]
  
    implicit def writes
    : Writes[OTIUMLA_structuredNodeInput_structuredActivityNode]
    = Json.writes[OTIUMLA_structuredNodeInput_structuredActivityNode]
  
    implicit def formats
    : Format[OTIUMLA_structuredNodeInput_structuredActivityNode]
    = Json.format[OTIUMLA_structuredNodeInput_structuredActivityNode]

  }

  /**
    * A_structuredNodeOutput_structuredActivityNode
    *
    * @param: end1 A_structuredNodeOutput_structuredActivityNode::structuredActivityNode: StructuredActivityNode [0..1] { unordered, unique, reference }
    * @param: end2 StructuredActivityNode::structuredNodeOutput: OutputPin [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_structuredNodeOutput_structuredActivityNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_structuredNodeOutput_structuredActivityNode {
     
    implicit def reads
    : Reads[OTIUMLA_structuredNodeOutput_structuredActivityNode]
    = Json.reads[OTIUMLA_structuredNodeOutput_structuredActivityNode]
  
    implicit def writes
    : Writes[OTIUMLA_structuredNodeOutput_structuredActivityNode]
    = Json.writes[OTIUMLA_structuredNodeOutput_structuredActivityNode]
  
    implicit def formats
    : Format[OTIUMLA_structuredNodeOutput_structuredActivityNode]
    = Json.format[OTIUMLA_structuredNodeOutput_structuredActivityNode]

  }

  /**
    * A_structuredNode_activity
    *
    * @param: end1 StructuredActivityNode::activity: Activity [0..1] { unordered, unique, reference }
    * @param: end2 Activity::structuredNode: StructuredActivityNode [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_structuredNode_activity
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_structuredNode_activity {
     
    implicit def reads
    : Reads[OTIUMLA_structuredNode_activity]
    = Json.reads[OTIUMLA_structuredNode_activity]
  
    implicit def writes
    : Writes[OTIUMLA_structuredNode_activity]
    = Json.writes[OTIUMLA_structuredNode_activity]
  
    implicit def formats
    : Format[OTIUMLA_structuredNode_activity]
    = Json.format[OTIUMLA_structuredNode_activity]

  }

  /**
    * A_subExpression_owningExpression
    *
    * @param: end1 StringExpression::owningExpression: StringExpression [0..1] { unordered, unique, reference }
    * @param: end2 StringExpression::subExpression: StringExpression [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_subExpression_owningExpression
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_subExpression_owningExpression {
     
    implicit def reads
    : Reads[OTIUMLA_subExpression_owningExpression]
    = Json.reads[OTIUMLA_subExpression_owningExpression]
  
    implicit def writes
    : Writes[OTIUMLA_subExpression_owningExpression]
    = Json.writes[OTIUMLA_subExpression_owningExpression]
  
    implicit def formats
    : Format[OTIUMLA_subExpression_owningExpression]
    = Json.format[OTIUMLA_subExpression_owningExpression]

  }

  /**
    * A_subpartition_superPartition
    *
    * @param: end1 ActivityPartition::superPartition: ActivityPartition [0..1] { unordered, unique, reference }
    * @param: end2 ActivityPartition::subpartition: ActivityPartition [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_subpartition_superPartition
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_subpartition_superPartition {
     
    implicit def reads
    : Reads[OTIUMLA_subpartition_superPartition]
    = Json.reads[OTIUMLA_subpartition_superPartition]
  
    implicit def writes
    : Writes[OTIUMLA_subpartition_superPartition]
    = Json.writes[OTIUMLA_subpartition_superPartition]
  
    implicit def formats
    : Format[OTIUMLA_subpartition_superPartition]
    = Json.format[OTIUMLA_subpartition_superPartition]

  }

  /**
    * A_substitution_substitutingClassifier
    *
    * @param: end1 Substitution::substitutingClassifier: Classifier [1..1] { unordered, unique, reference }
    * @param: end2 Classifier::substitution: Substitution [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_substitution_substitutingClassifier
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_substitution_substitutingClassifier {
     
    implicit def reads
    : Reads[OTIUMLA_substitution_substitutingClassifier]
    = Json.reads[OTIUMLA_substitution_substitutingClassifier]
  
    implicit def writes
    : Writes[OTIUMLA_substitution_substitutingClassifier]
    = Json.writes[OTIUMLA_substitution_substitutingClassifier]
  
    implicit def formats
    : Format[OTIUMLA_substitution_substitutingClassifier]
    = Json.format[OTIUMLA_substitution_substitutingClassifier]

  }

  /**
    * A_subvertex_container
    *
    * @param: end1 Vertex::container: Region [0..1] { unordered, unique, reference }
    * @param: end2 Region::subvertex: Vertex [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_subvertex_container
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_subvertex_container {
     
    implicit def reads
    : Reads[OTIUMLA_subvertex_container]
    = Json.reads[OTIUMLA_subvertex_container]
  
    implicit def writes
    : Writes[OTIUMLA_subvertex_container]
    = Json.writes[OTIUMLA_subvertex_container]
  
    implicit def formats
    : Format[OTIUMLA_subvertex_container]
    = Json.format[OTIUMLA_subvertex_container]

  }

  /**
    * A_target_callOperationAction
    *
    * @param: end1 A_target_callOperationAction::callOperationAction: CallOperationAction [0..1] { unordered, unique, reference }
    * @param: end2 CallOperationAction::target: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_target_callOperationAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_target_callOperationAction {
     
    implicit def reads
    : Reads[OTIUMLA_target_callOperationAction]
    = Json.reads[OTIUMLA_target_callOperationAction]
  
    implicit def writes
    : Writes[OTIUMLA_target_callOperationAction]
    = Json.writes[OTIUMLA_target_callOperationAction]
  
    implicit def formats
    : Format[OTIUMLA_target_callOperationAction]
    = Json.format[OTIUMLA_target_callOperationAction]

  }

  /**
    * A_target_destroyObjectAction
    *
    * @param: end1 A_target_destroyObjectAction::destroyObjectAction: DestroyObjectAction [0..1] { unordered, unique, reference }
    * @param: end2 DestroyObjectAction::target: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_target_destroyObjectAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_target_destroyObjectAction {
     
    implicit def reads
    : Reads[OTIUMLA_target_destroyObjectAction]
    = Json.reads[OTIUMLA_target_destroyObjectAction]
  
    implicit def writes
    : Writes[OTIUMLA_target_destroyObjectAction]
    = Json.writes[OTIUMLA_target_destroyObjectAction]
  
    implicit def formats
    : Format[OTIUMLA_target_destroyObjectAction]
    = Json.format[OTIUMLA_target_destroyObjectAction]

  }

  /**
    * A_target_sendObjectAction
    *
    * @param: end1 A_target_sendObjectAction::sendObjectAction: SendObjectAction [0..1] { unordered, unique, reference }
    * @param: end2 SendObjectAction::target: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_target_sendObjectAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_target_sendObjectAction {
     
    implicit def reads
    : Reads[OTIUMLA_target_sendObjectAction]
    = Json.reads[OTIUMLA_target_sendObjectAction]
  
    implicit def writes
    : Writes[OTIUMLA_target_sendObjectAction]
    = Json.writes[OTIUMLA_target_sendObjectAction]
  
    implicit def formats
    : Format[OTIUMLA_target_sendObjectAction]
    = Json.format[OTIUMLA_target_sendObjectAction]

  }

  /**
    * A_target_sendSignalAction
    *
    * @param: end1 A_target_sendSignalAction::sendSignalAction: SendSignalAction [0..1] { unordered, unique, reference }
    * @param: end2 SendSignalAction::target: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_target_sendSignalAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_target_sendSignalAction {
     
    implicit def reads
    : Reads[OTIUMLA_target_sendSignalAction]
    = Json.reads[OTIUMLA_target_sendSignalAction]
  
    implicit def writes
    : Writes[OTIUMLA_target_sendSignalAction]
    = Json.writes[OTIUMLA_target_sendSignalAction]
  
    implicit def formats
    : Format[OTIUMLA_target_sendSignalAction]
    = Json.format[OTIUMLA_target_sendSignalAction]

  }

  /**
    * A_templateBinding_boundElement
    *
    * @param: end1 TemplateBinding::boundElement: TemplateableElement [1..1] { unordered, unique, reference }
    * @param: end2 TemplateableElement::templateBinding: TemplateBinding [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_templateBinding_boundElement
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_templateBinding_boundElement {
     
    implicit def reads
    : Reads[OTIUMLA_templateBinding_boundElement]
    = Json.reads[OTIUMLA_templateBinding_boundElement]
  
    implicit def writes
    : Writes[OTIUMLA_templateBinding_boundElement]
    = Json.writes[OTIUMLA_templateBinding_boundElement]
  
    implicit def formats
    : Format[OTIUMLA_templateBinding_boundElement]
    = Json.format[OTIUMLA_templateBinding_boundElement]

  }

  /**
    * A_transition_container
    *
    * @param: end1 Transition::container: Region [1..1] { unordered, unique, reference }
    * @param: end2 Region::transition: Transition [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_transition_container
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_transition_container {
     
    implicit def reads
    : Reads[OTIUMLA_transition_container]
    = Json.reads[OTIUMLA_transition_container]
  
    implicit def writes
    : Writes[OTIUMLA_transition_container]
    = Json.writes[OTIUMLA_transition_container]
  
    implicit def formats
    : Format[OTIUMLA_transition_container]
    = Json.format[OTIUMLA_transition_container]

  }

  /**
    * A_trigger_acceptEventAction
    *
    * @param: end1 A_trigger_acceptEventAction::acceptEventAction: AcceptEventAction [0..1] { unordered, unique, reference }
    * @param: end2 AcceptEventAction::trigger: Trigger [1..*] { unordered, unique, composite }
    */
  case class OTIUMLA_trigger_acceptEventAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_trigger_acceptEventAction {
     
    implicit def reads
    : Reads[OTIUMLA_trigger_acceptEventAction]
    = Json.reads[OTIUMLA_trigger_acceptEventAction]
  
    implicit def writes
    : Writes[OTIUMLA_trigger_acceptEventAction]
    = Json.writes[OTIUMLA_trigger_acceptEventAction]
  
    implicit def formats
    : Format[OTIUMLA_trigger_acceptEventAction]
    = Json.format[OTIUMLA_trigger_acceptEventAction]

  }

  /**
    * A_trigger_transition
    *
    * @param: end1 A_trigger_transition::transition: Transition [0..1] { unordered, unique, reference }
    * @param: end2 Transition::trigger: Trigger [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_trigger_transition
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_trigger_transition {
     
    implicit def reads
    : Reads[OTIUMLA_trigger_transition]
    = Json.reads[OTIUMLA_trigger_transition]
  
    implicit def writes
    : Writes[OTIUMLA_trigger_transition]
    = Json.writes[OTIUMLA_trigger_transition]
  
    implicit def formats
    : Format[OTIUMLA_trigger_transition]
    = Json.format[OTIUMLA_trigger_transition]

  }

  /**
    * A_upperBound_objectNode
    *
    * @param: end1 A_upperBound_objectNode::objectNode: ObjectNode [0..1] { unordered, unique, reference }
    * @param: end2 ObjectNode::upperBound: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_upperBound_objectNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_upperBound_objectNode {
     
    implicit def reads
    : Reads[OTIUMLA_upperBound_objectNode]
    = Json.reads[OTIUMLA_upperBound_objectNode]
  
    implicit def writes
    : Writes[OTIUMLA_upperBound_objectNode]
    = Json.writes[OTIUMLA_upperBound_objectNode]
  
    implicit def formats
    : Format[OTIUMLA_upperBound_objectNode]
    = Json.format[OTIUMLA_upperBound_objectNode]

  }

  /**
    * A_upperValue_owningUpper
    *
    * @param: end1 A_upperValue_owningUpper::owningUpper: MultiplicityElement [0..1] { unordered, unique, reference }
    * @param: end2 MultiplicityElement::upperValue: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_upperValue_owningUpper
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_upperValue_owningUpper {
     
    implicit def reads
    : Reads[OTIUMLA_upperValue_owningUpper]
    = Json.reads[OTIUMLA_upperValue_owningUpper]
  
    implicit def writes
    : Writes[OTIUMLA_upperValue_owningUpper]
    = Json.writes[OTIUMLA_upperValue_owningUpper]
  
    implicit def formats
    : Format[OTIUMLA_upperValue_owningUpper]
    = Json.format[OTIUMLA_upperValue_owningUpper]

  }

  /**
    * A_value_owningSlot
    *
    * @param: end1 A_value_owningSlot::owningSlot: Slot [0..1] { unordered, unique, reference }
    * @param: end2 Slot::value: ValueSpecification [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_value_owningSlot
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFCompositeOrderedLink
  {}

  object OTIUMLA_value_owningSlot {
     
    implicit def reads
    : Reads[OTIUMLA_value_owningSlot]
    = Json.reads[OTIUMLA_value_owningSlot]
  
    implicit def writes
    : Writes[OTIUMLA_value_owningSlot]
    = Json.writes[OTIUMLA_value_owningSlot]
  
    implicit def formats
    : Format[OTIUMLA_value_owningSlot]
    = Json.format[OTIUMLA_value_owningSlot]

  }

  /**
    * A_value_valuePin
    *
    * @param: end1 A_value_valuePin::valuePin: ValuePin [0..1] { unordered, unique, reference }
    * @param: end2 ValuePin::value: ValueSpecification [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_value_valuePin
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_value_valuePin {
     
    implicit def reads
    : Reads[OTIUMLA_value_valuePin]
    = Json.reads[OTIUMLA_value_valuePin]
  
    implicit def writes
    : Writes[OTIUMLA_value_valuePin]
    = Json.writes[OTIUMLA_value_valuePin]
  
    implicit def formats
    : Format[OTIUMLA_value_valuePin]
    = Json.format[OTIUMLA_value_valuePin]

  }

  /**
    * A_value_valueSpecificationAction
    *
    * @param: end1 A_value_valueSpecificationAction::valueSpecificationAction: ValueSpecificationAction [0..1] { unordered, unique, reference }
    * @param: end2 ValueSpecificationAction::value: ValueSpecification [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_value_valueSpecificationAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_value_valueSpecificationAction {
     
    implicit def reads
    : Reads[OTIUMLA_value_valueSpecificationAction]
    = Json.reads[OTIUMLA_value_valueSpecificationAction]
  
    implicit def writes
    : Writes[OTIUMLA_value_valueSpecificationAction]
    = Json.writes[OTIUMLA_value_valueSpecificationAction]
  
    implicit def formats
    : Format[OTIUMLA_value_valueSpecificationAction]
    = Json.format[OTIUMLA_value_valueSpecificationAction]

  }

  /**
    * A_value_writeStructuralFeatureAction
    *
    * @param: end1 A_value_writeStructuralFeatureAction::writeStructuralFeatureAction: WriteStructuralFeatureAction [0..1] { unordered, unique, reference }
    * @param: end2 WriteStructuralFeatureAction::value: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_value_writeStructuralFeatureAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_value_writeStructuralFeatureAction {
     
    implicit def reads
    : Reads[OTIUMLA_value_writeStructuralFeatureAction]
    = Json.reads[OTIUMLA_value_writeStructuralFeatureAction]
  
    implicit def writes
    : Writes[OTIUMLA_value_writeStructuralFeatureAction]
    = Json.writes[OTIUMLA_value_writeStructuralFeatureAction]
  
    implicit def formats
    : Format[OTIUMLA_value_writeStructuralFeatureAction]
    = Json.format[OTIUMLA_value_writeStructuralFeatureAction]

  }

  /**
    * A_value_writeVariableAction
    *
    * @param: end1 A_value_writeVariableAction::writeVariableAction: WriteVariableAction [0..1] { unordered, unique, reference }
    * @param: end2 WriteVariableAction::value: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_value_writeVariableAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_value_writeVariableAction {
     
    implicit def reads
    : Reads[OTIUMLA_value_writeVariableAction]
    = Json.reads[OTIUMLA_value_writeVariableAction]
  
    implicit def writes
    : Writes[OTIUMLA_value_writeVariableAction]
    = Json.writes[OTIUMLA_value_writeVariableAction]
  
    implicit def formats
    : Format[OTIUMLA_value_writeVariableAction]
    = Json.format[OTIUMLA_value_writeVariableAction]

  }

  /**
    * A_variable_activityScope
    *
    * @param: end1 Variable::activityScope: Activity [0..1] { unordered, unique, reference }
    * @param: end2 Activity::variable: Variable [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_variable_activityScope
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_variable_activityScope {
     
    implicit def reads
    : Reads[OTIUMLA_variable_activityScope]
    = Json.reads[OTIUMLA_variable_activityScope]
  
    implicit def writes
    : Writes[OTIUMLA_variable_activityScope]
    = Json.writes[OTIUMLA_variable_activityScope]
  
    implicit def formats
    : Format[OTIUMLA_variable_activityScope]
    = Json.format[OTIUMLA_variable_activityScope]

  }

  /**
    * A_variable_scope
    *
    * @param: end1 Variable::scope: StructuredActivityNode [0..1] { unordered, unique, reference }
    * @param: end2 StructuredActivityNode::variable: Variable [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_variable_scope
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_variable_scope {
     
    implicit def reads
    : Reads[OTIUMLA_variable_scope]
    = Json.reads[OTIUMLA_variable_scope]
  
    implicit def writes
    : Writes[OTIUMLA_variable_scope]
    = Json.writes[OTIUMLA_variable_scope]
  
    implicit def formats
    : Format[OTIUMLA_variable_scope]
    = Json.format[OTIUMLA_variable_scope]

  }

  /**
    * A_weight_activityEdge
    *
    * @param: end1 A_weight_activityEdge::activityEdge: ActivityEdge [0..1] { unordered, unique, reference }
    * @param: end2 ActivityEdge::weight: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_weight_activityEdge
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_weight_activityEdge {
     
    implicit def reads
    : Reads[OTIUMLA_weight_activityEdge]
    = Json.reads[OTIUMLA_weight_activityEdge]
  
    implicit def writes
    : Writes[OTIUMLA_weight_activityEdge]
    = Json.writes[OTIUMLA_weight_activityEdge]
  
    implicit def formats
    : Format[OTIUMLA_weight_activityEdge]
    = Json.format[OTIUMLA_weight_activityEdge]

  }

  /**
    * A_when_timeEvent
    *
    * @param: end1 A_when_timeEvent::timeEvent: TimeEvent [0..1] { unordered, unique, reference }
    * @param: end2 TimeEvent::when: TimeExpression [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_when_timeEvent
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFCompositeLink
  {}

  object OTIUMLA_when_timeEvent {
     
    implicit def reads
    : Reads[OTIUMLA_when_timeEvent]
    = Json.reads[OTIUMLA_when_timeEvent]
  
    implicit def writes
    : Writes[OTIUMLA_when_timeEvent]
    = Json.writes[OTIUMLA_when_timeEvent]
  
    implicit def formats
    : Format[OTIUMLA_when_timeEvent]
    = Json.format[OTIUMLA_when_timeEvent]

  }


  /**
    * A_annotatedElement_comment
    *
    * @param: end1 A_annotatedElement_comment::comment: Comment [0..*] { unordered, unique, reference }
    * @param: end2 Comment::annotatedElement: Element [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_annotatedElement_comment
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_annotatedElement_comment {
     
    implicit def reads
    : Reads[OTIUMLA_annotatedElement_comment]
    = Json.reads[OTIUMLA_annotatedElement_comment]
  
    implicit def writes
    : Writes[OTIUMLA_annotatedElement_comment]
    = Json.writes[OTIUMLA_annotatedElement_comment]
  
    implicit def formats
    : Format[OTIUMLA_annotatedElement_comment]
    = Json.format[OTIUMLA_annotatedElement_comment]

  }

  /**
    * A_association_clearAssociationAction
    *
    * @param: end1 A_association_clearAssociationAction::clearAssociationAction: ClearAssociationAction [0..1] { unordered, unique, reference }
    * @param: end2 ClearAssociationAction::association: Association [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_association_clearAssociationAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_association_clearAssociationAction {
     
    implicit def reads
    : Reads[OTIUMLA_association_clearAssociationAction]
    = Json.reads[OTIUMLA_association_clearAssociationAction]
  
    implicit def writes
    : Writes[OTIUMLA_association_clearAssociationAction]
    = Json.writes[OTIUMLA_association_clearAssociationAction]
  
    implicit def formats
    : Format[OTIUMLA_association_clearAssociationAction]
    = Json.format[OTIUMLA_association_clearAssociationAction]

  }

  /**
    * A_before_toAfter
    *
    * @param: end1 GeneralOrdering::before: OccurrenceSpecification [1..1] { unordered, unique, reference }
    * @param: end2 OccurrenceSpecification::toAfter: GeneralOrdering [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_before_toAfter
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_before_toAfter {
     
    implicit def reads
    : Reads[OTIUMLA_before_toAfter]
    = Json.reads[OTIUMLA_before_toAfter]
  
    implicit def writes
    : Writes[OTIUMLA_before_toAfter]
    = Json.writes[OTIUMLA_before_toAfter]
  
    implicit def formats
    : Format[OTIUMLA_before_toAfter]
    = Json.format[OTIUMLA_before_toAfter]

  }

  /**
    * A_bodyOutput_clause
    *
    * @param: end1 A_bodyOutput_clause::clause: Clause [0..*] { unordered, unique, reference }
    * @param: end2 Clause::bodyOutput: OutputPin [0..*] { ordered, unique, reference }
    */
  case class OTIUMLA_bodyOutput_clause
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFReferenceOrderedLink
  {}

  object OTIUMLA_bodyOutput_clause {
     
    implicit def reads
    : Reads[OTIUMLA_bodyOutput_clause]
    = Json.reads[OTIUMLA_bodyOutput_clause]
  
    implicit def writes
    : Writes[OTIUMLA_bodyOutput_clause]
    = Json.writes[OTIUMLA_bodyOutput_clause]
  
    implicit def formats
    : Format[OTIUMLA_bodyOutput_clause]
    = Json.format[OTIUMLA_bodyOutput_clause]

  }

  /**
    * A_bodyOutput_loopNode
    *
    * @param: end1 A_bodyOutput_loopNode::loopNode: LoopNode [0..*] { unordered, unique, reference }
    * @param: end2 LoopNode::bodyOutput: OutputPin [0..*] { ordered, unique, reference }
    */
  case class OTIUMLA_bodyOutput_loopNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFReferenceOrderedLink
  {}

  object OTIUMLA_bodyOutput_loopNode {
     
    implicit def reads
    : Reads[OTIUMLA_bodyOutput_loopNode]
    = Json.reads[OTIUMLA_bodyOutput_loopNode]
  
    implicit def writes
    : Writes[OTIUMLA_bodyOutput_loopNode]
    = Json.writes[OTIUMLA_bodyOutput_loopNode]
  
    implicit def formats
    : Format[OTIUMLA_bodyOutput_loopNode]
    = Json.format[OTIUMLA_bodyOutput_loopNode]

  }

  /**
    * A_bodyPart_loopNode
    *
    * @param: end1 A_bodyPart_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param: end2 LoopNode::bodyPart: ExecutableNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_bodyPart_loopNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_bodyPart_loopNode {
     
    implicit def reads
    : Reads[OTIUMLA_bodyPart_loopNode]
    = Json.reads[OTIUMLA_bodyPart_loopNode]
  
    implicit def writes
    : Writes[OTIUMLA_bodyPart_loopNode]
    = Json.writes[OTIUMLA_bodyPart_loopNode]
  
    implicit def formats
    : Format[OTIUMLA_bodyPart_loopNode]
    = Json.format[OTIUMLA_bodyPart_loopNode]

  }

  /**
    * A_body_clause
    *
    * @param: end1 A_body_clause::clause: Clause [0..1] { unordered, unique, reference }
    * @param: end2 Clause::body: ExecutableNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_body_clause
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_body_clause {
     
    implicit def reads
    : Reads[OTIUMLA_body_clause]
    = Json.reads[OTIUMLA_body_clause]
  
    implicit def writes
    : Writes[OTIUMLA_body_clause]
    = Json.writes[OTIUMLA_body_clause]
  
    implicit def formats
    : Format[OTIUMLA_body_clause]
    = Json.format[OTIUMLA_body_clause]

  }

  /**
    * A_classifierBehavior_behavioredClassifier
    *
    * @param: end1 A_classifierBehavior_behavioredClassifier::behavioredClassifier: BehavioredClassifier [0..1] { unordered, unique, reference }
    * @param: end2 BehavioredClassifier::classifierBehavior: Behavior [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_classifierBehavior_behavioredClassifier
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_classifierBehavior_behavioredClassifier {
     
    implicit def reads
    : Reads[OTIUMLA_classifierBehavior_behavioredClassifier]
    = Json.reads[OTIUMLA_classifierBehavior_behavioredClassifier]
  
    implicit def writes
    : Writes[OTIUMLA_classifierBehavior_behavioredClassifier]
    = Json.writes[OTIUMLA_classifierBehavior_behavioredClassifier]
  
    implicit def formats
    : Format[OTIUMLA_classifierBehavior_behavioredClassifier]
    = Json.format[OTIUMLA_classifierBehavior_behavioredClassifier]

  }

  /**
    * A_classifier_instanceSpecification
    *
    * @param: end1 A_classifier_instanceSpecification::instanceSpecification: InstanceSpecification [0..*] { unordered, unique, reference }
    * @param: end2 InstanceSpecification::classifier: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_classifier_instanceSpecification
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_classifier_instanceSpecification {
     
    implicit def reads
    : Reads[OTIUMLA_classifier_instanceSpecification]
    = Json.reads[OTIUMLA_classifier_instanceSpecification]
  
    implicit def writes
    : Writes[OTIUMLA_classifier_instanceSpecification]
    = Json.writes[OTIUMLA_classifier_instanceSpecification]
  
    implicit def formats
    : Format[OTIUMLA_classifier_instanceSpecification]
    = Json.format[OTIUMLA_classifier_instanceSpecification]

  }

  /**
    * A_classifier_readExtentAction
    *
    * @param: end1 A_classifier_readExtentAction::readExtentAction: ReadExtentAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadExtentAction::classifier: Classifier [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_classifier_readExtentAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_classifier_readExtentAction {
     
    implicit def reads
    : Reads[OTIUMLA_classifier_readExtentAction]
    = Json.reads[OTIUMLA_classifier_readExtentAction]
  
    implicit def writes
    : Writes[OTIUMLA_classifier_readExtentAction]
    = Json.writes[OTIUMLA_classifier_readExtentAction]
  
    implicit def formats
    : Format[OTIUMLA_classifier_readExtentAction]
    = Json.format[OTIUMLA_classifier_readExtentAction]

  }

  /**
    * A_classifier_templateParameter_parameteredElement
    *
    * @param: end1 ClassifierTemplateParameter::parameteredElement: Classifier [1..1] { unordered, unique, reference }
    * @param: end2 Classifier::templateParameter: ClassifierTemplateParameter [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_classifier_templateParameter_parameteredElement
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_classifier_templateParameter_parameteredElement {
     
    implicit def reads
    : Reads[OTIUMLA_classifier_templateParameter_parameteredElement]
    = Json.reads[OTIUMLA_classifier_templateParameter_parameteredElement]
  
    implicit def writes
    : Writes[OTIUMLA_classifier_templateParameter_parameteredElement]
    = Json.writes[OTIUMLA_classifier_templateParameter_parameteredElement]
  
    implicit def formats
    : Format[OTIUMLA_classifier_templateParameter_parameteredElement]
    = Json.format[OTIUMLA_classifier_templateParameter_parameteredElement]

  }

  /**
    * A_clientDependency_client
    *
    * @param: end1 NamedElement::clientDependency: Dependency [0..*] { unordered, unique, reference }
    * @param: end2 Dependency::client: NamedElement [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_clientDependency_client
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_clientDependency_client {
     
    implicit def reads
    : Reads[OTIUMLA_clientDependency_client]
    = Json.reads[OTIUMLA_clientDependency_client]
  
    implicit def writes
    : Writes[OTIUMLA_clientDependency_client]
    = Json.writes[OTIUMLA_clientDependency_client]
  
    implicit def formats
    : Format[OTIUMLA_clientDependency_client]
    = Json.format[OTIUMLA_clientDependency_client]

  }

  /**
    * A_collaborationRole_collaboration
    *
    * @param: end1 A_collaborationRole_collaboration::collaboration: Collaboration [0..*] { unordered, unique, reference }
    * @param: end2 Collaboration::collaborationRole: ConnectableElement [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_collaborationRole_collaboration
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_collaborationRole_collaboration {
     
    implicit def reads
    : Reads[OTIUMLA_collaborationRole_collaboration]
    = Json.reads[OTIUMLA_collaborationRole_collaboration]
  
    implicit def writes
    : Writes[OTIUMLA_collaborationRole_collaboration]
    = Json.writes[OTIUMLA_collaborationRole_collaboration]
  
    implicit def formats
    : Format[OTIUMLA_collaborationRole_collaboration]
    = Json.format[OTIUMLA_collaborationRole_collaboration]

  }

  /**
    * A_connectableElement_templateParameter_parameteredElement
    *
    * @param: end1 ConnectableElementTemplateParameter::parameteredElement: ConnectableElement [1..1] { unordered, unique, reference }
    * @param: end2 ConnectableElement::templateParameter: ConnectableElementTemplateParameter [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_connectableElement_templateParameter_parameteredElement
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_connectableElement_templateParameter_parameteredElement {
     
    implicit def reads
    : Reads[OTIUMLA_connectableElement_templateParameter_parameteredElement]
    = Json.reads[OTIUMLA_connectableElement_templateParameter_parameteredElement]
  
    implicit def writes
    : Writes[OTIUMLA_connectableElement_templateParameter_parameteredElement]
    = Json.writes[OTIUMLA_connectableElement_templateParameter_parameteredElement]
  
    implicit def formats
    : Format[OTIUMLA_connectableElement_templateParameter_parameteredElement]
    = Json.format[OTIUMLA_connectableElement_templateParameter_parameteredElement]

  }

  /**
    * A_constrainedElement_constraint
    *
    * @param: end1 A_constrainedElement_constraint::constraint: Constraint [0..*] { unordered, unique, reference }
    * @param: end2 Constraint::constrainedElement: Element [0..*] { ordered, unique, reference }
    */
  case class OTIUMLA_constrainedElement_constraint
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFReferenceOrderedLink
  {}

  object OTIUMLA_constrainedElement_constraint {
     
    implicit def reads
    : Reads[OTIUMLA_constrainedElement_constraint]
    = Json.reads[OTIUMLA_constrainedElement_constraint]
  
    implicit def writes
    : Writes[OTIUMLA_constrainedElement_constraint]
    = Json.writes[OTIUMLA_constrainedElement_constraint]
  
    implicit def formats
    : Format[OTIUMLA_constrainedElement_constraint]
    = Json.format[OTIUMLA_constrainedElement_constraint]

  }

  /**
    * A_constrainingClassifier_classifierTemplateParameter
    *
    * @param: end1 A_constrainingClassifier_classifierTemplateParameter::classifierTemplateParameter: ClassifierTemplateParameter [0..*] { unordered, unique, reference }
    * @param: end2 ClassifierTemplateParameter::constrainingClassifier: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_constrainingClassifier_classifierTemplateParameter
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_constrainingClassifier_classifierTemplateParameter {
     
    implicit def reads
    : Reads[OTIUMLA_constrainingClassifier_classifierTemplateParameter]
    = Json.reads[OTIUMLA_constrainingClassifier_classifierTemplateParameter]
  
    implicit def writes
    : Writes[OTIUMLA_constrainingClassifier_classifierTemplateParameter]
    = Json.writes[OTIUMLA_constrainingClassifier_classifierTemplateParameter]
  
    implicit def formats
    : Format[OTIUMLA_constrainingClassifier_classifierTemplateParameter]
    = Json.format[OTIUMLA_constrainingClassifier_classifierTemplateParameter]

  }

  /**
    * A_contract_connector
    *
    * @param: end1 A_contract_connector::connector: Connector [0..*] { unordered, unique, reference }
    * @param: end2 Connector::contract: Behavior [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_contract_connector
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_contract_connector {
     
    implicit def reads
    : Reads[OTIUMLA_contract_connector]
    = Json.reads[OTIUMLA_contract_connector]
  
    implicit def writes
    : Writes[OTIUMLA_contract_connector]
    = Json.writes[OTIUMLA_contract_connector]
  
    implicit def formats
    : Format[OTIUMLA_contract_connector]
    = Json.format[OTIUMLA_contract_connector]

  }

  /**
    * A_conveyed_conveyingFlow
    *
    * @param: end1 A_conveyed_conveyingFlow::conveyingFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param: end2 InformationFlow::conveyed: Classifier [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_conveyed_conveyingFlow
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_conveyed_conveyingFlow {
     
    implicit def reads
    : Reads[OTIUMLA_conveyed_conveyingFlow]
    = Json.reads[OTIUMLA_conveyed_conveyingFlow]
  
    implicit def writes
    : Writes[OTIUMLA_conveyed_conveyingFlow]
    = Json.writes[OTIUMLA_conveyed_conveyingFlow]
  
    implicit def formats
    : Format[OTIUMLA_conveyed_conveyingFlow]
    = Json.format[OTIUMLA_conveyed_conveyingFlow]

  }

  /**
    * A_covered_coveredBy
    *
    * @param: end1 Lifeline::coveredBy: InteractionFragment [0..*] { unordered, unique, reference }
    * @param: end2 InteractionFragment::covered: Lifeline [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_covered_coveredBy
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_covered_coveredBy {
     
    implicit def reads
    : Reads[OTIUMLA_covered_coveredBy]
    = Json.reads[OTIUMLA_covered_coveredBy]
  
    implicit def writes
    : Writes[OTIUMLA_covered_coveredBy]
    = Json.writes[OTIUMLA_covered_coveredBy]
  
    implicit def formats
    : Format[OTIUMLA_covered_coveredBy]
    = Json.format[OTIUMLA_covered_coveredBy]

  }

  /**
    * A_decider_clause
    *
    * @param: end1 A_decider_clause::clause: Clause [0..1] { unordered, unique, reference }
    * @param: end2 Clause::decider: OutputPin [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_decider_clause
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_decider_clause {
     
    implicit def reads
    : Reads[OTIUMLA_decider_clause]
    = Json.reads[OTIUMLA_decider_clause]
  
    implicit def writes
    : Writes[OTIUMLA_decider_clause]
    = Json.writes[OTIUMLA_decider_clause]
  
    implicit def formats
    : Format[OTIUMLA_decider_clause]
    = Json.format[OTIUMLA_decider_clause]

  }

  /**
    * A_decider_loopNode
    *
    * @param: end1 A_decider_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param: end2 LoopNode::decider: OutputPin [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_decider_loopNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_decider_loopNode {
     
    implicit def reads
    : Reads[OTIUMLA_decider_loopNode]
    = Json.reads[OTIUMLA_decider_loopNode]
  
    implicit def writes
    : Writes[OTIUMLA_decider_loopNode]
    = Json.writes[OTIUMLA_decider_loopNode]
  
    implicit def formats
    : Format[OTIUMLA_decider_loopNode]
    = Json.format[OTIUMLA_decider_loopNode]

  }

  /**
    * A_decisionInputFlow_decisionNode
    *
    * @param: end1 A_decisionInputFlow_decisionNode::decisionNode: DecisionNode [0..1] { unordered, unique, reference }
    * @param: end2 DecisionNode::decisionInputFlow: ObjectFlow [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_decisionInputFlow_decisionNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_decisionInputFlow_decisionNode {
     
    implicit def reads
    : Reads[OTIUMLA_decisionInputFlow_decisionNode]
    = Json.reads[OTIUMLA_decisionInputFlow_decisionNode]
  
    implicit def writes
    : Writes[OTIUMLA_decisionInputFlow_decisionNode]
    = Json.writes[OTIUMLA_decisionInputFlow_decisionNode]
  
    implicit def formats
    : Format[OTIUMLA_decisionInputFlow_decisionNode]
    = Json.format[OTIUMLA_decisionInputFlow_decisionNode]

  }

  /**
    * A_decomposedAs_lifeline
    *
    * @param: end1 A_decomposedAs_lifeline::lifeline: Lifeline [1..1] { unordered, unique, reference }
    * @param: end2 Lifeline::decomposedAs: PartDecomposition [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_decomposedAs_lifeline
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_decomposedAs_lifeline {
     
    implicit def reads
    : Reads[OTIUMLA_decomposedAs_lifeline]
    = Json.reads[OTIUMLA_decomposedAs_lifeline]
  
    implicit def writes
    : Writes[OTIUMLA_decomposedAs_lifeline]
    = Json.writes[OTIUMLA_decomposedAs_lifeline]
  
    implicit def formats
    : Format[OTIUMLA_decomposedAs_lifeline]
    = Json.format[OTIUMLA_decomposedAs_lifeline]

  }

  /**
    * A_deployedArtifact_deploymentForArtifact
    *
    * @param: end1 A_deployedArtifact_deploymentForArtifact::deploymentForArtifact: Deployment [0..*] { unordered, unique, reference }
    * @param: end2 Deployment::deployedArtifact: DeployedArtifact [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_deployedArtifact_deploymentForArtifact
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_deployedArtifact_deploymentForArtifact {
     
    implicit def reads
    : Reads[OTIUMLA_deployedArtifact_deploymentForArtifact]
    = Json.reads[OTIUMLA_deployedArtifact_deploymentForArtifact]
  
    implicit def writes
    : Writes[OTIUMLA_deployedArtifact_deploymentForArtifact]
    = Json.writes[OTIUMLA_deployedArtifact_deploymentForArtifact]
  
    implicit def formats
    : Format[OTIUMLA_deployedArtifact_deploymentForArtifact]
    = Json.format[OTIUMLA_deployedArtifact_deploymentForArtifact]

  }

  /**
    * A_destroyAt_linkEndDestructionData
    *
    * @param: end1 A_destroyAt_linkEndDestructionData::linkEndDestructionData: LinkEndDestructionData [0..1] { unordered, unique, reference }
    * @param: end2 LinkEndDestructionData::destroyAt: InputPin [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_destroyAt_linkEndDestructionData
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_destroyAt_linkEndDestructionData {
     
    implicit def reads
    : Reads[OTIUMLA_destroyAt_linkEndDestructionData]
    = Json.reads[OTIUMLA_destroyAt_linkEndDestructionData]
  
    implicit def writes
    : Writes[OTIUMLA_destroyAt_linkEndDestructionData]
    = Json.writes[OTIUMLA_destroyAt_linkEndDestructionData]
  
    implicit def formats
    : Format[OTIUMLA_destroyAt_linkEndDestructionData]
    = Json.format[OTIUMLA_destroyAt_linkEndDestructionData]

  }

  /**
    * A_edge_inPartition
    *
    * @param: end1 ActivityEdge::inPartition: ActivityPartition [0..*] { unordered, unique, reference }
    * @param: end2 ActivityPartition::edge: ActivityEdge [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_edge_inPartition
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_edge_inPartition {
     
    implicit def reads
    : Reads[OTIUMLA_edge_inPartition]
    = Json.reads[OTIUMLA_edge_inPartition]
  
    implicit def writes
    : Writes[OTIUMLA_edge_inPartition]
    = Json.writes[OTIUMLA_edge_inPartition]
  
    implicit def formats
    : Format[OTIUMLA_edge_inPartition]
    = Json.format[OTIUMLA_edge_inPartition]

  }

  /**
    * A_end_readLinkObjectEndAction
    *
    * @param: end1 A_end_readLinkObjectEndAction::readLinkObjectEndAction: ReadLinkObjectEndAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadLinkObjectEndAction::end: Property [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_end_readLinkObjectEndAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_end_readLinkObjectEndAction {
     
    implicit def reads
    : Reads[OTIUMLA_end_readLinkObjectEndAction]
    = Json.reads[OTIUMLA_end_readLinkObjectEndAction]
  
    implicit def writes
    : Writes[OTIUMLA_end_readLinkObjectEndAction]
    = Json.writes[OTIUMLA_end_readLinkObjectEndAction]
  
    implicit def formats
    : Format[OTIUMLA_end_readLinkObjectEndAction]
    = Json.format[OTIUMLA_end_readLinkObjectEndAction]

  }

  /**
    * A_entry_connectionPointReference
    *
    * @param: end1 A_entry_connectionPointReference::connectionPointReference: ConnectionPointReference [0..1] { unordered, unique, reference }
    * @param: end2 ConnectionPointReference::entry: Pseudostate [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_entry_connectionPointReference
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_entry_connectionPointReference {
     
    implicit def reads
    : Reads[OTIUMLA_entry_connectionPointReference]
    = Json.reads[OTIUMLA_entry_connectionPointReference]
  
    implicit def writes
    : Writes[OTIUMLA_entry_connectionPointReference]
    = Json.writes[OTIUMLA_entry_connectionPointReference]
  
    implicit def formats
    : Format[OTIUMLA_entry_connectionPointReference]
    = Json.format[OTIUMLA_entry_connectionPointReference]

  }

  /**
    * A_event_durationObservation
    *
    * @param: end1 A_event_durationObservation::durationObservation: DurationObservation [0..*] { unordered, unique, reference }
    * @param: end2 DurationObservation::event: NamedElement [1..2] { ordered, unique, reference }
    */
  case class OTIUMLA_event_durationObservation
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFReferenceOrderedLink
  {}

  object OTIUMLA_event_durationObservation {
     
    implicit def reads
    : Reads[OTIUMLA_event_durationObservation]
    = Json.reads[OTIUMLA_event_durationObservation]
  
    implicit def writes
    : Writes[OTIUMLA_event_durationObservation]
    = Json.writes[OTIUMLA_event_durationObservation]
  
    implicit def formats
    : Format[OTIUMLA_event_durationObservation]
    = Json.format[OTIUMLA_event_durationObservation]

  }

  /**
    * A_exceptionType_exceptionHandler
    *
    * @param: end1 A_exceptionType_exceptionHandler::exceptionHandler: ExceptionHandler [0..*] { unordered, unique, reference }
    * @param: end2 ExceptionHandler::exceptionType: Classifier [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_exceptionType_exceptionHandler
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_exceptionType_exceptionHandler {
     
    implicit def reads
    : Reads[OTIUMLA_exceptionType_exceptionHandler]
    = Json.reads[OTIUMLA_exceptionType_exceptionHandler]
  
    implicit def writes
    : Writes[OTIUMLA_exceptionType_exceptionHandler]
    = Json.writes[OTIUMLA_exceptionType_exceptionHandler]
  
    implicit def formats
    : Format[OTIUMLA_exceptionType_exceptionHandler]
    = Json.format[OTIUMLA_exceptionType_exceptionHandler]

  }

  /**
    * A_execution_executionOccurrenceSpecification
    *
    * @param: end1 A_execution_executionOccurrenceSpecification::executionOccurrenceSpecification: ExecutionOccurrenceSpecification [0..2] { unordered, unique, reference }
    * @param: end2 ExecutionOccurrenceSpecification::execution: ExecutionSpecification [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_execution_executionOccurrenceSpecification
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_execution_executionOccurrenceSpecification {
     
    implicit def reads
    : Reads[OTIUMLA_execution_executionOccurrenceSpecification]
    = Json.reads[OTIUMLA_execution_executionOccurrenceSpecification]
  
    implicit def writes
    : Writes[OTIUMLA_execution_executionOccurrenceSpecification]
    = Json.writes[OTIUMLA_execution_executionOccurrenceSpecification]
  
    implicit def formats
    : Format[OTIUMLA_execution_executionOccurrenceSpecification]
    = Json.format[OTIUMLA_execution_executionOccurrenceSpecification]

  }

  /**
    * A_exit_connectionPointReference
    *
    * @param: end1 A_exit_connectionPointReference::connectionPointReference: ConnectionPointReference [0..1] { unordered, unique, reference }
    * @param: end2 ConnectionPointReference::exit: Pseudostate [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_exit_connectionPointReference
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_exit_connectionPointReference {
     
    implicit def reads
    : Reads[OTIUMLA_exit_connectionPointReference]
    = Json.reads[OTIUMLA_exit_connectionPointReference]
  
    implicit def writes
    : Writes[OTIUMLA_exit_connectionPointReference]
    = Json.writes[OTIUMLA_exit_connectionPointReference]
  
    implicit def formats
    : Format[OTIUMLA_exit_connectionPointReference]
    = Json.format[OTIUMLA_exit_connectionPointReference]

  }

  /**
    * A_extendedSignature_redefinableTemplateSignature
    *
    * @param: end1 A_extendedSignature_redefinableTemplateSignature::redefinableTemplateSignature: RedefinableTemplateSignature [0..*] { unordered, unique, reference }
    * @param: end2 RedefinableTemplateSignature::extendedSignature: RedefinableTemplateSignature [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_extendedSignature_redefinableTemplateSignature
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_extendedSignature_redefinableTemplateSignature {
     
    implicit def reads
    : Reads[OTIUMLA_extendedSignature_redefinableTemplateSignature]
    = Json.reads[OTIUMLA_extendedSignature_redefinableTemplateSignature]
  
    implicit def writes
    : Writes[OTIUMLA_extendedSignature_redefinableTemplateSignature]
    = Json.writes[OTIUMLA_extendedSignature_redefinableTemplateSignature]
  
    implicit def formats
    : Format[OTIUMLA_extendedSignature_redefinableTemplateSignature]
    = Json.format[OTIUMLA_extendedSignature_redefinableTemplateSignature]

  }

  /**
    * A_extendedStateMachine_stateMachine
    *
    * @param: end1 A_extendedStateMachine_stateMachine::stateMachine: StateMachine [0..*] { unordered, unique, reference }
    * @param: end2 StateMachine::extendedStateMachine: StateMachine [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_extendedStateMachine_stateMachine
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_extendedStateMachine_stateMachine {
     
    implicit def reads
    : Reads[OTIUMLA_extendedStateMachine_stateMachine]
    = Json.reads[OTIUMLA_extendedStateMachine_stateMachine]
  
    implicit def writes
    : Writes[OTIUMLA_extendedStateMachine_stateMachine]
    = Json.writes[OTIUMLA_extendedStateMachine_stateMachine]
  
    implicit def formats
    : Format[OTIUMLA_extendedStateMachine_stateMachine]
    = Json.format[OTIUMLA_extendedStateMachine_stateMachine]

  }

  /**
    * A_extensionLocation_extension
    *
    * @param: end1 A_extensionLocation_extension::extension: Extend [0..*] { unordered, unique, reference }
    * @param: end2 Extend::extensionLocation: ExtensionPoint [1..*] { ordered, unique, reference }
    */
  case class OTIUMLA_extensionLocation_extension
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFReferenceOrderedLink
  {}

  object OTIUMLA_extensionLocation_extension {
     
    implicit def reads
    : Reads[OTIUMLA_extensionLocation_extension]
    = Json.reads[OTIUMLA_extensionLocation_extension]
  
    implicit def writes
    : Writes[OTIUMLA_extensionLocation_extension]
    = Json.writes[OTIUMLA_extensionLocation_extension]
  
    implicit def formats
    : Format[OTIUMLA_extensionLocation_extension]
    = Json.format[OTIUMLA_extensionLocation_extension]

  }

  /**
    * A_generalizationSet_generalization
    *
    * @param: end1 Generalization::generalizationSet: GeneralizationSet [0..*] { unordered, unique, reference }
    * @param: end2 GeneralizationSet::generalization: Generalization [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_generalizationSet_generalization
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_generalizationSet_generalization {
     
    implicit def reads
    : Reads[OTIUMLA_generalizationSet_generalization]
    = Json.reads[OTIUMLA_generalizationSet_generalization]
  
    implicit def writes
    : Writes[OTIUMLA_generalizationSet_generalization]
    = Json.writes[OTIUMLA_generalizationSet_generalization]
  
    implicit def formats
    : Format[OTIUMLA_generalizationSet_generalization]
    = Json.format[OTIUMLA_generalizationSet_generalization]

  }

  /**
    * A_inInterruptibleRegion_node
    *
    * @param: end1 ActivityNode::inInterruptibleRegion: InterruptibleActivityRegion [0..*] { unordered, unique, reference }
    * @param: end2 InterruptibleActivityRegion::node: ActivityNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_inInterruptibleRegion_node
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_inInterruptibleRegion_node {
     
    implicit def reads
    : Reads[OTIUMLA_inInterruptibleRegion_node]
    = Json.reads[OTIUMLA_inInterruptibleRegion_node]
  
    implicit def writes
    : Writes[OTIUMLA_inInterruptibleRegion_node]
    = Json.writes[OTIUMLA_inInterruptibleRegion_node]
  
    implicit def formats
    : Format[OTIUMLA_inInterruptibleRegion_node]
    = Json.format[OTIUMLA_inInterruptibleRegion_node]

  }

  /**
    * A_inPartition_node
    *
    * @param: end1 ActivityNode::inPartition: ActivityPartition [0..*] { unordered, unique, reference }
    * @param: end2 ActivityPartition::node: ActivityNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_inPartition_node
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_inPartition_node {
     
    implicit def reads
    : Reads[OTIUMLA_inPartition_node]
    = Json.reads[OTIUMLA_inPartition_node]
  
    implicit def writes
    : Writes[OTIUMLA_inPartition_node]
    = Json.writes[OTIUMLA_inPartition_node]
  
    implicit def formats
    : Format[OTIUMLA_inPartition_node]
    = Json.format[OTIUMLA_inPartition_node]

  }

  /**
    * A_inState_objectNode
    *
    * @param: end1 A_inState_objectNode::objectNode: ObjectNode [0..*] { unordered, unique, reference }
    * @param: end2 ObjectNode::inState: State [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_inState_objectNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_inState_objectNode {
     
    implicit def reads
    : Reads[OTIUMLA_inState_objectNode]
    = Json.reads[OTIUMLA_inState_objectNode]
  
    implicit def writes
    : Writes[OTIUMLA_inState_objectNode]
    = Json.writes[OTIUMLA_inState_objectNode]
  
    implicit def formats
    : Format[OTIUMLA_inState_objectNode]
    = Json.format[OTIUMLA_inState_objectNode]

  }

  /**
    * A_incoming_target_node
    *
    * @param: end1 ActivityEdge::target: ActivityNode [1..1] { unordered, unique, reference }
    * @param: end2 ActivityNode::incoming: ActivityEdge [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_incoming_target_node
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_incoming_target_node {
     
    implicit def reads
    : Reads[OTIUMLA_incoming_target_node]
    = Json.reads[OTIUMLA_incoming_target_node]
  
    implicit def writes
    : Writes[OTIUMLA_incoming_target_node]
    = Json.writes[OTIUMLA_incoming_target_node]
  
    implicit def formats
    : Format[OTIUMLA_incoming_target_node]
    = Json.format[OTIUMLA_incoming_target_node]

  }

  /**
    * A_informationSource_informationFlow
    *
    * @param: end1 A_informationSource_informationFlow::informationFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param: end2 InformationFlow::informationSource: NamedElement [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_informationSource_informationFlow
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_informationSource_informationFlow {
     
    implicit def reads
    : Reads[OTIUMLA_informationSource_informationFlow]
    = Json.reads[OTIUMLA_informationSource_informationFlow]
  
    implicit def writes
    : Writes[OTIUMLA_informationSource_informationFlow]
    = Json.writes[OTIUMLA_informationSource_informationFlow]
  
    implicit def formats
    : Format[OTIUMLA_informationSource_informationFlow]
    = Json.format[OTIUMLA_informationSource_informationFlow]

  }

  /**
    * A_informationTarget_informationFlow
    *
    * @param: end1 A_informationTarget_informationFlow::informationFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param: end2 InformationFlow::informationTarget: NamedElement [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_informationTarget_informationFlow
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_informationTarget_informationFlow {
     
    implicit def reads
    : Reads[OTIUMLA_informationTarget_informationFlow]
    = Json.reads[OTIUMLA_informationTarget_informationFlow]
  
    implicit def writes
    : Writes[OTIUMLA_informationTarget_informationFlow]
    = Json.writes[OTIUMLA_informationTarget_informationFlow]
  
    implicit def formats
    : Format[OTIUMLA_informationTarget_informationFlow]
    = Json.format[OTIUMLA_informationTarget_informationFlow]

  }

  /**
    * A_inputElement_regionAsInput
    *
    * @param: end1 ExpansionNode::regionAsInput: ExpansionRegion [0..1] { unordered, unique, reference }
    * @param: end2 ExpansionRegion::inputElement: ExpansionNode [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_inputElement_regionAsInput
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_inputElement_regionAsInput {
     
    implicit def reads
    : Reads[OTIUMLA_inputElement_regionAsInput]
    = Json.reads[OTIUMLA_inputElement_regionAsInput]
  
    implicit def writes
    : Writes[OTIUMLA_inputElement_regionAsInput]
    = Json.writes[OTIUMLA_inputElement_regionAsInput]
  
    implicit def formats
    : Format[OTIUMLA_inputElement_regionAsInput]
    = Json.format[OTIUMLA_inputElement_regionAsInput]

  }

  /**
    * A_insertAt_linkEndCreationData
    *
    * @param: end1 A_insertAt_linkEndCreationData::linkEndCreationData: LinkEndCreationData [0..1] { unordered, unique, reference }
    * @param: end2 LinkEndCreationData::insertAt: InputPin [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_insertAt_linkEndCreationData
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_insertAt_linkEndCreationData {
     
    implicit def reads
    : Reads[OTIUMLA_insertAt_linkEndCreationData]
    = Json.reads[OTIUMLA_insertAt_linkEndCreationData]
  
    implicit def writes
    : Writes[OTIUMLA_insertAt_linkEndCreationData]
    = Json.writes[OTIUMLA_insertAt_linkEndCreationData]
  
    implicit def formats
    : Format[OTIUMLA_insertAt_linkEndCreationData]
    = Json.format[OTIUMLA_insertAt_linkEndCreationData]

  }

  /**
    * A_interruptingEdge_interrupts
    *
    * @param: end1 ActivityEdge::interrupts: InterruptibleActivityRegion [0..1] { unordered, unique, reference }
    * @param: end2 InterruptibleActivityRegion::interruptingEdge: ActivityEdge [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_interruptingEdge_interrupts
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_interruptingEdge_interrupts {
     
    implicit def reads
    : Reads[OTIUMLA_interruptingEdge_interrupts]
    = Json.reads[OTIUMLA_interruptingEdge_interrupts]
  
    implicit def writes
    : Writes[OTIUMLA_interruptingEdge_interrupts]
    = Json.writes[OTIUMLA_interruptingEdge_interrupts]
  
    implicit def formats
    : Format[OTIUMLA_interruptingEdge_interrupts]
    = Json.format[OTIUMLA_interruptingEdge_interrupts]

  }

  /**
    * A_memberEnd_association
    *
    * @param: end1 Property::association: Association [0..1] { unordered, unique, reference }
    * @param: end2 Association::memberEnd: Property [2..*] { ordered, unique, reference }
    */
  case class OTIUMLA_memberEnd_association
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFReferenceOrderedLink
  {}

  object OTIUMLA_memberEnd_association {
     
    implicit def reads
    : Reads[OTIUMLA_memberEnd_association]
    = Json.reads[OTIUMLA_memberEnd_association]
  
    implicit def writes
    : Writes[OTIUMLA_memberEnd_association]
    = Json.writes[OTIUMLA_memberEnd_association]
  
    implicit def formats
    : Format[OTIUMLA_memberEnd_association]
    = Json.format[OTIUMLA_memberEnd_association]

  }

  /**
    * A_message_considerIgnoreFragment
    *
    * @param: end1 A_message_considerIgnoreFragment::considerIgnoreFragment: ConsiderIgnoreFragment [0..*] { unordered, unique, reference }
    * @param: end2 ConsiderIgnoreFragment::message: NamedElement [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_message_considerIgnoreFragment
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_message_considerIgnoreFragment {
     
    implicit def reads
    : Reads[OTIUMLA_message_considerIgnoreFragment]
    = Json.reads[OTIUMLA_message_considerIgnoreFragment]
  
    implicit def writes
    : Writes[OTIUMLA_message_considerIgnoreFragment]
    = Json.writes[OTIUMLA_message_considerIgnoreFragment]
  
    implicit def formats
    : Format[OTIUMLA_message_considerIgnoreFragment]
    = Json.format[OTIUMLA_message_considerIgnoreFragment]

  }

  /**
    * A_message_messageEnd
    *
    * @param: end1 A_message_messageEnd::messageEnd: MessageEnd [0..2] { unordered, unique, reference }
    * @param: end2 MessageEnd::message: Message [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_message_messageEnd
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_message_messageEnd {
     
    implicit def reads
    : Reads[OTIUMLA_message_messageEnd]
    = Json.reads[OTIUMLA_message_messageEnd]
  
    implicit def writes
    : Writes[OTIUMLA_message_messageEnd]
    = Json.writes[OTIUMLA_message_messageEnd]
  
    implicit def formats
    : Format[OTIUMLA_message_messageEnd]
    = Json.format[OTIUMLA_message_messageEnd]

  }

  /**
    * A_method_specification
    *
    * @param: end1 Behavior::specification: BehavioralFeature [0..1] { unordered, unique, reference }
    * @param: end2 BehavioralFeature::method: Behavior [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_method_specification
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_method_specification {
     
    implicit def reads
    : Reads[OTIUMLA_method_specification]
    = Json.reads[OTIUMLA_method_specification]
  
    implicit def writes
    : Writes[OTIUMLA_method_specification]
    = Json.writes[OTIUMLA_method_specification]
  
    implicit def formats
    : Format[OTIUMLA_method_specification]
    = Json.format[OTIUMLA_method_specification]

  }

  /**
    * A_navigableOwnedEnd_association
    *
    * @param: end1 A_navigableOwnedEnd_association::association: Association [0..1] { unordered, unique, reference }
    * @param: end2 Association::navigableOwnedEnd: Property [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_navigableOwnedEnd_association
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_navigableOwnedEnd_association {
     
    implicit def reads
    : Reads[OTIUMLA_navigableOwnedEnd_association]
    = Json.reads[OTIUMLA_navigableOwnedEnd_association]
  
    implicit def writes
    : Writes[OTIUMLA_navigableOwnedEnd_association]
    = Json.writes[OTIUMLA_navigableOwnedEnd_association]
  
    implicit def formats
    : Format[OTIUMLA_navigableOwnedEnd_association]
    = Json.format[OTIUMLA_navigableOwnedEnd_association]

  }

  /**
    * A_newClassifier_reclassifyObjectAction
    *
    * @param: end1 A_newClassifier_reclassifyObjectAction::reclassifyObjectAction: ReclassifyObjectAction [0..*] { unordered, unique, reference }
    * @param: end2 ReclassifyObjectAction::newClassifier: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_newClassifier_reclassifyObjectAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_newClassifier_reclassifyObjectAction {
     
    implicit def reads
    : Reads[OTIUMLA_newClassifier_reclassifyObjectAction]
    = Json.reads[OTIUMLA_newClassifier_reclassifyObjectAction]
  
    implicit def writes
    : Writes[OTIUMLA_newClassifier_reclassifyObjectAction]
    = Json.writes[OTIUMLA_newClassifier_reclassifyObjectAction]
  
    implicit def formats
    : Format[OTIUMLA_newClassifier_reclassifyObjectAction]
    = Json.format[OTIUMLA_newClassifier_reclassifyObjectAction]

  }

  /**
    * A_observation_duration
    *
    * @param: end1 A_observation_duration::duration: Duration [0..1] { unordered, unique, reference }
    * @param: end2 Duration::observation: Observation [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_observation_duration
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_observation_duration {
     
    implicit def reads
    : Reads[OTIUMLA_observation_duration]
    = Json.reads[OTIUMLA_observation_duration]
  
    implicit def writes
    : Writes[OTIUMLA_observation_duration]
    = Json.writes[OTIUMLA_observation_duration]
  
    implicit def formats
    : Format[OTIUMLA_observation_duration]
    = Json.format[OTIUMLA_observation_duration]

  }

  /**
    * A_observation_timeExpression
    *
    * @param: end1 A_observation_timeExpression::timeExpression: TimeExpression [0..1] { unordered, unique, reference }
    * @param: end2 TimeExpression::observation: Observation [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_observation_timeExpression
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_observation_timeExpression {
     
    implicit def reads
    : Reads[OTIUMLA_observation_timeExpression]
    = Json.reads[OTIUMLA_observation_timeExpression]
  
    implicit def writes
    : Writes[OTIUMLA_observation_timeExpression]
    = Json.writes[OTIUMLA_observation_timeExpression]
  
    implicit def formats
    : Format[OTIUMLA_observation_timeExpression]
    = Json.format[OTIUMLA_observation_timeExpression]

  }

  /**
    * A_oldClassifier_reclassifyObjectAction
    *
    * @param: end1 A_oldClassifier_reclassifyObjectAction::reclassifyObjectAction: ReclassifyObjectAction [0..*] { unordered, unique, reference }
    * @param: end2 ReclassifyObjectAction::oldClassifier: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_oldClassifier_reclassifyObjectAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_oldClassifier_reclassifyObjectAction {
     
    implicit def reads
    : Reads[OTIUMLA_oldClassifier_reclassifyObjectAction]
    = Json.reads[OTIUMLA_oldClassifier_reclassifyObjectAction]
  
    implicit def writes
    : Writes[OTIUMLA_oldClassifier_reclassifyObjectAction]
    = Json.writes[OTIUMLA_oldClassifier_reclassifyObjectAction]
  
    implicit def formats
    : Format[OTIUMLA_oldClassifier_reclassifyObjectAction]
    = Json.format[OTIUMLA_oldClassifier_reclassifyObjectAction]

  }

  /**
    * A_operation_templateParameter_parameteredElement
    *
    * @param: end1 OperationTemplateParameter::parameteredElement: Operation [1..1] { unordered, unique, reference }
    * @param: end2 Operation::templateParameter: OperationTemplateParameter [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_operation_templateParameter_parameteredElement
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_operation_templateParameter_parameteredElement {
     
    implicit def reads
    : Reads[OTIUMLA_operation_templateParameter_parameteredElement]
    = Json.reads[OTIUMLA_operation_templateParameter_parameteredElement]
  
    implicit def writes
    : Writes[OTIUMLA_operation_templateParameter_parameteredElement]
    = Json.writes[OTIUMLA_operation_templateParameter_parameteredElement]
  
    implicit def formats
    : Format[OTIUMLA_operation_templateParameter_parameteredElement]
    = Json.format[OTIUMLA_operation_templateParameter_parameteredElement]

  }

  /**
    * A_outgoing_source_node
    *
    * @param: end1 ActivityEdge::source: ActivityNode [1..1] { unordered, unique, reference }
    * @param: end2 ActivityNode::outgoing: ActivityEdge [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_outgoing_source_node
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_outgoing_source_node {
     
    implicit def reads
    : Reads[OTIUMLA_outgoing_source_node]
    = Json.reads[OTIUMLA_outgoing_source_node]
  
    implicit def writes
    : Writes[OTIUMLA_outgoing_source_node]
    = Json.writes[OTIUMLA_outgoing_source_node]
  
    implicit def formats
    : Format[OTIUMLA_outgoing_source_node]
    = Json.format[OTIUMLA_outgoing_source_node]

  }

  /**
    * A_outputElement_regionAsOutput
    *
    * @param: end1 ExpansionNode::regionAsOutput: ExpansionRegion [0..1] { unordered, unique, reference }
    * @param: end2 ExpansionRegion::outputElement: ExpansionNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_outputElement_regionAsOutput
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_outputElement_regionAsOutput {
     
    implicit def reads
    : Reads[OTIUMLA_outputElement_regionAsOutput]
    = Json.reads[OTIUMLA_outputElement_regionAsOutput]
  
    implicit def writes
    : Writes[OTIUMLA_outputElement_regionAsOutput]
    = Json.writes[OTIUMLA_outputElement_regionAsOutput]
  
    implicit def formats
    : Format[OTIUMLA_outputElement_regionAsOutput]
    = Json.format[OTIUMLA_outputElement_regionAsOutput]

  }

  /**
    * A_parameterSet_parameter
    *
    * @param: end1 ParameterSet::parameter: Parameter [1..*] { unordered, unique, reference }
    * @param: end2 Parameter::parameterSet: ParameterSet [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_parameterSet_parameter
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_parameterSet_parameter {
     
    implicit def reads
    : Reads[OTIUMLA_parameterSet_parameter]
    = Json.reads[OTIUMLA_parameterSet_parameter]
  
    implicit def writes
    : Writes[OTIUMLA_parameterSet_parameter]
    = Json.writes[OTIUMLA_parameterSet_parameter]
  
    implicit def formats
    : Format[OTIUMLA_parameterSet_parameter]
    = Json.format[OTIUMLA_parameterSet_parameter]

  }

  /**
    * A_parameter_templateSignature
    *
    * @param: end1 A_parameter_templateSignature::templateSignature: TemplateSignature [0..*] { unordered, unique, reference }
    * @param: end2 TemplateSignature::parameter: TemplateParameter [1..*] { ordered, unique, reference }
    */
  case class OTIUMLA_parameter_templateSignature
  ( override val end1: ElementLocation,
    override val end2: ElementLocation,
    override val end2Index: Int )
  extends  OTIMOFReferenceOrderedLink
  {}

  object OTIUMLA_parameter_templateSignature {
     
    implicit def reads
    : Reads[OTIUMLA_parameter_templateSignature]
    = Json.reads[OTIUMLA_parameter_templateSignature]
  
    implicit def writes
    : Writes[OTIUMLA_parameter_templateSignature]
    = Json.writes[OTIUMLA_parameter_templateSignature]
  
    implicit def formats
    : Format[OTIUMLA_parameter_templateSignature]
    = Json.format[OTIUMLA_parameter_templateSignature]

  }

  /**
    * A_parameteredElement_templateParameter
    *
    * @param: end1 TemplateParameter::parameteredElement: ParameterableElement [1..1] { unordered, unique, reference }
    * @param: end2 ParameterableElement::templateParameter: TemplateParameter [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_parameteredElement_templateParameter
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_parameteredElement_templateParameter {
     
    implicit def reads
    : Reads[OTIUMLA_parameteredElement_templateParameter]
    = Json.reads[OTIUMLA_parameteredElement_templateParameter]
  
    implicit def writes
    : Writes[OTIUMLA_parameteredElement_templateParameter]
    = Json.writes[OTIUMLA_parameteredElement_templateParameter]
  
    implicit def formats
    : Format[OTIUMLA_parameteredElement_templateParameter]
    = Json.format[OTIUMLA_parameteredElement_templateParameter]

  }

  /**
    * A_partition_activity
    *
    * @param: end1 A_partition_activity::activity: Activity [0..1] { unordered, unique, reference }
    * @param: end2 Activity::partition: ActivityPartition [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_partition_activity
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_partition_activity {
     
    implicit def reads
    : Reads[OTIUMLA_partition_activity]
    = Json.reads[OTIUMLA_partition_activity]
  
    implicit def writes
    : Writes[OTIUMLA_partition_activity]
    = Json.writes[OTIUMLA_partition_activity]
  
    implicit def formats
    : Format[OTIUMLA_partition_activity]
    = Json.format[OTIUMLA_partition_activity]

  }

  /**
    * A_port_trigger
    *
    * @param: end1 A_port_trigger::trigger: Trigger [0..*] { unordered, unique, reference }
    * @param: end2 Trigger::port: Port [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_port_trigger
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_port_trigger {
     
    implicit def reads
    : Reads[OTIUMLA_port_trigger]
    = Json.reads[OTIUMLA_port_trigger]
  
    implicit def writes
    : Writes[OTIUMLA_port_trigger]
    = Json.writes[OTIUMLA_port_trigger]
  
    implicit def formats
    : Format[OTIUMLA_port_trigger]
    = Json.format[OTIUMLA_port_trigger]

  }

  /**
    * A_powertypeExtent_powertype
    *
    * @param: end1 GeneralizationSet::powertype: Classifier [0..1] { unordered, unique, reference }
    * @param: end2 Classifier::powertypeExtent: GeneralizationSet [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_powertypeExtent_powertype
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_powertypeExtent_powertype {
     
    implicit def reads
    : Reads[OTIUMLA_powertypeExtent_powertype]
    = Json.reads[OTIUMLA_powertypeExtent_powertype]
  
    implicit def writes
    : Writes[OTIUMLA_powertypeExtent_powertype]
    = Json.writes[OTIUMLA_powertypeExtent_powertype]
  
    implicit def formats
    : Format[OTIUMLA_powertypeExtent_powertype]
    = Json.format[OTIUMLA_powertypeExtent_powertype]

  }

  /**
    * A_predecessorClause_successorClause
    *
    * @param: end1 Clause::successorClause: Clause [0..*] { unordered, unique, reference }
    * @param: end2 Clause::predecessorClause: Clause [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_predecessorClause_successorClause
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_predecessorClause_successorClause {
     
    implicit def reads
    : Reads[OTIUMLA_predecessorClause_successorClause]
    = Json.reads[OTIUMLA_predecessorClause_successorClause]
  
    implicit def writes
    : Writes[OTIUMLA_predecessorClause_successorClause]
    = Json.writes[OTIUMLA_predecessorClause_successorClause]
  
    implicit def formats
    : Format[OTIUMLA_predecessorClause_successorClause]
    = Json.format[OTIUMLA_predecessorClause_successorClause]

  }

  /**
    * A_qualifier_readLinkObjectEndQualifierAction
    *
    * @param: end1 A_qualifier_readLinkObjectEndQualifierAction::readLinkObjectEndQualifierAction: ReadLinkObjectEndQualifierAction [0..1] { unordered, unique, reference }
    * @param: end2 ReadLinkObjectEndQualifierAction::qualifier: Property [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_qualifier_readLinkObjectEndQualifierAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_qualifier_readLinkObjectEndQualifierAction {
     
    implicit def reads
    : Reads[OTIUMLA_qualifier_readLinkObjectEndQualifierAction]
    = Json.reads[OTIUMLA_qualifier_readLinkObjectEndQualifierAction]
  
    implicit def writes
    : Writes[OTIUMLA_qualifier_readLinkObjectEndQualifierAction]
    = Json.writes[OTIUMLA_qualifier_readLinkObjectEndQualifierAction]
  
    implicit def formats
    : Format[OTIUMLA_qualifier_readLinkObjectEndQualifierAction]
    = Json.format[OTIUMLA_qualifier_readLinkObjectEndQualifierAction]

  }

  /**
    * A_raisedException_behavioralFeature
    *
    * @param: end1 A_raisedException_behavioralFeature::behavioralFeature: BehavioralFeature [0..*] { unordered, unique, reference }
    * @param: end2 BehavioralFeature::raisedException: Type [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_raisedException_behavioralFeature
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_raisedException_behavioralFeature {
     
    implicit def reads
    : Reads[OTIUMLA_raisedException_behavioralFeature]
    = Json.reads[OTIUMLA_raisedException_behavioralFeature]
  
    implicit def writes
    : Writes[OTIUMLA_raisedException_behavioralFeature]
    = Json.writes[OTIUMLA_raisedException_behavioralFeature]
  
    implicit def formats
    : Format[OTIUMLA_raisedException_behavioralFeature]
    = Json.format[OTIUMLA_raisedException_behavioralFeature]

  }

  /**
    * A_raisedException_operation
    *
    * @param: end1 A_raisedException_operation::operation: Operation [0..*] { unordered, unique, reference }
    * @param: end2 Operation::raisedException: Type [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_raisedException_operation
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_raisedException_operation {
     
    implicit def reads
    : Reads[OTIUMLA_raisedException_operation]
    = Json.reads[OTIUMLA_raisedException_operation]
  
    implicit def writes
    : Writes[OTIUMLA_raisedException_operation]
    = Json.writes[OTIUMLA_raisedException_operation]
  
    implicit def formats
    : Format[OTIUMLA_raisedException_operation]
    = Json.format[OTIUMLA_raisedException_operation]

  }

  /**
    * A_realization_abstraction_flow
    *
    * @param: end1 A_realization_abstraction_flow::abstraction: InformationFlow [0..*] { unordered, unique, reference }
    * @param: end2 InformationFlow::realization: Relationship [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_realization_abstraction_flow
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_realization_abstraction_flow {
     
    implicit def reads
    : Reads[OTIUMLA_realization_abstraction_flow]
    = Json.reads[OTIUMLA_realization_abstraction_flow]
  
    implicit def writes
    : Writes[OTIUMLA_realization_abstraction_flow]
    = Json.writes[OTIUMLA_realization_abstraction_flow]
  
    implicit def formats
    : Format[OTIUMLA_realization_abstraction_flow]
    = Json.format[OTIUMLA_realization_abstraction_flow]

  }

  /**
    * A_realizingActivityEdge_informationFlow
    *
    * @param: end1 A_realizingActivityEdge_informationFlow::informationFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param: end2 InformationFlow::realizingActivityEdge: ActivityEdge [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_realizingActivityEdge_informationFlow
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_realizingActivityEdge_informationFlow {
     
    implicit def reads
    : Reads[OTIUMLA_realizingActivityEdge_informationFlow]
    = Json.reads[OTIUMLA_realizingActivityEdge_informationFlow]
  
    implicit def writes
    : Writes[OTIUMLA_realizingActivityEdge_informationFlow]
    = Json.writes[OTIUMLA_realizingActivityEdge_informationFlow]
  
    implicit def formats
    : Format[OTIUMLA_realizingActivityEdge_informationFlow]
    = Json.format[OTIUMLA_realizingActivityEdge_informationFlow]

  }

  /**
    * A_realizingClassifier_componentRealization
    *
    * @param: end1 A_realizingClassifier_componentRealization::componentRealization: ComponentRealization [0..*] { unordered, unique, reference }
    * @param: end2 ComponentRealization::realizingClassifier: Classifier [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_realizingClassifier_componentRealization
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_realizingClassifier_componentRealization {
     
    implicit def reads
    : Reads[OTIUMLA_realizingClassifier_componentRealization]
    = Json.reads[OTIUMLA_realizingClassifier_componentRealization]
  
    implicit def writes
    : Writes[OTIUMLA_realizingClassifier_componentRealization]
    = Json.writes[OTIUMLA_realizingClassifier_componentRealization]
  
    implicit def formats
    : Format[OTIUMLA_realizingClassifier_componentRealization]
    = Json.format[OTIUMLA_realizingClassifier_componentRealization]

  }

  /**
    * A_realizingConnector_informationFlow
    *
    * @param: end1 A_realizingConnector_informationFlow::informationFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param: end2 InformationFlow::realizingConnector: Connector [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_realizingConnector_informationFlow
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_realizingConnector_informationFlow {
     
    implicit def reads
    : Reads[OTIUMLA_realizingConnector_informationFlow]
    = Json.reads[OTIUMLA_realizingConnector_informationFlow]
  
    implicit def writes
    : Writes[OTIUMLA_realizingConnector_informationFlow]
    = Json.writes[OTIUMLA_realizingConnector_informationFlow]
  
    implicit def formats
    : Format[OTIUMLA_realizingConnector_informationFlow]
    = Json.format[OTIUMLA_realizingConnector_informationFlow]

  }

  /**
    * A_realizingMessage_informationFlow
    *
    * @param: end1 A_realizingMessage_informationFlow::informationFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param: end2 InformationFlow::realizingMessage: Message [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_realizingMessage_informationFlow
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_realizingMessage_informationFlow {
     
    implicit def reads
    : Reads[OTIUMLA_realizingMessage_informationFlow]
    = Json.reads[OTIUMLA_realizingMessage_informationFlow]
  
    implicit def writes
    : Writes[OTIUMLA_realizingMessage_informationFlow]
    = Json.writes[OTIUMLA_realizingMessage_informationFlow]
  
    implicit def formats
    : Format[OTIUMLA_realizingMessage_informationFlow]
    = Json.format[OTIUMLA_realizingMessage_informationFlow]

  }

  /**
    * A_receiveEvent_endMessage
    *
    * @param: end1 A_receiveEvent_endMessage::endMessage: Message [0..1] { unordered, unique, reference }
    * @param: end2 Message::receiveEvent: MessageEnd [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_receiveEvent_endMessage
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_receiveEvent_endMessage {
     
    implicit def reads
    : Reads[OTIUMLA_receiveEvent_endMessage]
    = Json.reads[OTIUMLA_receiveEvent_endMessage]
  
    implicit def writes
    : Writes[OTIUMLA_receiveEvent_endMessage]
    = Json.writes[OTIUMLA_receiveEvent_endMessage]
  
    implicit def formats
    : Format[OTIUMLA_receiveEvent_endMessage]
    = Json.format[OTIUMLA_receiveEvent_endMessage]

  }

  /**
    * A_redefinedBehavior_behavior
    *
    * @param: end1 A_redefinedBehavior_behavior::behavior: Behavior [0..*] { unordered, unique, reference }
    * @param: end2 Behavior::redefinedBehavior: Behavior [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedBehavior_behavior
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_redefinedBehavior_behavior {
     
    implicit def reads
    : Reads[OTIUMLA_redefinedBehavior_behavior]
    = Json.reads[OTIUMLA_redefinedBehavior_behavior]
  
    implicit def writes
    : Writes[OTIUMLA_redefinedBehavior_behavior]
    = Json.writes[OTIUMLA_redefinedBehavior_behavior]
  
    implicit def formats
    : Format[OTIUMLA_redefinedBehavior_behavior]
    = Json.format[OTIUMLA_redefinedBehavior_behavior]

  }

  /**
    * A_redefinedClassifier_classifier
    *
    * @param: end1 A_redefinedClassifier_classifier::classifier: Classifier [0..*] { unordered, unique, reference }
    * @param: end2 Classifier::redefinedClassifier: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedClassifier_classifier
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_redefinedClassifier_classifier {
     
    implicit def reads
    : Reads[OTIUMLA_redefinedClassifier_classifier]
    = Json.reads[OTIUMLA_redefinedClassifier_classifier]
  
    implicit def writes
    : Writes[OTIUMLA_redefinedClassifier_classifier]
    = Json.writes[OTIUMLA_redefinedClassifier_classifier]
  
    implicit def formats
    : Format[OTIUMLA_redefinedClassifier_classifier]
    = Json.format[OTIUMLA_redefinedClassifier_classifier]

  }

  /**
    * A_redefinedConnector_connector
    *
    * @param: end1 A_redefinedConnector_connector::connector: Connector [0..*] { unordered, unique, reference }
    * @param: end2 Connector::redefinedConnector: Connector [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedConnector_connector
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_redefinedConnector_connector {
     
    implicit def reads
    : Reads[OTIUMLA_redefinedConnector_connector]
    = Json.reads[OTIUMLA_redefinedConnector_connector]
  
    implicit def writes
    : Writes[OTIUMLA_redefinedConnector_connector]
    = Json.writes[OTIUMLA_redefinedConnector_connector]
  
    implicit def formats
    : Format[OTIUMLA_redefinedConnector_connector]
    = Json.format[OTIUMLA_redefinedConnector_connector]

  }

  /**
    * A_redefinedEdge_activityEdge
    *
    * @param: end1 A_redefinedEdge_activityEdge::activityEdge: ActivityEdge [0..*] { unordered, unique, reference }
    * @param: end2 ActivityEdge::redefinedEdge: ActivityEdge [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedEdge_activityEdge
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_redefinedEdge_activityEdge {
     
    implicit def reads
    : Reads[OTIUMLA_redefinedEdge_activityEdge]
    = Json.reads[OTIUMLA_redefinedEdge_activityEdge]
  
    implicit def writes
    : Writes[OTIUMLA_redefinedEdge_activityEdge]
    = Json.writes[OTIUMLA_redefinedEdge_activityEdge]
  
    implicit def formats
    : Format[OTIUMLA_redefinedEdge_activityEdge]
    = Json.format[OTIUMLA_redefinedEdge_activityEdge]

  }

  /**
    * A_redefinedInterface_interface
    *
    * @param: end1 A_redefinedInterface_interface::interface: Interface [0..*] { unordered, unique, reference }
    * @param: end2 Interface::redefinedInterface: Interface [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedInterface_interface
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_redefinedInterface_interface {
     
    implicit def reads
    : Reads[OTIUMLA_redefinedInterface_interface]
    = Json.reads[OTIUMLA_redefinedInterface_interface]
  
    implicit def writes
    : Writes[OTIUMLA_redefinedInterface_interface]
    = Json.writes[OTIUMLA_redefinedInterface_interface]
  
    implicit def formats
    : Format[OTIUMLA_redefinedInterface_interface]
    = Json.format[OTIUMLA_redefinedInterface_interface]

  }

  /**
    * A_redefinedNode_activityNode
    *
    * @param: end1 A_redefinedNode_activityNode::activityNode: ActivityNode [0..*] { unordered, unique, reference }
    * @param: end2 ActivityNode::redefinedNode: ActivityNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedNode_activityNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_redefinedNode_activityNode {
     
    implicit def reads
    : Reads[OTIUMLA_redefinedNode_activityNode]
    = Json.reads[OTIUMLA_redefinedNode_activityNode]
  
    implicit def writes
    : Writes[OTIUMLA_redefinedNode_activityNode]
    = Json.writes[OTIUMLA_redefinedNode_activityNode]
  
    implicit def formats
    : Format[OTIUMLA_redefinedNode_activityNode]
    = Json.format[OTIUMLA_redefinedNode_activityNode]

  }

  /**
    * A_redefinedOperation_operation
    *
    * @param: end1 A_redefinedOperation_operation::operation: Operation [0..*] { unordered, unique, reference }
    * @param: end2 Operation::redefinedOperation: Operation [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedOperation_operation
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_redefinedOperation_operation {
     
    implicit def reads
    : Reads[OTIUMLA_redefinedOperation_operation]
    = Json.reads[OTIUMLA_redefinedOperation_operation]
  
    implicit def writes
    : Writes[OTIUMLA_redefinedOperation_operation]
    = Json.writes[OTIUMLA_redefinedOperation_operation]
  
    implicit def formats
    : Format[OTIUMLA_redefinedOperation_operation]
    = Json.format[OTIUMLA_redefinedOperation_operation]

  }

  /**
    * A_redefinedPort_port
    *
    * @param: end1 A_redefinedPort_port::port: Port [0..*] { unordered, unique, reference }
    * @param: end2 Port::redefinedPort: Port [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedPort_port
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_redefinedPort_port {
     
    implicit def reads
    : Reads[OTIUMLA_redefinedPort_port]
    = Json.reads[OTIUMLA_redefinedPort_port]
  
    implicit def writes
    : Writes[OTIUMLA_redefinedPort_port]
    = Json.writes[OTIUMLA_redefinedPort_port]
  
    implicit def formats
    : Format[OTIUMLA_redefinedPort_port]
    = Json.format[OTIUMLA_redefinedPort_port]

  }

  /**
    * A_redefinedProperty_property
    *
    * @param: end1 A_redefinedProperty_property::property: Property [0..*] { unordered, unique, reference }
    * @param: end2 Property::redefinedProperty: Property [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedProperty_property
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_redefinedProperty_property {
     
    implicit def reads
    : Reads[OTIUMLA_redefinedProperty_property]
    = Json.reads[OTIUMLA_redefinedProperty_property]
  
    implicit def writes
    : Writes[OTIUMLA_redefinedProperty_property]
    = Json.writes[OTIUMLA_redefinedProperty_property]
  
    implicit def formats
    : Format[OTIUMLA_redefinedProperty_property]
    = Json.format[OTIUMLA_redefinedProperty_property]

  }

  /**
    * A_replyToCall_replyAction
    *
    * @param: end1 A_replyToCall_replyAction::replyAction: ReplyAction [0..1] { unordered, unique, reference }
    * @param: end2 ReplyAction::replyToCall: Trigger [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_replyToCall_replyAction
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_replyToCall_replyAction {
     
    implicit def reads
    : Reads[OTIUMLA_replyToCall_replyAction]
    = Json.reads[OTIUMLA_replyToCall_replyAction]
  
    implicit def writes
    : Writes[OTIUMLA_replyToCall_replyAction]
    = Json.writes[OTIUMLA_replyToCall_replyAction]
  
    implicit def formats
    : Format[OTIUMLA_replyToCall_replyAction]
    = Json.format[OTIUMLA_replyToCall_replyAction]

  }

  /**
    * A_representation_classifier
    *
    * @param: end1 A_representation_classifier::classifier: Classifier [0..1] { unordered, unique, reference }
    * @param: end2 Classifier::representation: CollaborationUse [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_representation_classifier
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_representation_classifier {
     
    implicit def reads
    : Reads[OTIUMLA_representation_classifier]
    = Json.reads[OTIUMLA_representation_classifier]
  
    implicit def writes
    : Writes[OTIUMLA_representation_classifier]
    = Json.writes[OTIUMLA_representation_classifier]
  
    implicit def formats
    : Format[OTIUMLA_representation_classifier]
    = Json.format[OTIUMLA_representation_classifier]

  }

  /**
    * A_represented_representation
    *
    * @param: end1 A_represented_representation::representation: InformationItem [0..*] { unordered, unique, reference }
    * @param: end2 InformationItem::represented: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_represented_representation
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_represented_representation {
     
    implicit def reads
    : Reads[OTIUMLA_represented_representation]
    = Json.reads[OTIUMLA_represented_representation]
  
    implicit def writes
    : Writes[OTIUMLA_represented_representation]
    = Json.writes[OTIUMLA_represented_representation]
  
    implicit def formats
    : Format[OTIUMLA_represented_representation]
    = Json.format[OTIUMLA_represented_representation]

  }

  /**
    * A_sendEvent_endMessage
    *
    * @param: end1 A_sendEvent_endMessage::endMessage: Message [0..1] { unordered, unique, reference }
    * @param: end2 Message::sendEvent: MessageEnd [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_sendEvent_endMessage
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_sendEvent_endMessage {
     
    implicit def reads
    : Reads[OTIUMLA_sendEvent_endMessage]
    = Json.reads[OTIUMLA_sendEvent_endMessage]
  
    implicit def writes
    : Writes[OTIUMLA_sendEvent_endMessage]
    = Json.writes[OTIUMLA_sendEvent_endMessage]
  
    implicit def formats
    : Format[OTIUMLA_sendEvent_endMessage]
    = Json.format[OTIUMLA_sendEvent_endMessage]

  }

  /**
    * A_setupPart_loopNode
    *
    * @param: end1 A_setupPart_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param: end2 LoopNode::setupPart: ExecutableNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_setupPart_loopNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_setupPart_loopNode {
     
    implicit def reads
    : Reads[OTIUMLA_setupPart_loopNode]
    = Json.reads[OTIUMLA_setupPart_loopNode]
  
    implicit def writes
    : Writes[OTIUMLA_setupPart_loopNode]
    = Json.writes[OTIUMLA_setupPart_loopNode]
  
    implicit def formats
    : Format[OTIUMLA_setupPart_loopNode]
    = Json.format[OTIUMLA_setupPart_loopNode]

  }

  /**
    * A_subject_useCase
    *
    * @param: end1 Classifier::useCase: UseCase [0..*] { unordered, unique, reference }
    * @param: end2 UseCase::subject: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_subject_useCase
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_subject_useCase {
     
    implicit def reads
    : Reads[OTIUMLA_subject_useCase]
    = Json.reads[OTIUMLA_subject_useCase]
  
    implicit def writes
    : Writes[OTIUMLA_subject_useCase]
    = Json.writes[OTIUMLA_subject_useCase]
  
    implicit def formats
    : Format[OTIUMLA_subject_useCase]
    = Json.format[OTIUMLA_subject_useCase]

  }

  /**
    * A_submachineState_submachine
    *
    * @param: end1 State::submachine: StateMachine [0..1] { unordered, unique, reference }
    * @param: end2 StateMachine::submachineState: State [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_submachineState_submachine
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_submachineState_submachine {
     
    implicit def reads
    : Reads[OTIUMLA_submachineState_submachine]
    = Json.reads[OTIUMLA_submachineState_submachine]
  
    implicit def writes
    : Writes[OTIUMLA_submachineState_submachine]
    = Json.writes[OTIUMLA_submachineState_submachine]
  
    implicit def formats
    : Format[OTIUMLA_submachineState_submachine]
    = Json.format[OTIUMLA_submachineState_submachine]

  }

  /**
    * A_subsettedProperty_property
    *
    * @param: end1 A_subsettedProperty_property::property: Property [0..*] { unordered, unique, reference }
    * @param: end2 Property::subsettedProperty: Property [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_subsettedProperty_property
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_subsettedProperty_property {
     
    implicit def reads
    : Reads[OTIUMLA_subsettedProperty_property]
    = Json.reads[OTIUMLA_subsettedProperty_property]
  
    implicit def writes
    : Writes[OTIUMLA_subsettedProperty_property]
    = Json.writes[OTIUMLA_subsettedProperty_property]
  
    implicit def formats
    : Format[OTIUMLA_subsettedProperty_property]
    = Json.format[OTIUMLA_subsettedProperty_property]

  }

  /**
    * A_supplier_supplierDependency
    *
    * @param: end1 A_supplier_supplierDependency::supplierDependency: Dependency [0..*] { unordered, unique, reference }
    * @param: end2 Dependency::supplier: NamedElement [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_supplier_supplierDependency
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_supplier_supplierDependency {
     
    implicit def reads
    : Reads[OTIUMLA_supplier_supplierDependency]
    = Json.reads[OTIUMLA_supplier_supplierDependency]
  
    implicit def writes
    : Writes[OTIUMLA_supplier_supplierDependency]
    = Json.writes[OTIUMLA_supplier_supplierDependency]
  
    implicit def formats
    : Format[OTIUMLA_supplier_supplierDependency]
    = Json.format[OTIUMLA_supplier_supplierDependency]

  }

  /**
    * A_test_clause
    *
    * @param: end1 A_test_clause::clause: Clause [0..1] { unordered, unique, reference }
    * @param: end2 Clause::test: ExecutableNode [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_test_clause
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_test_clause {
     
    implicit def reads
    : Reads[OTIUMLA_test_clause]
    = Json.reads[OTIUMLA_test_clause]
  
    implicit def writes
    : Writes[OTIUMLA_test_clause]
    = Json.writes[OTIUMLA_test_clause]
  
    implicit def formats
    : Format[OTIUMLA_test_clause]
    = Json.format[OTIUMLA_test_clause]

  }

  /**
    * A_test_loopNode
    *
    * @param: end1 A_test_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param: end2 LoopNode::test: ExecutableNode [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_test_loopNode
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_test_loopNode {
     
    implicit def reads
    : Reads[OTIUMLA_test_loopNode]
    = Json.reads[OTIUMLA_test_loopNode]
  
    implicit def writes
    : Writes[OTIUMLA_test_loopNode]
    = Json.writes[OTIUMLA_test_loopNode]
  
    implicit def formats
    : Format[OTIUMLA_test_loopNode]
    = Json.format[OTIUMLA_test_loopNode]

  }

  /**
    * A_toBefore_after
    *
    * @param: end1 GeneralOrdering::after: OccurrenceSpecification [1..1] { unordered, unique, reference }
    * @param: end2 OccurrenceSpecification::toBefore: GeneralOrdering [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_toBefore_after
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_toBefore_after {
     
    implicit def reads
    : Reads[OTIUMLA_toBefore_after]
    = Json.reads[OTIUMLA_toBefore_after]
  
    implicit def writes
    : Writes[OTIUMLA_toBefore_after]
    = Json.writes[OTIUMLA_toBefore_after]
  
    implicit def formats
    : Format[OTIUMLA_toBefore_after]
    = Json.format[OTIUMLA_toBefore_after]

  }

  /**
    * A_value_linkEndData
    *
    * @param: end1 A_value_linkEndData::linkEndData: LinkEndData [0..1] { unordered, unique, reference }
    * @param: end2 LinkEndData::value: InputPin [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_value_linkEndData
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_value_linkEndData {
     
    implicit def reads
    : Reads[OTIUMLA_value_linkEndData]
    = Json.reads[OTIUMLA_value_linkEndData]
  
    implicit def writes
    : Writes[OTIUMLA_value_linkEndData]
    = Json.writes[OTIUMLA_value_linkEndData]
  
    implicit def formats
    : Format[OTIUMLA_value_linkEndData]
    = Json.format[OTIUMLA_value_linkEndData]

  }

  /**
    * A_value_qualifierValue
    *
    * @param: end1 A_value_qualifierValue::qualifierValue: QualifierValue [0..1] { unordered, unique, reference }
    * @param: end2 QualifierValue::value: InputPin [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_value_qualifierValue
  ( override val end1: ElementLocation,
    override val end2: ElementLocation )
  extends  OTIMOFReferenceLink
  {}

  object OTIUMLA_value_qualifierValue {
     
    implicit def reads
    : Reads[OTIUMLA_value_qualifierValue]
    = Json.reads[OTIUMLA_value_qualifierValue]
  
    implicit def writes
    : Writes[OTIUMLA_value_qualifierValue]
    = Json.writes[OTIUMLA_value_qualifierValue]
  
    implicit def formats
    : Format[OTIUMLA_value_qualifierValue]
    = Json.format[OTIUMLA_value_qualifierValue]

  }


  // <!-- Start of user code OTI MOF Link companion -->
  // <!-- End of user code OTI MOF Link companion -->

}

object OTIMOFCompositeLink {

  // <!-- Start of user code OTI MOF Composite Link companion -->
  
  implicit val ordering
  : Ordering[OTIMOFCompositeLink]
  = new Ordering[OTIMOFCompositeLink] {

    def compare(x: OTIMOFCompositeLink, y: OTIMOFCompositeLink)
    : Int
    = ElementLocation.ordering.compare(x.end1, y.end1) match {
      case 0 =>
        ElementLocation.ordering.compare(x.end2, y.end2)
      case c =>
        c
    }

  }

  implicit val writes
  : Writes[OTIMOFCompositeLink]
  = Variants.writes[OTIMOFCompositeLink]((__ \ "type").format[String])
  
  implicit val reads
  : Reads[OTIMOFCompositeLink]
  = Variants.reads[OTIMOFCompositeLink]((__ \ "type").format[String])

  implicit val formats
  : Format[OTIMOFCompositeLink]
  = Variants.format[OTIMOFCompositeLink]((__ \ "type").format[String])

  // <!-- End of user code OTI MOF Composite Link companion -->

}

object OTIMOFCompositeOrderedLink {

  // <!-- Start of user code OTI MOF Composite Ordered Link companion -->

  implicit val ordering
  : Ordering[OTIMOFCompositeOrderedLink]
  = new Ordering[OTIMOFCompositeOrderedLink] {

    def compare(x: OTIMOFCompositeOrderedLink, y: OTIMOFCompositeOrderedLink)
    : Int
    = ElementLocation.ordering.compare(x.end1, y.end1) match {
      case 0 =>
        ElementLocation.ordering.compare(x.end2, y.end2) match {
          case 0 =>
            Ordering[Int].compare(x.end2Index, y.end2Index)
          case c =>
            c
        }
      case c =>
        c
    }

  }

  implicit val writes
  : Writes[OTIMOFCompositeOrderedLink]
  = Variants.writes[OTIMOFCompositeOrderedLink]((__ \ "type").format[String])

  implicit val reads
  : Reads[OTIMOFCompositeOrderedLink]
  = Variants.reads[OTIMOFCompositeOrderedLink]((__ \ "type").format[String])

  implicit val formats
  : Format[OTIMOFCompositeOrderedLink]
  = Variants.format[OTIMOFCompositeOrderedLink]((__ \ "type").format[String])

  // <!-- End of user code OTI MOF Composite Ordered Link companion -->

}

object OTIMOFReferenceLink {

  // <!-- Start of user code OTI MOF Reference Link companion -->
  
  implicit val ordering
  : Ordering[OTIMOFReferenceLink]
  = new Ordering[OTIMOFReferenceLink] {

    def compare(x: OTIMOFReferenceLink, y: OTIMOFReferenceLink)
    : Int
    = ElementLocation.ordering.compare(x.end1, y.end1) match {
      case 0 =>
        ElementLocation.ordering.compare(x.end2, y.end2)
      case c =>
        c
    }

  }

  implicit val writes
  : Writes[OTIMOFReferenceLink]
  = Variants.writes[OTIMOFReferenceLink]((__ \ "type").format[String])
  
  implicit val reads
  : Reads[OTIMOFReferenceLink]
  = Variants.reads[OTIMOFReferenceLink]((__ \ "type").format[String])

  implicit val formats
  : Format[OTIMOFReferenceLink]
  = Variants.format[OTIMOFReferenceLink]((__ \ "type").format[String])

  // <!-- End of user code OTI MOF Reference Link companion -->

}

object OTIMOFReferenceOrderedLink {

  // <!-- Start of user code OTI MOF Reference Ordered Link companion -->

  implicit val ordering
  : Ordering[OTIMOFReferenceOrderedLink]
  = new Ordering[OTIMOFReferenceOrderedLink] {

    def compare(x: OTIMOFReferenceOrderedLink, y: OTIMOFReferenceOrderedLink)
    : Int
    = ElementLocation.ordering.compare(x.end1, y.end1) match {
      case 0 =>
        ElementLocation.ordering.compare(x.end2, y.end2) match {
          case 0 =>
            Ordering[Int].compare(x.end2Index, y.end2Index)
          case c =>
            c
        }
      case c =>
        c
    }

  }

  implicit val writes
  : Writes[OTIMOFReferenceOrderedLink]
  = Variants.writes[OTIMOFReferenceOrderedLink]((__ \ "type").format[String])

  implicit val reads
  : Reads[OTIMOFReferenceOrderedLink]
  = Variants.reads[OTIMOFReferenceOrderedLink]((__ \ "type").format[String])

  implicit val formats
  : Format[OTIMOFReferenceOrderedLink]
  = Variants.format[OTIMOFReferenceOrderedLink]((__ \ "type").format[String])

  // <!-- End of user code OTI MOF Reference Ordered Link companion -->

}
