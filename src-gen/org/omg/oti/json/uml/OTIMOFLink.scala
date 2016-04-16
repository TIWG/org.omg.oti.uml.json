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

import org.omg.oti.json.common._

import scala.Int

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

  def end1: ToolSpecificElementDocumentURL
  def end2: ToolSpecificElementDocumentURL

}

/**
  * <!-- Start of user code OTIMOFCompositeLink -->
  * A MOF link for an association with one end that has composite aggregation and the other non-composite aggregation
  * <!-- End of user code OTIMOFCompositeLink -->
  */
sealed trait OTIMOFCompositeLink {}

/**
  * <!-- Start of user code OTIMOFReferenceLink -->
  * A MOF link for an association with both ends having non-composite aggregation
  * <!-- End of user code OTIMOFReferenceLink -->
  */
sealed trait OTIMOFReferenceLink {}

/**
  * <!-- Start of user code OTIMOFFirstEndOrderedLink -->
  * A MOF link for an association whose 1st member end is ordered and whose 2nd member end is unordered
  * 
  * Let oep = the 1st end of a binary (N=2) association; per OMG UML 2.5, section 9.5.3,
  * the context for oep is the set of classifiers at the other end of oep, i.e., the 2nd end.
  * Per OMG UML 2.5, section 11.5.3.1, association specific instances with the context of oep, i.e., the 2nd end.
  * The collection of links of the association referring to these specific instances as the value of the 2nd end
  * will identify a collection of instances at oep, i.e., 1st end. Since end1 is ordered, this collection must
  * be ordered in accordance with the ordering information in the links (i.e., end1Index).
  * <!-- End of user code OTIMOFFirstEndOrderedLink -->
  */
sealed trait OTIMOFFirstEndOrderedLink {
  def end1Index: Int
}

/**
  * <!-- Start of user code OTIMOFSecondEndOrderedLink -->
  * A MOF link for an association whose 1st member end is unordered and whose 2nd member end is ordered
  * 
  * Let oep = the 2nd end of a binary (N=2) association; per OMG UML 2.5, section 9.5.3,
  * the context for oep is the set of classifiers at the other end of oep, i.e., the 1st end.
  * Per OMG UML 2.5, section 11.5.3.1, association specific instances with the context of oep, i.e., the 1st end.
  * The collection of links of the association referring to these specific instances as the value of the 1st end
  * will identify a collection of instances at oep, i.e., 2nd end. Since end2 is ordered, this collection must
  * be ordered in accordance with the ordering information in the links (i.e., end2Index).
  * <!-- End of user code OTIMOFSecondEndOrderedLink -->
  */
sealed trait OTIMOFSecondEndOrderedLink {
  def end2Index: Int
}

object OTIMOFLink {
  
  /**
    * A_action_interaction
    *
    * @param end1 A_action_interaction::interaction: Interaction [0..1] { unordered, unique, reference }
    * @param end2 Interaction::action: Action [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_action_interaction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_actualGate_interactionUse
    *
    * @param end1 A_actualGate_interactionUse::interactionUse: InteractionUse [0..1] { unordered, unique, reference }
    * @param end2 InteractionUse::actualGate: Gate [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_actualGate_interactionUse
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_argument_interactionUse
    *
    * @param end1 A_argument_interactionUse::interactionUse: InteractionUse [0..1] { unordered, unique, reference }
    * @param end2 InteractionUse::argument: ValueSpecification [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_argument_interactionUse
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_argument_invocationAction
    *
    * @param end1 A_argument_invocationAction::invocationAction: InvocationAction [0..1] { unordered, unique, reference }
    * @param end2 InvocationAction::argument: InputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_argument_invocationAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_argument_message
    *
    * @param end1 A_argument_message::message: Message [0..1] { unordered, unique, reference }
    * @param end2 Message::argument: ValueSpecification [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_argument_message
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_bodyCondition_bodyContext
    *
    * @param end1 A_bodyCondition_bodyContext::bodyContext: Operation [0..1] { unordered, unique, reference }
    * @param end2 Operation::bodyCondition: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_bodyCondition_bodyContext
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_cfragmentGate_combinedFragment
    *
    * @param end1 A_cfragmentGate_combinedFragment::combinedFragment: CombinedFragment [0..1] { unordered, unique, reference }
    * @param end2 CombinedFragment::cfragmentGate: Gate [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_cfragmentGate_combinedFragment
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_changeExpression_changeEvent
    *
    * @param end1 A_changeExpression_changeEvent::changeEvent: ChangeEvent [0..1] { unordered, unique, reference }
    * @param end2 ChangeEvent::changeExpression: ValueSpecification [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_changeExpression_changeEvent
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_clause_conditionalNode
    *
    * @param end1 A_clause_conditionalNode::conditionalNode: ConditionalNode [1..1] { unordered, unique, reference }
    * @param end2 ConditionalNode::clause: Clause [1..*] { unordered, unique, composite }
    */
  case class OTIUMLA_clause_conditionalNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_collaborationUse_classifier
    *
    * @param end1 A_collaborationUse_classifier::classifier: Classifier [0..1] { unordered, unique, reference }
    * @param end2 Classifier::collaborationUse: CollaborationUse [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_collaborationUse_classifier
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_collection_reduceAction
    *
    * @param end1 A_collection_reduceAction::reduceAction: ReduceAction [0..1] { unordered, unique, reference }
    * @param end2 ReduceAction::collection: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_collection_reduceAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_condition_extend
    *
    * @param end1 A_condition_extend::extend: Extend [0..1] { unordered, unique, reference }
    * @param end2 Extend::condition: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_condition_extend
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_condition_parameterSet
    *
    * @param end1 A_condition_parameterSet::parameterSet: ParameterSet [0..1] { unordered, unique, reference }
    * @param end2 ParameterSet::condition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_condition_parameterSet
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_configuration_deployment
    *
    * @param end1 DeploymentSpecification::deployment: Deployment [0..1] { unordered, unique, reference }
    * @param end2 Deployment::configuration: DeploymentSpecification [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_configuration_deployment
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_conformance_specificMachine
    *
    * @param end1 ProtocolConformance::specificMachine: ProtocolStateMachine [1..1] { unordered, unique, reference }
    * @param end2 ProtocolStateMachine::conformance: ProtocolConformance [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_conformance_specificMachine
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_connectionPoint_state
    *
    * @param end1 Pseudostate::state: State [0..1] { unordered, unique, reference }
    * @param end2 State::connectionPoint: Pseudostate [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_connectionPoint_state
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_connectionPoint_stateMachine
    *
    * @param end1 Pseudostate::stateMachine: StateMachine [0..1] { unordered, unique, reference }
    * @param end2 StateMachine::connectionPoint: Pseudostate [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_connectionPoint_stateMachine
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_connection_state
    *
    * @param end1 ConnectionPointReference::state: State [0..1] { unordered, unique, reference }
    * @param end2 State::connection: ConnectionPointReference [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_connection_state
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_defaultValue_owningParameter
    *
    * @param end1 A_defaultValue_owningParameter::owningParameter: Parameter [0..1] { unordered, unique, reference }
    * @param end2 Parameter::defaultValue: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_defaultValue_owningParameter
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_defaultValue_owningProperty
    *
    * @param end1 A_defaultValue_owningProperty::owningProperty: Property [0..1] { unordered, unique, reference }
    * @param end2 Property::defaultValue: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_defaultValue_owningProperty
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_deferrableTrigger_state
    *
    * @param end1 A_deferrableTrigger_state::state: State [0..1] { unordered, unique, reference }
    * @param end2 State::deferrableTrigger: Trigger [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_deferrableTrigger_state
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_deployment_location
    *
    * @param end1 DeploymentTarget::deployment: Deployment [0..*] { unordered, unique, composite }
    * @param end2 Deployment::location: DeploymentTarget [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_deployment_location
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_doActivity_state
    *
    * @param end1 A_doActivity_state::state: State [0..1] { unordered, unique, reference }
    * @param end2 State::doActivity: Behavior [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_doActivity_state
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_edge_activity
    *
    * @param end1 Activity::edge: ActivityEdge [0..*] { unordered, unique, composite }
    * @param end2 ActivityEdge::activity: Activity [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_edge_activity
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_edge_inStructuredNode
    *
    * @param end1 ActivityEdge::inStructuredNode: StructuredActivityNode [0..1] { unordered, unique, reference }
    * @param end2 StructuredActivityNode::edge: ActivityEdge [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_edge_inStructuredNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_effect_transition
    *
    * @param end1 A_effect_transition::transition: Transition [0..1] { unordered, unique, reference }
    * @param end2 Transition::effect: Behavior [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_effect_transition
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_elementImport_importingNamespace
    *
    * @param end1 Namespace::elementImport: ElementImport [0..*] { unordered, unique, composite }
    * @param end2 ElementImport::importingNamespace: Namespace [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_elementImport_importingNamespace
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_endData_createLinkAction
    *
    * @param end1 A_endData_createLinkAction::createLinkAction: CreateLinkAction [1..1] { unordered, unique, reference }
    * @param end2 CreateLinkAction::endData: LinkEndCreationData [2..*] { unordered, unique, composite }
    */
  case class OTIUMLA_endData_createLinkAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_endData_destroyLinkAction
    *
    * @param end1 A_endData_destroyLinkAction::destroyLinkAction: DestroyLinkAction [1..1] { unordered, unique, reference }
    * @param end2 DestroyLinkAction::endData: LinkEndDestructionData [2..*] { unordered, unique, composite }
    */
  case class OTIUMLA_endData_destroyLinkAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_endData_linkAction
    *
    * @param end1 A_endData_linkAction::linkAction: LinkAction [1..1] { unordered, unique, reference }
    * @param end2 LinkAction::endData: LinkEndData [2..*] { unordered, unique, composite }
    */
  case class OTIUMLA_endData_linkAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_end_connector
    *
    * @param end1 A_end_connector::connector: Connector [1..1] { unordered, unique, reference }
    * @param end2 Connector::end: ConnectorEnd [2..*] { ordered, unique, composite }
    */
  case class OTIUMLA_end_connector
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_entry_state
    *
    * @param end1 A_entry_state::state: State [0..1] { unordered, unique, reference }
    * @param end2 State::entry: Behavior [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_entry_state
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_exception_raiseExceptionAction
    *
    * @param end1 A_exception_raiseExceptionAction::raiseExceptionAction: RaiseExceptionAction [0..1] { unordered, unique, reference }
    * @param end2 RaiseExceptionAction::exception: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_exception_raiseExceptionAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_executableNode_sequenceNode
    *
    * @param end1 A_executableNode_sequenceNode::sequenceNode: SequenceNode [0..1] { unordered, unique, reference }
    * @param end2 SequenceNode::executableNode: ExecutableNode [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_executableNode_sequenceNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_exit_state
    *
    * @param end1 A_exit_state::state: State [0..1] { unordered, unique, reference }
    * @param end2 State::exit: Behavior [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_exit_state
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_expr_duration
    *
    * @param end1 A_expr_duration::duration: Duration [0..1] { unordered, unique, reference }
    * @param end2 Duration::expr: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_expr_duration
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_expr_timeExpression
    *
    * @param end1 A_expr_timeExpression::timeExpression: TimeExpression [0..1] { unordered, unique, reference }
    * @param end2 TimeExpression::expr: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_expr_timeExpression
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_extend_extension
    *
    * @param end1 Extend::extension: UseCase [1..1] { unordered, unique, reference }
    * @param end2 UseCase::extend: Extend [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_extend_extension
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_extensionPoint_useCase
    *
    * @param end1 ExtensionPoint::useCase: UseCase [1..1] { unordered, unique, reference }
    * @param end2 UseCase::extensionPoint: ExtensionPoint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_extensionPoint_useCase
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_first_testIdentityAction
    *
    * @param end1 A_first_testIdentityAction::testIdentityAction: TestIdentityAction [0..1] { unordered, unique, reference }
    * @param end2 TestIdentityAction::first: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_first_testIdentityAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_formalGate_interaction
    *
    * @param end1 A_formalGate_interaction::interaction: Interaction [0..1] { unordered, unique, reference }
    * @param end2 Interaction::formalGate: Gate [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_formalGate_interaction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_fragment_enclosingInteraction
    *
    * @param end1 InteractionFragment::enclosingInteraction: Interaction [0..1] { unordered, unique, reference }
    * @param end2 Interaction::fragment: InteractionFragment [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_fragment_enclosingInteraction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_fragment_enclosingOperand
    *
    * @param end1 InteractionFragment::enclosingOperand: InteractionOperand [0..1] { unordered, unique, reference }
    * @param end2 InteractionOperand::fragment: InteractionFragment [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_fragment_enclosingOperand
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_fromAction_actionInputPin
    *
    * @param end1 A_fromAction_actionInputPin::actionInputPin: ActionInputPin [0..1] { unordered, unique, reference }
    * @param end2 ActionInputPin::fromAction: Action [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_fromAction_actionInputPin
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_generalOrdering_interactionFragment
    *
    * @param end1 A_generalOrdering_interactionFragment::interactionFragment: InteractionFragment [0..1] { unordered, unique, reference }
    * @param end2 InteractionFragment::generalOrdering: GeneralOrdering [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_generalOrdering_interactionFragment
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_generalization_specific
    *
    * @param end1 Generalization::specific: Classifier [1..1] { unordered, unique, reference }
    * @param end2 Classifier::generalization: Generalization [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_generalization_specific
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_group_inActivity
    *
    * @param end1 Activity::group: ActivityGroup [0..*] { unordered, unique, composite }
    * @param end2 ActivityGroup::inActivity: Activity [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_group_inActivity
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_guard_activityEdge
    *
    * @param end1 A_guard_activityEdge::activityEdge: ActivityEdge [0..1] { unordered, unique, reference }
    * @param end2 ActivityEdge::guard: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_guard_activityEdge
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_guard_interactionOperand
    *
    * @param end1 A_guard_interactionOperand::interactionOperand: InteractionOperand [1..1] { unordered, unique, reference }
    * @param end2 InteractionOperand::guard: InteractionConstraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_guard_interactionOperand
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_guard_transition
    *
    * @param end1 A_guard_transition::transition: Transition [0..1] { unordered, unique, reference }
    * @param end2 Transition::guard: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_guard_transition
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_handler_protectedNode
    *
    * @param end1 ExceptionHandler::protectedNode: ExecutableNode [1..1] { unordered, unique, reference }
    * @param end2 ExecutableNode::handler: ExceptionHandler [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_handler_protectedNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_icon_stereotype
    *
    * @param end1 A_icon_stereotype::stereotype: Stereotype [0..1] { unordered, unique, reference }
    * @param end2 Stereotype::icon: Image [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_icon_stereotype
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_include_includingCase
    *
    * @param end1 Include::includingCase: UseCase [1..1] { unordered, unique, reference }
    * @param end2 UseCase::include: Include [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_include_includingCase
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_inputValue_linkAction
    *
    * @param end1 A_inputValue_linkAction::linkAction: LinkAction [0..1] { unordered, unique, reference }
    * @param end2 LinkAction::inputValue: InputPin [1..*] { unordered, unique, composite }
    */
  case class OTIUMLA_inputValue_linkAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_inputValue_opaqueAction
    *
    * @param end1 A_inputValue_opaqueAction::opaqueAction: OpaqueAction [0..1] { unordered, unique, reference }
    * @param end2 OpaqueAction::inputValue: InputPin [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_inputValue_opaqueAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_insertAt_addStructuralFeatureValueAction
    *
    * @param end1 A_insertAt_addStructuralFeatureValueAction::addStructuralFeatureValueAction: AddStructuralFeatureValueAction [0..1] { unordered, unique, reference }
    * @param end2 AddStructuralFeatureValueAction::insertAt: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_insertAt_addStructuralFeatureValueAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_insertAt_addVariableValueAction
    *
    * @param end1 A_insertAt_addVariableValueAction::addVariableValueAction: AddVariableValueAction [0..1] { unordered, unique, reference }
    * @param end2 AddVariableValueAction::insertAt: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_insertAt_addVariableValueAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_interfaceRealization_implementingClassifier
    *
    * @param end1 InterfaceRealization::implementingClassifier: BehavioredClassifier [1..1] { unordered, unique, reference }
    * @param end2 BehavioredClassifier::interfaceRealization: InterfaceRealization [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_interfaceRealization_implementingClassifier
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_invariant_stateInvariant
    *
    * @param end1 A_invariant_stateInvariant::stateInvariant: StateInvariant [0..1] { unordered, unique, reference }
    * @param end2 StateInvariant::invariant: Constraint [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_invariant_stateInvariant
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_joinSpec_joinNode
    *
    * @param end1 A_joinSpec_joinNode::joinNode: JoinNode [0..1] { unordered, unique, reference }
    * @param end2 JoinNode::joinSpec: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_joinSpec_joinNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_lifeline_interaction
    *
    * @param end1 Lifeline::interaction: Interaction [1..1] { unordered, unique, reference }
    * @param end2 Interaction::lifeline: Lifeline [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_lifeline_interaction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_localPostcondition_action
    *
    * @param end1 A_localPostcondition_action::action: Action [0..1] { unordered, unique, reference }
    * @param end2 Action::localPostcondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_localPostcondition_action
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_localPrecondition_action
    *
    * @param end1 A_localPrecondition_action::action: Action [0..1] { unordered, unique, reference }
    * @param end2 Action::localPrecondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_localPrecondition_action
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_loopVariableInput_loopNode
    *
    * @param end1 A_loopVariableInput_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param end2 LoopNode::loopVariableInput: InputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_loopVariableInput_loopNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_loopVariable_loopNode
    *
    * @param end1 A_loopVariable_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param end2 LoopNode::loopVariable: OutputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_loopVariable_loopNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_lowerValue_owningLower
    *
    * @param end1 A_lowerValue_owningLower::owningLower: MultiplicityElement [0..1] { unordered, unique, reference }
    * @param end2 MultiplicityElement::lowerValue: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_lowerValue_owningLower
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_manifestation_artifact
    *
    * @param end1 A_manifestation_artifact::artifact: Artifact [1..1] { unordered, unique, reference }
    * @param end2 Artifact::manifestation: Manifestation [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_manifestation_artifact
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_mapping_abstraction
    *
    * @param end1 A_mapping_abstraction::abstraction: Abstraction [0..1] { unordered, unique, reference }
    * @param end2 Abstraction::mapping: OpaqueExpression [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_mapping_abstraction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_maxint_interactionConstraint
    *
    * @param end1 A_maxint_interactionConstraint::interactionConstraint: InteractionConstraint [0..1] { unordered, unique, reference }
    * @param end2 InteractionConstraint::maxint: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_maxint_interactionConstraint
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_message_interaction
    *
    * @param end1 Interaction::message: Message [0..*] { unordered, unique, composite }
    * @param end2 Message::interaction: Interaction [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_message_interaction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_metaclassReference_profile
    *
    * @param end1 A_metaclassReference_profile::profile: Profile [0..1] { unordered, unique, reference }
    * @param end2 Profile::metaclassReference: ElementImport [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_metaclassReference_profile
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_metamodelReference_profile
    *
    * @param end1 A_metamodelReference_profile::profile: Profile [0..1] { unordered, unique, reference }
    * @param end2 Profile::metamodelReference: PackageImport [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_metamodelReference_profile
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_minint_interactionConstraint
    *
    * @param end1 A_minint_interactionConstraint::interactionConstraint: InteractionConstraint [0..1] { unordered, unique, reference }
    * @param end2 InteractionConstraint::minint: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_minint_interactionConstraint
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_nameExpression_namedElement
    *
    * @param end1 A_nameExpression_namedElement::namedElement: NamedElement [0..1] { unordered, unique, reference }
    * @param end2 NamedElement::nameExpression: StringExpression [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_nameExpression_namedElement
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_nestedArtifact_artifact
    *
    * @param end1 A_nestedArtifact_artifact::artifact: Artifact [0..1] { unordered, unique, reference }
    * @param end2 Artifact::nestedArtifact: Artifact [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_nestedArtifact_artifact
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_nestedClassifier_interface
    *
    * @param end1 A_nestedClassifier_interface::interface: Interface [0..1] { unordered, unique, reference }
    * @param end2 Interface::nestedClassifier: Classifier [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_nestedClassifier_interface
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_nestedClassifier_nestingClass
    *
    * @param end1 A_nestedClassifier_nestingClass::nestingClass: Class [0..1] { unordered, unique, reference }
    * @param end2 Class::nestedClassifier: Classifier [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_nestedClassifier_nestingClass
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_nestedNode_node
    *
    * @param end1 A_nestedNode_node::node: Node [0..1] { unordered, unique, reference }
    * @param end2 Node::nestedNode: Node [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_nestedNode_node
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_node_activity
    *
    * @param end1 Activity::node: ActivityNode [0..*] { unordered, unique, composite }
    * @param end2 ActivityNode::activity: Activity [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_node_activity
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_node_inStructuredNode
    *
    * @param end1 ActivityNode::inStructuredNode: StructuredActivityNode [0..1] { unordered, unique, reference }
    * @param end2 StructuredActivityNode::node: ActivityNode [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_node_inStructuredNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_object_clearAssociationAction
    *
    * @param end1 A_object_clearAssociationAction::clearAssociationAction: ClearAssociationAction [0..1] { unordered, unique, reference }
    * @param end2 ClearAssociationAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_clearAssociationAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_object_readIsClassifiedObjectAction
    *
    * @param end1 A_object_readIsClassifiedObjectAction::readIsClassifiedObjectAction: ReadIsClassifiedObjectAction [0..1] { unordered, unique, reference }
    * @param end2 ReadIsClassifiedObjectAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_readIsClassifiedObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_object_readLinkObjectEndAction
    *
    * @param end1 A_object_readLinkObjectEndAction::readLinkObjectEndAction: ReadLinkObjectEndAction [0..1] { unordered, unique, reference }
    * @param end2 ReadLinkObjectEndAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_readLinkObjectEndAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_object_readLinkObjectEndQualifierAction
    *
    * @param end1 A_object_readLinkObjectEndQualifierAction::readLinkObjectEndQualifierAction: ReadLinkObjectEndQualifierAction [0..1] { unordered, unique, reference }
    * @param end2 ReadLinkObjectEndQualifierAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_readLinkObjectEndQualifierAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_object_reclassifyObjectAction
    *
    * @param end1 A_object_reclassifyObjectAction::reclassifyObjectAction: ReclassifyObjectAction [0..1] { unordered, unique, reference }
    * @param end2 ReclassifyObjectAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_reclassifyObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_object_startClassifierBehaviorAction
    *
    * @param end1 A_object_startClassifierBehaviorAction::startClassifierBehaviorAction: StartClassifierBehaviorAction [0..1] { unordered, unique, reference }
    * @param end2 StartClassifierBehaviorAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_startClassifierBehaviorAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_object_startObjectBehaviorAction
    *
    * @param end1 A_object_startObjectBehaviorAction::startObjectBehaviorAction: StartObjectBehaviorAction [0..1] { unordered, unique, reference }
    * @param end2 StartObjectBehaviorAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_startObjectBehaviorAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_object_structuralFeatureAction
    *
    * @param end1 A_object_structuralFeatureAction::structuralFeatureAction: StructuralFeatureAction [0..1] { unordered, unique, reference }
    * @param end2 StructuralFeatureAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_structuralFeatureAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_object_unmarshallAction
    *
    * @param end1 A_object_unmarshallAction::unmarshallAction: UnmarshallAction [0..1] { unordered, unique, reference }
    * @param end2 UnmarshallAction::object: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_object_unmarshallAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_operand_combinedFragment
    *
    * @param end1 A_operand_combinedFragment::combinedFragment: CombinedFragment [0..1] { unordered, unique, reference }
    * @param end2 CombinedFragment::operand: InteractionOperand [1..*] { ordered, unique, composite }
    */
  case class OTIUMLA_operand_combinedFragment
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_operand_expression
    *
    * @param end1 A_operand_expression::expression: Expression [0..1] { unordered, unique, reference }
    * @param end2 Expression::operand: ValueSpecification [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_operand_expression
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_outputValue_opaqueAction
    *
    * @param end1 A_outputValue_opaqueAction::opaqueAction: OpaqueAction [0..1] { unordered, unique, reference }
    * @param end2 OpaqueAction::outputValue: OutputPin [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_outputValue_opaqueAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedActual_owningTemplateParameterSubstitution
    *
    * @param end1 A_ownedActual_owningTemplateParameterSubstitution::owningTemplateParameterSubstitution: TemplateParameterSubstitution [0..1] { unordered, unique, reference }
    * @param end2 TemplateParameterSubstitution::ownedActual: ParameterableElement [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedActual_owningTemplateParameterSubstitution
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedAttribute_artifact
    *
    * @param end1 A_ownedAttribute_artifact::artifact: Artifact [0..1] { unordered, unique, reference }
    * @param end2 Artifact::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_artifact
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedAttribute_class
    *
    * @param end1 Property::class: Class [0..1] { unordered, unique, reference }
    * @param end2 Class::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_class
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedAttribute_datatype
    *
    * @param end1 Property::datatype: DataType [0..1] { unordered, unique, reference }
    * @param end2 DataType::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_datatype
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedAttribute_interface
    *
    * @param end1 Property::interface: Interface [0..1] { unordered, unique, reference }
    * @param end2 Interface::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_interface
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedAttribute_owningSignal
    *
    * @param end1 A_ownedAttribute_owningSignal::owningSignal: Signal [0..1] { unordered, unique, reference }
    * @param end2 Signal::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_owningSignal
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedAttribute_structuredClassifier
    *
    * @param end1 A_ownedAttribute_structuredClassifier::structuredClassifier: StructuredClassifier [0..1] { unordered, unique, reference }
    * @param end2 StructuredClassifier::ownedAttribute: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedAttribute_structuredClassifier
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedBehavior_behavioredClassifier
    *
    * @param end1 A_ownedBehavior_behavioredClassifier::behavioredClassifier: BehavioredClassifier [0..1] { unordered, unique, reference }
    * @param end2 BehavioredClassifier::ownedBehavior: Behavior [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedBehavior_behavioredClassifier
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedComment_owningElement
    *
    * @param end1 A_ownedComment_owningElement::owningElement: Element [0..1] { unordered, unique, reference }
    * @param end2 Element::ownedComment: Comment [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedComment_owningElement
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedConnector_structuredClassifier
    *
    * @param end1 A_ownedConnector_structuredClassifier::structuredClassifier: StructuredClassifier [0..1] { unordered, unique, reference }
    * @param end2 StructuredClassifier::ownedConnector: Connector [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedConnector_structuredClassifier
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedDefault_templateParameter
    *
    * @param end1 A_ownedDefault_templateParameter::templateParameter: TemplateParameter [0..1] { unordered, unique, reference }
    * @param end2 TemplateParameter::ownedDefault: ParameterableElement [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedDefault_templateParameter
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedEnd_extension
    *
    * @param end1 A_ownedEnd_extension::extension: Extension [1..1] { unordered, unique, reference }
    * @param end2 Extension::ownedEnd: ExtensionEnd [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedEnd_extension
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedEnd_owningAssociation
    *
    * @param end1 Property::owningAssociation: Association [0..1] { unordered, unique, reference }
    * @param end2 Association::ownedEnd: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedEnd_owningAssociation
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedLiteral_enumeration
    *
    * @param end1 EnumerationLiteral::enumeration: Enumeration [1..1] { unordered, unique, reference }
    * @param end2 Enumeration::ownedLiteral: EnumerationLiteral [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedLiteral_enumeration
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedOperation_artifact
    *
    * @param end1 A_ownedOperation_artifact::artifact: Artifact [0..1] { unordered, unique, reference }
    * @param end2 Artifact::ownedOperation: Operation [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedOperation_artifact
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedOperation_class
    *
    * @param end1 Operation::class: Class [0..1] { unordered, unique, reference }
    * @param end2 Class::ownedOperation: Operation [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedOperation_class
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedOperation_datatype
    *
    * @param end1 Operation::datatype: DataType [0..1] { unordered, unique, reference }
    * @param end2 DataType::ownedOperation: Operation [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedOperation_datatype
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedOperation_interface
    *
    * @param end1 Interface::ownedOperation: Operation [0..*] { ordered, unique, composite }
    * @param end2 Operation::interface: Interface [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_ownedOperation_interface
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end1Index: Int,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFFirstEndOrderedLink
  {}

  /**
    * A_ownedParameterSet_behavior
    *
    * @param end1 A_ownedParameterSet_behavior::behavior: Behavior [0..1] { unordered, unique, reference }
    * @param end2 Behavior::ownedParameterSet: ParameterSet [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedParameterSet_behavior
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedParameterSet_behavioralFeature
    *
    * @param end1 A_ownedParameterSet_behavioralFeature::behavioralFeature: BehavioralFeature [0..1] { unordered, unique, reference }
    * @param end2 BehavioralFeature::ownedParameterSet: ParameterSet [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedParameterSet_behavioralFeature
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedParameter_behavior
    *
    * @param end1 A_ownedParameter_behavior::behavior: Behavior [0..1] { unordered, unique, reference }
    * @param end2 Behavior::ownedParameter: Parameter [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedParameter_behavior
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedParameter_operation
    *
    * @param end1 Operation::ownedParameter: Parameter [0..*] { ordered, unique, composite }
    * @param end2 Parameter::operation: Operation [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_ownedParameter_operation
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end1Index: Int,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFFirstEndOrderedLink
  {}

  /**
    * A_ownedParameter_ownerFormalParam
    *
    * @param end1 A_ownedParameter_ownerFormalParam::ownerFormalParam: BehavioralFeature [0..1] { unordered, unique, reference }
    * @param end2 BehavioralFeature::ownedParameter: Parameter [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedParameter_ownerFormalParam
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedParameter_signature
    *
    * @param end1 TemplateParameter::signature: TemplateSignature [1..1] { unordered, unique, reference }
    * @param end2 TemplateSignature::ownedParameter: TemplateParameter [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_ownedParameter_signature
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_ownedParameteredElement_owningTemplateParameter
    *
    * @param end1 TemplateParameter::ownedParameteredElement: ParameterableElement [0..1] { unordered, unique, composite }
    * @param end2 ParameterableElement::owningTemplateParameter: TemplateParameter [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_ownedParameteredElement_owningTemplateParameter
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedReception_class
    *
    * @param end1 A_ownedReception_class::class: Class [0..1] { unordered, unique, reference }
    * @param end2 Class::ownedReception: Reception [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedReception_class
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedReception_interface
    *
    * @param end1 A_ownedReception_interface::interface: Interface [0..1] { unordered, unique, reference }
    * @param end2 Interface::ownedReception: Reception [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedReception_interface
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedRule_context
    *
    * @param end1 Namespace::ownedRule: Constraint [0..*] { unordered, unique, composite }
    * @param end2 Constraint::context: Namespace [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_ownedRule_context
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedTemplateSignature_classifier
    *
    * @param end1 Classifier::ownedTemplateSignature: RedefinableTemplateSignature [0..1] { unordered, unique, composite }
    * @param end2 RedefinableTemplateSignature::classifier: Classifier [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_ownedTemplateSignature_classifier
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedTemplateSignature_template
    *
    * @param end1 TemplateableElement::ownedTemplateSignature: TemplateSignature [0..1] { unordered, unique, composite }
    * @param end2 TemplateSignature::template: TemplateableElement [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_ownedTemplateSignature_template
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_ownedUseCase_classifier
    *
    * @param end1 A_ownedUseCase_classifier::classifier: Classifier [0..1] { unordered, unique, reference }
    * @param end2 Classifier::ownedUseCase: UseCase [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_ownedUseCase_classifier
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_packageImport_importingNamespace
    *
    * @param end1 Namespace::packageImport: PackageImport [0..*] { unordered, unique, composite }
    * @param end2 PackageImport::importingNamespace: Namespace [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_packageImport_importingNamespace
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_packageMerge_receivingPackage
    *
    * @param end1 PackageMerge::receivingPackage: Package [1..1] { unordered, unique, reference }
    * @param end2 Package::packageMerge: PackageMerge [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_packageMerge_receivingPackage
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_packagedElement_component
    *
    * @param end1 A_packagedElement_component::component: Component [0..1] { unordered, unique, reference }
    * @param end2 Component::packagedElement: PackageableElement [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_packagedElement_component
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_packagedElement_owningPackage
    *
    * @param end1 A_packagedElement_owningPackage::owningPackage: Package [0..1] { unordered, unique, reference }
    * @param end2 Package::packagedElement: PackageableElement [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_packagedElement_owningPackage
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_parameterSubstitution_templateBinding
    *
    * @param end1 TemplateBinding::parameterSubstitution: TemplateParameterSubstitution [0..*] { unordered, unique, composite }
    * @param end2 TemplateParameterSubstitution::templateBinding: TemplateBinding [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_parameterSubstitution_templateBinding
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_postCondition_owningTransition
    *
    * @param end1 A_postCondition_owningTransition::owningTransition: ProtocolTransition [0..1] { unordered, unique, reference }
    * @param end2 ProtocolTransition::postCondition: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_postCondition_owningTransition
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_postcondition_behavior
    *
    * @param end1 A_postcondition_behavior::behavior: Behavior [0..1] { unordered, unique, reference }
    * @param end2 Behavior::postcondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_postcondition_behavior
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_postcondition_postContext
    *
    * @param end1 A_postcondition_postContext::postContext: Operation [0..1] { unordered, unique, reference }
    * @param end2 Operation::postcondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_postcondition_postContext
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_preCondition_protocolTransition
    *
    * @param end1 A_preCondition_protocolTransition::protocolTransition: ProtocolTransition [0..1] { unordered, unique, reference }
    * @param end2 ProtocolTransition::preCondition: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_preCondition_protocolTransition
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_precondition_behavior
    *
    * @param end1 A_precondition_behavior::behavior: Behavior [0..1] { unordered, unique, reference }
    * @param end2 Behavior::precondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_precondition_behavior
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_precondition_preContext
    *
    * @param end1 A_precondition_preContext::preContext: Operation [0..1] { unordered, unique, reference }
    * @param end2 Operation::precondition: Constraint [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_precondition_preContext
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_profileApplication_applyingPackage
    *
    * @param end1 Package::profileApplication: ProfileApplication [0..*] { unordered, unique, composite }
    * @param end2 ProfileApplication::applyingPackage: Package [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_profileApplication_applyingPackage
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_protocol_interface
    *
    * @param end1 A_protocol_interface::interface: Interface [0..1] { unordered, unique, reference }
    * @param end2 Interface::protocol: ProtocolStateMachine [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_protocol_interface
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_qualifier_associationEnd
    *
    * @param end1 Property::associationEnd: Property [0..1] { unordered, unique, reference }
    * @param end2 Property::qualifier: Property [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_qualifier_associationEnd
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_qualifier_linkEndData
    *
    * @param end1 A_qualifier_linkEndData::linkEndData: LinkEndData [1..1] { unordered, unique, reference }
    * @param end2 LinkEndData::qualifier: QualifierValue [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_qualifier_linkEndData
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_realization_abstraction_component
    *
    * @param end1 Component::realization: ComponentRealization [0..*] { unordered, unique, composite }
    * @param end2 ComponentRealization::abstraction: Component [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_realization_abstraction_component
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_region_state
    *
    * @param end1 State::region: Region [0..*] { unordered, unique, composite }
    * @param end2 Region::state: State [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_region_state
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_region_stateMachine
    *
    * @param end1 Region::stateMachine: StateMachine [0..1] { unordered, unique, reference }
    * @param end2 StateMachine::region: Region [1..*] { unordered, unique, composite }
    */
  case class OTIUMLA_region_stateMachine
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_removeAt_removeStructuralFeatureValueAction
    *
    * @param end1 A_removeAt_removeStructuralFeatureValueAction::removeStructuralFeatureValueAction: RemoveStructuralFeatureValueAction [0..1] { unordered, unique, reference }
    * @param end2 RemoveStructuralFeatureValueAction::removeAt: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_removeAt_removeStructuralFeatureValueAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_removeAt_removeVariableValueAction
    *
    * @param end1 A_removeAt_removeVariableValueAction::removeVariableValueAction: RemoveVariableValueAction [0..1] { unordered, unique, reference }
    * @param end2 RemoveVariableValueAction::removeAt: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_removeAt_removeVariableValueAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_replyValue_replyAction
    *
    * @param end1 A_replyValue_replyAction::replyAction: ReplyAction [0..1] { unordered, unique, reference }
    * @param end2 ReplyAction::replyValue: InputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_replyValue_replyAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_request_sendObjectAction
    *
    * @param end1 A_request_sendObjectAction::sendObjectAction: SendObjectAction [0..1] { unordered, unique, reference }
    * @param end2 SendObjectAction::request: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_request_sendObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_acceptEventAction
    *
    * @param end1 A_result_acceptEventAction::acceptEventAction: AcceptEventAction [0..1] { unordered, unique, reference }
    * @param end2 AcceptEventAction::result: OutputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_result_acceptEventAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_result_callAction
    *
    * @param end1 A_result_callAction::callAction: CallAction [0..1] { unordered, unique, reference }
    * @param end2 CallAction::result: OutputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_result_callAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_result_clearStructuralFeatureAction
    *
    * @param end1 A_result_clearStructuralFeatureAction::clearStructuralFeatureAction: ClearStructuralFeatureAction [0..1] { unordered, unique, reference }
    * @param end2 ClearStructuralFeatureAction::result: OutputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_clearStructuralFeatureAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_conditionalNode
    *
    * @param end1 A_result_conditionalNode::conditionalNode: ConditionalNode [0..1] { unordered, unique, reference }
    * @param end2 ConditionalNode::result: OutputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_result_conditionalNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_result_createLinkObjectAction
    *
    * @param end1 A_result_createLinkObjectAction::createLinkObjectAction: CreateLinkObjectAction [0..1] { unordered, unique, reference }
    * @param end2 CreateLinkObjectAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_createLinkObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_createObjectAction
    *
    * @param end1 A_result_createObjectAction::createObjectAction: CreateObjectAction [0..1] { unordered, unique, reference }
    * @param end2 CreateObjectAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_createObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_loopNode
    *
    * @param end1 A_result_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param end2 LoopNode::result: OutputPin [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_result_loopNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_result_readExtentAction
    *
    * @param end1 A_result_readExtentAction::readExtentAction: ReadExtentAction [0..1] { unordered, unique, reference }
    * @param end2 ReadExtentAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readExtentAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_readIsClassifiedObjectAction
    *
    * @param end1 A_result_readIsClassifiedObjectAction::readIsClassifiedObjectAction: ReadIsClassifiedObjectAction [0..1] { unordered, unique, reference }
    * @param end2 ReadIsClassifiedObjectAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readIsClassifiedObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_readLinkAction
    *
    * @param end1 A_result_readLinkAction::readLinkAction: ReadLinkAction [0..1] { unordered, unique, reference }
    * @param end2 ReadLinkAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readLinkAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_readLinkObjectEndAction
    *
    * @param end1 A_result_readLinkObjectEndAction::readLinkObjectEndAction: ReadLinkObjectEndAction [0..1] { unordered, unique, reference }
    * @param end2 ReadLinkObjectEndAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readLinkObjectEndAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_readLinkObjectEndQualifierAction
    *
    * @param end1 A_result_readLinkObjectEndQualifierAction::readLinkObjectEndQualifierAction: ReadLinkObjectEndQualifierAction [0..1] { unordered, unique, reference }
    * @param end2 ReadLinkObjectEndQualifierAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readLinkObjectEndQualifierAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_readSelfAction
    *
    * @param end1 A_result_readSelfAction::readSelfAction: ReadSelfAction [0..1] { unordered, unique, reference }
    * @param end2 ReadSelfAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readSelfAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_readStructuralFeatureAction
    *
    * @param end1 A_result_readStructuralFeatureAction::readStructuralFeatureAction: ReadStructuralFeatureAction [0..1] { unordered, unique, reference }
    * @param end2 ReadStructuralFeatureAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readStructuralFeatureAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_readVariableAction
    *
    * @param end1 A_result_readVariableAction::readVariableAction: ReadVariableAction [0..1] { unordered, unique, reference }
    * @param end2 ReadVariableAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_readVariableAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_reduceAction
    *
    * @param end1 A_result_reduceAction::reduceAction: ReduceAction [0..1] { unordered, unique, reference }
    * @param end2 ReduceAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_reduceAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_testIdentityAction
    *
    * @param end1 A_result_testIdentityAction::testIdentityAction: TestIdentityAction [0..1] { unordered, unique, reference }
    * @param end2 TestIdentityAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_testIdentityAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_unmarshallAction
    *
    * @param end1 A_result_unmarshallAction::unmarshallAction: UnmarshallAction [0..1] { unordered, unique, reference }
    * @param end2 UnmarshallAction::result: OutputPin [1..*] { ordered, unique, composite }
    */
  case class OTIUMLA_result_unmarshallAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_result_valueSpecificationAction
    *
    * @param end1 A_result_valueSpecificationAction::valueSpecificationAction: ValueSpecificationAction [0..1] { unordered, unique, reference }
    * @param end2 ValueSpecificationAction::result: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_valueSpecificationAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_result_writeStructuralFeatureAction
    *
    * @param end1 A_result_writeStructuralFeatureAction::writeStructuralFeatureAction: WriteStructuralFeatureAction [0..1] { unordered, unique, reference }
    * @param end2 WriteStructuralFeatureAction::result: OutputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_result_writeStructuralFeatureAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_returnInformation_acceptCallAction
    *
    * @param end1 A_returnInformation_acceptCallAction::acceptCallAction: AcceptCallAction [0..1] { unordered, unique, reference }
    * @param end2 AcceptCallAction::returnInformation: OutputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_returnInformation_acceptCallAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_returnInformation_replyAction
    *
    * @param end1 A_returnInformation_replyAction::replyAction: ReplyAction [0..1] { unordered, unique, reference }
    * @param end2 ReplyAction::returnInformation: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_returnInformation_replyAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_returnValue_interactionUse
    *
    * @param end1 A_returnValue_interactionUse::interactionUse: InteractionUse [0..1] { unordered, unique, reference }
    * @param end2 InteractionUse::returnValue: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_returnValue_interactionUse
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_roleBinding_collaborationUse
    *
    * @param end1 A_roleBinding_collaborationUse::collaborationUse: CollaborationUse [0..1] { unordered, unique, reference }
    * @param end2 CollaborationUse::roleBinding: Dependency [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_roleBinding_collaborationUse
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_second_testIdentityAction
    *
    * @param end1 A_second_testIdentityAction::testIdentityAction: TestIdentityAction [0..1] { unordered, unique, reference }
    * @param end2 TestIdentityAction::second: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_second_testIdentityAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_selector_lifeline
    *
    * @param end1 A_selector_lifeline::lifeline: Lifeline [0..1] { unordered, unique, reference }
    * @param end2 Lifeline::selector: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_selector_lifeline
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_slot_owningInstance
    *
    * @param end1 Slot::owningInstance: InstanceSpecification [1..1] { unordered, unique, reference }
    * @param end2 InstanceSpecification::slot: Slot [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_slot_owningInstance
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_specification_durationConstraint
    *
    * @param end1 A_specification_durationConstraint::durationConstraint: DurationConstraint [0..1] { unordered, unique, reference }
    * @param end2 DurationConstraint::specification: DurationInterval [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_specification_durationConstraint
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_specification_intervalConstraint
    *
    * @param end1 A_specification_intervalConstraint::intervalConstraint: IntervalConstraint [0..1] { unordered, unique, reference }
    * @param end2 IntervalConstraint::specification: Interval [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_specification_intervalConstraint
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_specification_owningConstraint
    *
    * @param end1 A_specification_owningConstraint::owningConstraint: Constraint [0..1] { unordered, unique, reference }
    * @param end2 Constraint::specification: ValueSpecification [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_specification_owningConstraint
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_specification_owningInstanceSpec
    *
    * @param end1 A_specification_owningInstanceSpec::owningInstanceSpec: InstanceSpecification [0..1] { unordered, unique, reference }
    * @param end2 InstanceSpecification::specification: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_specification_owningInstanceSpec
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_specification_timeConstraint
    *
    * @param end1 A_specification_timeConstraint::timeConstraint: TimeConstraint [0..1] { unordered, unique, reference }
    * @param end2 TimeConstraint::specification: TimeInterval [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_specification_timeConstraint
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_stateInvariant_owningState
    *
    * @param end1 A_stateInvariant_owningState::owningState: State [0..1] { unordered, unique, reference }
    * @param end2 State::stateInvariant: Constraint [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_stateInvariant_owningState
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_structuredNodeInput_structuredActivityNode
    *
    * @param end1 A_structuredNodeInput_structuredActivityNode::structuredActivityNode: StructuredActivityNode [0..1] { unordered, unique, reference }
    * @param end2 StructuredActivityNode::structuredNodeInput: InputPin [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_structuredNodeInput_structuredActivityNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_structuredNodeOutput_structuredActivityNode
    *
    * @param end1 A_structuredNodeOutput_structuredActivityNode::structuredActivityNode: StructuredActivityNode [0..1] { unordered, unique, reference }
    * @param end2 StructuredActivityNode::structuredNodeOutput: OutputPin [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_structuredNodeOutput_structuredActivityNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_structuredNode_activity
    *
    * @param end1 Activity::structuredNode: StructuredActivityNode [0..*] { unordered, unique, composite }
    * @param end2 StructuredActivityNode::activity: Activity [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_structuredNode_activity
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_subExpression_owningExpression
    *
    * @param end1 StringExpression::owningExpression: StringExpression [0..1] { unordered, unique, reference }
    * @param end2 StringExpression::subExpression: StringExpression [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_subExpression_owningExpression
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_subpartition_superPartition
    *
    * @param end1 ActivityPartition::subpartition: ActivityPartition [0..*] { unordered, unique, composite }
    * @param end2 ActivityPartition::superPartition: ActivityPartition [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_subpartition_superPartition
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_substitution_substitutingClassifier
    *
    * @param end1 Substitution::substitutingClassifier: Classifier [1..1] { unordered, unique, reference }
    * @param end2 Classifier::substitution: Substitution [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_substitution_substitutingClassifier
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_subvertex_container
    *
    * @param end1 Region::subvertex: Vertex [0..*] { unordered, unique, composite }
    * @param end2 Vertex::container: Region [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_subvertex_container
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_target_callOperationAction
    *
    * @param end1 A_target_callOperationAction::callOperationAction: CallOperationAction [0..1] { unordered, unique, reference }
    * @param end2 CallOperationAction::target: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_target_callOperationAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_target_destroyObjectAction
    *
    * @param end1 A_target_destroyObjectAction::destroyObjectAction: DestroyObjectAction [0..1] { unordered, unique, reference }
    * @param end2 DestroyObjectAction::target: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_target_destroyObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_target_sendObjectAction
    *
    * @param end1 A_target_sendObjectAction::sendObjectAction: SendObjectAction [0..1] { unordered, unique, reference }
    * @param end2 SendObjectAction::target: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_target_sendObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_target_sendSignalAction
    *
    * @param end1 A_target_sendSignalAction::sendSignalAction: SendSignalAction [0..1] { unordered, unique, reference }
    * @param end2 SendSignalAction::target: InputPin [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_target_sendSignalAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_templateBinding_boundElement
    *
    * @param end1 TemplateBinding::boundElement: TemplateableElement [1..1] { unordered, unique, reference }
    * @param end2 TemplateableElement::templateBinding: TemplateBinding [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_templateBinding_boundElement
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_transition_container
    *
    * @param end1 Region::transition: Transition [0..*] { unordered, unique, composite }
    * @param end2 Transition::container: Region [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_transition_container
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_trigger_acceptEventAction
    *
    * @param end1 A_trigger_acceptEventAction::acceptEventAction: AcceptEventAction [0..1] { unordered, unique, reference }
    * @param end2 AcceptEventAction::trigger: Trigger [1..*] { unordered, unique, composite }
    */
  case class OTIUMLA_trigger_acceptEventAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_trigger_transition
    *
    * @param end1 A_trigger_transition::transition: Transition [0..1] { unordered, unique, reference }
    * @param end2 Transition::trigger: Trigger [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_trigger_transition
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_upperBound_objectNode
    *
    * @param end1 A_upperBound_objectNode::objectNode: ObjectNode [0..1] { unordered, unique, reference }
    * @param end2 ObjectNode::upperBound: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_upperBound_objectNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_upperValue_owningUpper
    *
    * @param end1 A_upperValue_owningUpper::owningUpper: MultiplicityElement [0..1] { unordered, unique, reference }
    * @param end2 MultiplicityElement::upperValue: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_upperValue_owningUpper
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_value_owningSlot
    *
    * @param end1 A_value_owningSlot::owningSlot: Slot [0..1] { unordered, unique, reference }
    * @param end2 Slot::value: ValueSpecification [0..*] { ordered, unique, composite }
    */
  case class OTIUMLA_value_owningSlot
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_value_valuePin
    *
    * @param end1 A_value_valuePin::valuePin: ValuePin [0..1] { unordered, unique, reference }
    * @param end2 ValuePin::value: ValueSpecification [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_value_valuePin
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_value_valueSpecificationAction
    *
    * @param end1 A_value_valueSpecificationAction::valueSpecificationAction: ValueSpecificationAction [0..1] { unordered, unique, reference }
    * @param end2 ValueSpecificationAction::value: ValueSpecification [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_value_valueSpecificationAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_value_writeStructuralFeatureAction
    *
    * @param end1 A_value_writeStructuralFeatureAction::writeStructuralFeatureAction: WriteStructuralFeatureAction [0..1] { unordered, unique, reference }
    * @param end2 WriteStructuralFeatureAction::value: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_value_writeStructuralFeatureAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_value_writeVariableAction
    *
    * @param end1 A_value_writeVariableAction::writeVariableAction: WriteVariableAction [0..1] { unordered, unique, reference }
    * @param end2 WriteVariableAction::value: InputPin [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_value_writeVariableAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_variable_activityScope
    *
    * @param end1 Variable::activityScope: Activity [0..1] { unordered, unique, reference }
    * @param end2 Activity::variable: Variable [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_variable_activityScope
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_variable_scope
    *
    * @param end1 Variable::scope: StructuredActivityNode [0..1] { unordered, unique, reference }
    * @param end2 StructuredActivityNode::variable: Variable [0..*] { unordered, unique, composite }
    */
  case class OTIUMLA_variable_scope
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_weight_activityEdge
    *
    * @param end1 A_weight_activityEdge::activityEdge: ActivityEdge [0..1] { unordered, unique, reference }
    * @param end2 ActivityEdge::weight: ValueSpecification [0..1] { unordered, unique, composite }
    */
  case class OTIUMLA_weight_activityEdge
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * A_when_timeEvent
    *
    * @param end1 A_when_timeEvent::timeEvent: TimeEvent [0..1] { unordered, unique, reference }
    * @param end2 TimeEvent::when: TimeExpression [1..1] { unordered, unique, composite }
    */
  case class OTIUMLA_when_timeEvent
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}


  /**
    * A_action_actionExecutionSpecification
    *
    * @param end1 A_action_actionExecutionSpecification::actionExecutionSpecification: ActionExecutionSpecification [0..*] { unordered, unique, reference }
    * @param end2 ActionExecutionSpecification::action: Action [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_action_actionExecutionSpecification
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_actual_templateParameterSubstitution
    *
    * @param end1 A_actual_templateParameterSubstitution::templateParameterSubstitution: TemplateParameterSubstitution [0..*] { unordered, unique, reference }
    * @param end2 TemplateParameterSubstitution::actual: ParameterableElement [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_actual_templateParameterSubstitution
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_addition_include
    *
    * @param end1 A_addition_include::include: Include [0..*] { unordered, unique, reference }
    * @param end2 Include::addition: UseCase [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_addition_include
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_annotatedElement_comment
    *
    * @param end1 A_annotatedElement_comment::comment: Comment [0..*] { unordered, unique, reference }
    * @param end2 Comment::annotatedElement: Element [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_annotatedElement_comment
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_appliedProfile_profileApplication
    *
    * @param end1 A_appliedProfile_profileApplication::profileApplication: ProfileApplication [0..*] { unordered, unique, reference }
    * @param end2 ProfileApplication::appliedProfile: Profile [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_appliedProfile_profileApplication
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_association_clearAssociationAction
    *
    * @param end1 A_association_clearAssociationAction::clearAssociationAction: ClearAssociationAction [0..1] { unordered, unique, reference }
    * @param end2 ClearAssociationAction::association: Association [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_association_clearAssociationAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_before_toAfter
    *
    * @param end1 GeneralOrdering::before: OccurrenceSpecification [1..1] { unordered, unique, reference }
    * @param end2 OccurrenceSpecification::toAfter: GeneralOrdering [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_before_toAfter
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_behavior_behaviorExecutionSpecification
    *
    * @param end1 A_behavior_behaviorExecutionSpecification::behaviorExecutionSpecification: BehaviorExecutionSpecification [0..*] { unordered, unique, reference }
    * @param end2 BehaviorExecutionSpecification::behavior: Behavior [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_behavior_behaviorExecutionSpecification
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_behavior_callBehaviorAction
    *
    * @param end1 A_behavior_callBehaviorAction::callBehaviorAction: CallBehaviorAction [0..*] { unordered, unique, reference }
    * @param end2 CallBehaviorAction::behavior: Behavior [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_behavior_callBehaviorAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_behavior_opaqueExpression
    *
    * @param end1 A_behavior_opaqueExpression::opaqueExpression: OpaqueExpression [0..*] { unordered, unique, reference }
    * @param end2 OpaqueExpression::behavior: Behavior [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_behavior_opaqueExpression
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_bodyOutput_clause
    *
    * @param end1 A_bodyOutput_clause::clause: Clause [0..*] { unordered, unique, reference }
    * @param end2 Clause::bodyOutput: OutputPin [0..*] { ordered, unique, reference }
    */
  case class OTIUMLA_bodyOutput_clause
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_bodyOutput_loopNode
    *
    * @param end1 A_bodyOutput_loopNode::loopNode: LoopNode [0..*] { unordered, unique, reference }
    * @param end2 LoopNode::bodyOutput: OutputPin [0..*] { ordered, unique, reference }
    */
  case class OTIUMLA_bodyOutput_loopNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_bodyPart_loopNode
    *
    * @param end1 A_bodyPart_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param end2 LoopNode::bodyPart: ExecutableNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_bodyPart_loopNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_body_clause
    *
    * @param end1 A_body_clause::clause: Clause [0..1] { unordered, unique, reference }
    * @param end2 Clause::body: ExecutableNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_body_clause
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_classifierBehavior_behavioredClassifier
    *
    * @param end1 A_classifierBehavior_behavioredClassifier::behavioredClassifier: BehavioredClassifier [0..1] { unordered, unique, reference }
    * @param end2 BehavioredClassifier::classifierBehavior: Behavior [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_classifierBehavior_behavioredClassifier
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_classifier_createObjectAction
    *
    * @param end1 A_classifier_createObjectAction::createObjectAction: CreateObjectAction [0..*] { unordered, unique, reference }
    * @param end2 CreateObjectAction::classifier: Classifier [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_classifier_createObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_classifier_instanceSpecification
    *
    * @param end1 A_classifier_instanceSpecification::instanceSpecification: InstanceSpecification [0..*] { unordered, unique, reference }
    * @param end2 InstanceSpecification::classifier: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_classifier_instanceSpecification
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_classifier_readExtentAction
    *
    * @param end1 A_classifier_readExtentAction::readExtentAction: ReadExtentAction [0..1] { unordered, unique, reference }
    * @param end2 ReadExtentAction::classifier: Classifier [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_classifier_readExtentAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_classifier_readIsClassifiedObjectAction
    *
    * @param end1 A_classifier_readIsClassifiedObjectAction::readIsClassifiedObjectAction: ReadIsClassifiedObjectAction [0..*] { unordered, unique, reference }
    * @param end2 ReadIsClassifiedObjectAction::classifier: Classifier [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_classifier_readIsClassifiedObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_classifier_templateParameter_parameteredElement
    *
    * @param end1 ClassifierTemplateParameter::parameteredElement: Classifier [1..1] { unordered, unique, reference }
    * @param end2 Classifier::templateParameter: ClassifierTemplateParameter [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_classifier_templateParameter_parameteredElement
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_clientDependency_client
    *
    * @param end1 NamedElement::clientDependency: Dependency [0..*] { unordered, unique, reference }
    * @param end2 Dependency::client: NamedElement [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_clientDependency_client
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_collaborationRole_collaboration
    *
    * @param end1 A_collaborationRole_collaboration::collaboration: Collaboration [0..*] { unordered, unique, reference }
    * @param end2 Collaboration::collaborationRole: ConnectableElement [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_collaborationRole_collaboration
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_connectableElement_templateParameter_parameteredElement
    *
    * @param end1 ConnectableElement::templateParameter: ConnectableElementTemplateParameter [0..1] { unordered, unique, reference }
    * @param end2 ConnectableElementTemplateParameter::parameteredElement: ConnectableElement [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_connectableElement_templateParameter_parameteredElement
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_connector_message
    *
    * @param end1 A_connector_message::message: Message [0..*] { unordered, unique, reference }
    * @param end2 Message::connector: Connector [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_connector_message
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_constrainedElement_constraint
    *
    * @param end1 A_constrainedElement_constraint::constraint: Constraint [0..*] { unordered, unique, reference }
    * @param end2 Constraint::constrainedElement: Element [0..*] { ordered, unique, reference }
    */
  case class OTIUMLA_constrainedElement_constraint
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_constrainingClassifier_classifierTemplateParameter
    *
    * @param end1 A_constrainingClassifier_classifierTemplateParameter::classifierTemplateParameter: ClassifierTemplateParameter [0..*] { unordered, unique, reference }
    * @param end2 ClassifierTemplateParameter::constrainingClassifier: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_constrainingClassifier_classifierTemplateParameter
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_contract_connector
    *
    * @param end1 A_contract_connector::connector: Connector [0..*] { unordered, unique, reference }
    * @param end2 Connector::contract: Behavior [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_contract_connector
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_contract_interfaceRealization
    *
    * @param end1 A_contract_interfaceRealization::interfaceRealization: InterfaceRealization [0..*] { unordered, unique, reference }
    * @param end2 InterfaceRealization::contract: Interface [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_contract_interfaceRealization
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_contract_substitution
    *
    * @param end1 A_contract_substitution::substitution: Substitution [0..*] { unordered, unique, reference }
    * @param end2 Substitution::contract: Classifier [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_contract_substitution
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_conveyed_conveyingFlow
    *
    * @param end1 A_conveyed_conveyingFlow::conveyingFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param end2 InformationFlow::conveyed: Classifier [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_conveyed_conveyingFlow
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_covered_coveredBy
    *
    * @param end1 InteractionFragment::covered: Lifeline [0..*] { unordered, unique, reference }
    * @param end2 Lifeline::coveredBy: InteractionFragment [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_covered_coveredBy
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_covered_events
    *
    * @param end1 A_covered_events::events: OccurrenceSpecification [0..*] { ordered, unique, reference }
    * @param end2 OccurrenceSpecification::covered: Lifeline [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_covered_events
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end1Index: Int,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFFirstEndOrderedLink
  {}

  /**
    * A_covered_stateInvariant
    *
    * @param end1 A_covered_stateInvariant::stateInvariant: StateInvariant [0..*] { unordered, unique, reference }
    * @param end2 StateInvariant::covered: Lifeline [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_covered_stateInvariant
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_decider_clause
    *
    * @param end1 A_decider_clause::clause: Clause [0..1] { unordered, unique, reference }
    * @param end2 Clause::decider: OutputPin [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_decider_clause
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_decider_loopNode
    *
    * @param end1 A_decider_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param end2 LoopNode::decider: OutputPin [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_decider_loopNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_decisionInputFlow_decisionNode
    *
    * @param end1 A_decisionInputFlow_decisionNode::decisionNode: DecisionNode [0..1] { unordered, unique, reference }
    * @param end2 DecisionNode::decisionInputFlow: ObjectFlow [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_decisionInputFlow_decisionNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_decisionInput_decisionNode
    *
    * @param end1 A_decisionInput_decisionNode::decisionNode: DecisionNode [0..*] { unordered, unique, reference }
    * @param end2 DecisionNode::decisionInput: Behavior [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_decisionInput_decisionNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_decomposedAs_lifeline
    *
    * @param end1 A_decomposedAs_lifeline::lifeline: Lifeline [1..1] { unordered, unique, reference }
    * @param end2 Lifeline::decomposedAs: PartDecomposition [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_decomposedAs_lifeline
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_default_templateParameter
    *
    * @param end1 A_default_templateParameter::templateParameter: TemplateParameter [0..*] { unordered, unique, reference }
    * @param end2 TemplateParameter::default: ParameterableElement [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_default_templateParameter
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_definingFeature_slot
    *
    * @param end1 A_definingFeature_slot::slot: Slot [0..*] { unordered, unique, reference }
    * @param end2 Slot::definingFeature: StructuralFeature [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_definingFeature_slot
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_deployedArtifact_deploymentForArtifact
    *
    * @param end1 A_deployedArtifact_deploymentForArtifact::deploymentForArtifact: Deployment [0..*] { unordered, unique, reference }
    * @param end2 Deployment::deployedArtifact: DeployedArtifact [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_deployedArtifact_deploymentForArtifact
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_destroyAt_linkEndDestructionData
    *
    * @param end1 A_destroyAt_linkEndDestructionData::linkEndDestructionData: LinkEndDestructionData [0..1] { unordered, unique, reference }
    * @param end2 LinkEndDestructionData::destroyAt: InputPin [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_destroyAt_linkEndDestructionData
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_edge_inPartition
    *
    * @param end1 ActivityPartition::edge: ActivityEdge [0..*] { unordered, unique, reference }
    * @param end2 ActivityEdge::inPartition: ActivityPartition [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_edge_inPartition
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_end_linkEndData
    *
    * @param end1 A_end_linkEndData::linkEndData: LinkEndData [0..*] { unordered, unique, reference }
    * @param end2 LinkEndData::end: Property [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_end_linkEndData
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_end_readLinkObjectEndAction
    *
    * @param end1 A_end_readLinkObjectEndAction::readLinkObjectEndAction: ReadLinkObjectEndAction [0..1] { unordered, unique, reference }
    * @param end2 ReadLinkObjectEndAction::end: Property [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_end_readLinkObjectEndAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_end_role
    *
    * @param end1 ConnectableElement::end: ConnectorEnd [0..*] { unordered, unique, reference }
    * @param end2 ConnectorEnd::role: ConnectableElement [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_end_role
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_entry_connectionPointReference
    *
    * @param end1 A_entry_connectionPointReference::connectionPointReference: ConnectionPointReference [0..1] { unordered, unique, reference }
    * @param end2 ConnectionPointReference::entry: Pseudostate [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_entry_connectionPointReference
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_event_durationObservation
    *
    * @param end1 A_event_durationObservation::durationObservation: DurationObservation [0..*] { unordered, unique, reference }
    * @param end2 DurationObservation::event: NamedElement [1..2] { ordered, unique, reference }
    */
  case class OTIUMLA_event_durationObservation
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_event_timeObservation
    *
    * @param end1 A_event_timeObservation::timeObservation: TimeObservation [0..*] { unordered, unique, reference }
    * @param end2 TimeObservation::event: NamedElement [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_event_timeObservation
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_event_trigger
    *
    * @param end1 A_event_trigger::trigger: Trigger [0..*] { unordered, unique, reference }
    * @param end2 Trigger::event: Event [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_event_trigger
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_exceptionInput_exceptionHandler
    *
    * @param end1 A_exceptionInput_exceptionHandler::exceptionHandler: ExceptionHandler [0..*] { unordered, unique, reference }
    * @param end2 ExceptionHandler::exceptionInput: ObjectNode [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_exceptionInput_exceptionHandler
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_exceptionType_exceptionHandler
    *
    * @param end1 A_exceptionType_exceptionHandler::exceptionHandler: ExceptionHandler [0..*] { unordered, unique, reference }
    * @param end2 ExceptionHandler::exceptionType: Classifier [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_exceptionType_exceptionHandler
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_execution_executionOccurrenceSpecification
    *
    * @param end1 A_execution_executionOccurrenceSpecification::executionOccurrenceSpecification: ExecutionOccurrenceSpecification [0..2] { unordered, unique, reference }
    * @param end2 ExecutionOccurrenceSpecification::execution: ExecutionSpecification [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_execution_executionOccurrenceSpecification
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_exit_connectionPointReference
    *
    * @param end1 A_exit_connectionPointReference::connectionPointReference: ConnectionPointReference [0..1] { unordered, unique, reference }
    * @param end2 ConnectionPointReference::exit: Pseudostate [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_exit_connectionPointReference
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_extendedCase_extend
    *
    * @param end1 A_extendedCase_extend::extend: Extend [0..*] { unordered, unique, reference }
    * @param end2 Extend::extendedCase: UseCase [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_extendedCase_extend
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_extendedRegion_region
    *
    * @param end1 A_extendedRegion_region::region: Region [0..*] { unordered, unique, reference }
    * @param end2 Region::extendedRegion: Region [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_extendedRegion_region
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_extendedSignature_redefinableTemplateSignature
    *
    * @param end1 A_extendedSignature_redefinableTemplateSignature::redefinableTemplateSignature: RedefinableTemplateSignature [0..*] { unordered, unique, reference }
    * @param end2 RedefinableTemplateSignature::extendedSignature: RedefinableTemplateSignature [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_extendedSignature_redefinableTemplateSignature
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_extendedStateMachine_stateMachine
    *
    * @param end1 A_extendedStateMachine_stateMachine::stateMachine: StateMachine [0..*] { unordered, unique, reference }
    * @param end2 StateMachine::extendedStateMachine: StateMachine [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_extendedStateMachine_stateMachine
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_extensionLocation_extension
    *
    * @param end1 A_extensionLocation_extension::extension: Extend [0..*] { unordered, unique, reference }
    * @param end2 Extend::extensionLocation: ExtensionPoint [1..*] { ordered, unique, reference }
    */
  case class OTIUMLA_extensionLocation_extension
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_finish_executionSpecification
    *
    * @param end1 A_finish_executionSpecification::executionSpecification: ExecutionSpecification [0..*] { unordered, unique, reference }
    * @param end2 ExecutionSpecification::finish: OccurrenceSpecification [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_finish_executionSpecification
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_formal_templateParameterSubstitution
    *
    * @param end1 A_formal_templateParameterSubstitution::templateParameterSubstitution: TemplateParameterSubstitution [0..*] { unordered, unique, reference }
    * @param end2 TemplateParameterSubstitution::formal: TemplateParameter [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_formal_templateParameterSubstitution
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_generalMachine_protocolConformance
    *
    * @param end1 A_generalMachine_protocolConformance::protocolConformance: ProtocolConformance [0..*] { unordered, unique, reference }
    * @param end2 ProtocolConformance::generalMachine: ProtocolStateMachine [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_generalMachine_protocolConformance
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_general_generalization
    *
    * @param end1 A_general_generalization::generalization: Generalization [0..*] { unordered, unique, reference }
    * @param end2 Generalization::general: Classifier [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_general_generalization
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_generalizationSet_generalization
    *
    * @param end1 Generalization::generalizationSet: GeneralizationSet [0..*] { unordered, unique, reference }
    * @param end2 GeneralizationSet::generalization: Generalization [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_generalizationSet_generalization
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_handlerBody_exceptionHandler
    *
    * @param end1 A_handlerBody_exceptionHandler::exceptionHandler: ExceptionHandler [0..*] { unordered, unique, reference }
    * @param end2 ExceptionHandler::handlerBody: ExecutableNode [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_handlerBody_exceptionHandler
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_importedElement_import
    *
    * @param end1 A_importedElement_import::import: ElementImport [0..*] { unordered, unique, reference }
    * @param end2 ElementImport::importedElement: PackageableElement [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_importedElement_import
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_importedPackage_packageImport
    *
    * @param end1 A_importedPackage_packageImport::packageImport: PackageImport [0..*] { unordered, unique, reference }
    * @param end2 PackageImport::importedPackage: Package [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_importedPackage_packageImport
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_inInterruptibleRegion_node
    *
    * @param end1 ActivityNode::inInterruptibleRegion: InterruptibleActivityRegion [0..*] { unordered, unique, reference }
    * @param end2 InterruptibleActivityRegion::node: ActivityNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_inInterruptibleRegion_node
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_inPartition_node
    *
    * @param end1 ActivityPartition::node: ActivityNode [0..*] { unordered, unique, reference }
    * @param end2 ActivityNode::inPartition: ActivityPartition [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_inPartition_node
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_inState_objectNode
    *
    * @param end1 A_inState_objectNode::objectNode: ObjectNode [0..*] { unordered, unique, reference }
    * @param end2 ObjectNode::inState: State [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_inState_objectNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_incoming_target_node
    *
    * @param end1 ActivityEdge::target: ActivityNode [1..1] { unordered, unique, reference }
    * @param end2 ActivityNode::incoming: ActivityEdge [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_incoming_target_node
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_incoming_target_vertex
    *
    * @param end1 Vertex::incoming: Transition [0..*] { unordered, unique, reference }
    * @param end2 Transition::target: Vertex [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_incoming_target_vertex
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_informationSource_informationFlow
    *
    * @param end1 A_informationSource_informationFlow::informationFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param end2 InformationFlow::informationSource: NamedElement [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_informationSource_informationFlow
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_informationTarget_informationFlow
    *
    * @param end1 A_informationTarget_informationFlow::informationFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param end2 InformationFlow::informationTarget: NamedElement [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_informationTarget_informationFlow
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_inputElement_regionAsInput
    *
    * @param end1 ExpansionNode::regionAsInput: ExpansionRegion [0..1] { unordered, unique, reference }
    * @param end2 ExpansionRegion::inputElement: ExpansionNode [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_inputElement_regionAsInput
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_insertAt_linkEndCreationData
    *
    * @param end1 A_insertAt_linkEndCreationData::linkEndCreationData: LinkEndCreationData [0..1] { unordered, unique, reference }
    * @param end2 LinkEndCreationData::insertAt: InputPin [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_insertAt_linkEndCreationData
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_instance_instanceValue
    *
    * @param end1 A_instance_instanceValue::instanceValue: InstanceValue [0..*] { unordered, unique, reference }
    * @param end2 InstanceValue::instance: InstanceSpecification [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_instance_instanceValue
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_interruptingEdge_interrupts
    *
    * @param end1 ActivityEdge::interrupts: InterruptibleActivityRegion [0..1] { unordered, unique, reference }
    * @param end2 InterruptibleActivityRegion::interruptingEdge: ActivityEdge [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_interruptingEdge_interrupts
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_max_durationInterval
    *
    * @param end1 A_max_durationInterval::durationInterval: DurationInterval [0..*] { unordered, unique, reference }
    * @param end2 DurationInterval::max: Duration [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_max_durationInterval
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_max_interval
    *
    * @param end1 A_max_interval::interval: Interval [0..*] { unordered, unique, reference }
    * @param end2 Interval::max: ValueSpecification [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_max_interval
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_max_timeInterval
    *
    * @param end1 A_max_timeInterval::timeInterval: TimeInterval [0..*] { unordered, unique, reference }
    * @param end2 TimeInterval::max: TimeExpression [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_max_timeInterval
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_memberEnd_association
    *
    * @param end1 Property::association: Association [0..1] { unordered, unique, reference }
    * @param end2 Association::memberEnd: Property [2..*] { ordered, unique, reference }
    */
  case class OTIUMLA_memberEnd_association
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_mergedPackage_packageMerge
    *
    * @param end1 A_mergedPackage_packageMerge::packageMerge: PackageMerge [0..*] { unordered, unique, reference }
    * @param end2 PackageMerge::mergedPackage: Package [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_mergedPackage_packageMerge
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_message_considerIgnoreFragment
    *
    * @param end1 A_message_considerIgnoreFragment::considerIgnoreFragment: ConsiderIgnoreFragment [0..*] { unordered, unique, reference }
    * @param end2 ConsiderIgnoreFragment::message: NamedElement [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_message_considerIgnoreFragment
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_message_messageEnd
    *
    * @param end1 A_message_messageEnd::messageEnd: MessageEnd [0..2] { unordered, unique, reference }
    * @param end2 MessageEnd::message: Message [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_message_messageEnd
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_method_specification
    *
    * @param end1 BehavioralFeature::method: Behavior [0..*] { unordered, unique, reference }
    * @param end2 Behavior::specification: BehavioralFeature [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_method_specification
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_min_durationInterval
    *
    * @param end1 A_min_durationInterval::durationInterval: DurationInterval [0..*] { unordered, unique, reference }
    * @param end2 DurationInterval::min: Duration [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_min_durationInterval
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_min_interval
    *
    * @param end1 A_min_interval::interval: Interval [0..*] { unordered, unique, reference }
    * @param end2 Interval::min: ValueSpecification [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_min_interval
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_min_timeInterval
    *
    * @param end1 A_min_timeInterval::timeInterval: TimeInterval [0..*] { unordered, unique, reference }
    * @param end2 TimeInterval::min: TimeExpression [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_min_timeInterval
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_navigableOwnedEnd_association
    *
    * @param end1 A_navigableOwnedEnd_association::association: Association [0..1] { unordered, unique, reference }
    * @param end2 Association::navigableOwnedEnd: Property [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_navigableOwnedEnd_association
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_newClassifier_reclassifyObjectAction
    *
    * @param end1 A_newClassifier_reclassifyObjectAction::reclassifyObjectAction: ReclassifyObjectAction [0..*] { unordered, unique, reference }
    * @param end2 ReclassifyObjectAction::newClassifier: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_newClassifier_reclassifyObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_observation_duration
    *
    * @param end1 A_observation_duration::duration: Duration [0..1] { unordered, unique, reference }
    * @param end2 Duration::observation: Observation [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_observation_duration
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_observation_timeExpression
    *
    * @param end1 A_observation_timeExpression::timeExpression: TimeExpression [0..1] { unordered, unique, reference }
    * @param end2 TimeExpression::observation: Observation [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_observation_timeExpression
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_oldClassifier_reclassifyObjectAction
    *
    * @param end1 A_oldClassifier_reclassifyObjectAction::reclassifyObjectAction: ReclassifyObjectAction [0..*] { unordered, unique, reference }
    * @param end2 ReclassifyObjectAction::oldClassifier: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_oldClassifier_reclassifyObjectAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_onPort_invocationAction
    *
    * @param end1 A_onPort_invocationAction::invocationAction: InvocationAction [0..*] { unordered, unique, reference }
    * @param end2 InvocationAction::onPort: Port [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_onPort_invocationAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_operation_callEvent
    *
    * @param end1 A_operation_callEvent::callEvent: CallEvent [0..*] { unordered, unique, reference }
    * @param end2 CallEvent::operation: Operation [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_operation_callEvent
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_operation_callOperationAction
    *
    * @param end1 A_operation_callOperationAction::callOperationAction: CallOperationAction [0..*] { unordered, unique, reference }
    * @param end2 CallOperationAction::operation: Operation [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_operation_callOperationAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_operation_templateParameter_parameteredElement
    *
    * @param end1 Operation::templateParameter: OperationTemplateParameter [0..1] { unordered, unique, reference }
    * @param end2 OperationTemplateParameter::parameteredElement: Operation [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_operation_templateParameter_parameteredElement
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_outgoing_source_node
    *
    * @param end1 ActivityEdge::source: ActivityNode [1..1] { unordered, unique, reference }
    * @param end2 ActivityNode::outgoing: ActivityEdge [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_outgoing_source_node
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_outgoing_source_vertex
    *
    * @param end1 Vertex::outgoing: Transition [0..*] { unordered, unique, reference }
    * @param end2 Transition::source: Vertex [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_outgoing_source_vertex
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_outputElement_regionAsOutput
    *
    * @param end1 ExpansionNode::regionAsOutput: ExpansionRegion [0..1] { unordered, unique, reference }
    * @param end2 ExpansionRegion::outputElement: ExpansionNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_outputElement_regionAsOutput
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_parameterSet_parameter
    *
    * @param end1 Parameter::parameterSet: ParameterSet [0..*] { unordered, unique, reference }
    * @param end2 ParameterSet::parameter: Parameter [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_parameterSet_parameter
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_parameter_activityParameterNode
    *
    * @param end1 A_parameter_activityParameterNode::activityParameterNode: ActivityParameterNode [0..*] { unordered, unique, reference }
    * @param end2 ActivityParameterNode::parameter: Parameter [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_parameter_activityParameterNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_parameter_templateSignature
    *
    * @param end1 A_parameter_templateSignature::templateSignature: TemplateSignature [0..*] { unordered, unique, reference }
    * @param end2 TemplateSignature::parameter: TemplateParameter [1..*] { ordered, unique, reference }
    */
  case class OTIUMLA_parameter_templateSignature
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL,
    override val end2Index: Int )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSecondEndOrderedLink
  {}

  /**
    * A_parameteredElement_templateParameter
    *
    * @param end1 TemplateParameter::parameteredElement: ParameterableElement [1..1] { unordered, unique, reference }
    * @param end2 ParameterableElement::templateParameter: TemplateParameter [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_parameteredElement_templateParameter
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_partWithPort_connectorEnd
    *
    * @param end1 A_partWithPort_connectorEnd::connectorEnd: ConnectorEnd [0..*] { unordered, unique, reference }
    * @param end2 ConnectorEnd::partWithPort: Property [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_partWithPort_connectorEnd
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_partition_activity
    *
    * @param end1 A_partition_activity::activity: Activity [0..1] { unordered, unique, reference }
    * @param end2 Activity::partition: ActivityPartition [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_partition_activity
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_port_trigger
    *
    * @param end1 A_port_trigger::trigger: Trigger [0..*] { unordered, unique, reference }
    * @param end2 Trigger::port: Port [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_port_trigger
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_powertypeExtent_powertype
    *
    * @param end1 GeneralizationSet::powertype: Classifier [0..1] { unordered, unique, reference }
    * @param end2 Classifier::powertypeExtent: GeneralizationSet [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_powertypeExtent_powertype
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_predecessorClause_successorClause
    *
    * @param end1 Clause::predecessorClause: Clause [0..*] { unordered, unique, reference }
    * @param end2 Clause::successorClause: Clause [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_predecessorClause_successorClause
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_protocol_port
    *
    * @param end1 A_protocol_port::port: Port [0..*] { unordered, unique, reference }
    * @param end2 Port::protocol: ProtocolStateMachine [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_protocol_port
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_qualifier_qualifierValue
    *
    * @param end1 A_qualifier_qualifierValue::qualifierValue: QualifierValue [0..*] { unordered, unique, reference }
    * @param end2 QualifierValue::qualifier: Property [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_qualifier_qualifierValue
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_qualifier_readLinkObjectEndQualifierAction
    *
    * @param end1 A_qualifier_readLinkObjectEndQualifierAction::readLinkObjectEndQualifierAction: ReadLinkObjectEndQualifierAction [0..1] { unordered, unique, reference }
    * @param end2 ReadLinkObjectEndQualifierAction::qualifier: Property [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_qualifier_readLinkObjectEndQualifierAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_raisedException_behavioralFeature
    *
    * @param end1 A_raisedException_behavioralFeature::behavioralFeature: BehavioralFeature [0..*] { unordered, unique, reference }
    * @param end2 BehavioralFeature::raisedException: Type [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_raisedException_behavioralFeature
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_raisedException_operation
    *
    * @param end1 A_raisedException_operation::operation: Operation [0..*] { unordered, unique, reference }
    * @param end2 Operation::raisedException: Type [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_raisedException_operation
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_realization_abstraction_flow
    *
    * @param end1 A_realization_abstraction_flow::abstraction: InformationFlow [0..*] { unordered, unique, reference }
    * @param end2 InformationFlow::realization: Relationship [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_realization_abstraction_flow
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_realizingActivityEdge_informationFlow
    *
    * @param end1 A_realizingActivityEdge_informationFlow::informationFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param end2 InformationFlow::realizingActivityEdge: ActivityEdge [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_realizingActivityEdge_informationFlow
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_realizingClassifier_componentRealization
    *
    * @param end1 A_realizingClassifier_componentRealization::componentRealization: ComponentRealization [0..*] { unordered, unique, reference }
    * @param end2 ComponentRealization::realizingClassifier: Classifier [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_realizingClassifier_componentRealization
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_realizingConnector_informationFlow
    *
    * @param end1 A_realizingConnector_informationFlow::informationFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param end2 InformationFlow::realizingConnector: Connector [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_realizingConnector_informationFlow
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_realizingMessage_informationFlow
    *
    * @param end1 A_realizingMessage_informationFlow::informationFlow: InformationFlow [0..*] { unordered, unique, reference }
    * @param end2 InformationFlow::realizingMessage: Message [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_realizingMessage_informationFlow
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_receiveEvent_endMessage
    *
    * @param end1 A_receiveEvent_endMessage::endMessage: Message [0..1] { unordered, unique, reference }
    * @param end2 Message::receiveEvent: MessageEnd [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_receiveEvent_endMessage
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_redefinedBehavior_behavior
    *
    * @param end1 A_redefinedBehavior_behavior::behavior: Behavior [0..*] { unordered, unique, reference }
    * @param end2 Behavior::redefinedBehavior: Behavior [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedBehavior_behavior
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_redefinedClassifier_classifier
    *
    * @param end1 A_redefinedClassifier_classifier::classifier: Classifier [0..*] { unordered, unique, reference }
    * @param end2 Classifier::redefinedClassifier: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedClassifier_classifier
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_redefinedConnector_connector
    *
    * @param end1 A_redefinedConnector_connector::connector: Connector [0..*] { unordered, unique, reference }
    * @param end2 Connector::redefinedConnector: Connector [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedConnector_connector
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_redefinedEdge_activityEdge
    *
    * @param end1 A_redefinedEdge_activityEdge::activityEdge: ActivityEdge [0..*] { unordered, unique, reference }
    * @param end2 ActivityEdge::redefinedEdge: ActivityEdge [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedEdge_activityEdge
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_redefinedInterface_interface
    *
    * @param end1 A_redefinedInterface_interface::interface: Interface [0..*] { unordered, unique, reference }
    * @param end2 Interface::redefinedInterface: Interface [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedInterface_interface
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_redefinedNode_activityNode
    *
    * @param end1 A_redefinedNode_activityNode::activityNode: ActivityNode [0..*] { unordered, unique, reference }
    * @param end2 ActivityNode::redefinedNode: ActivityNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedNode_activityNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_redefinedOperation_operation
    *
    * @param end1 A_redefinedOperation_operation::operation: Operation [0..*] { unordered, unique, reference }
    * @param end2 Operation::redefinedOperation: Operation [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedOperation_operation
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_redefinedPort_port
    *
    * @param end1 A_redefinedPort_port::port: Port [0..*] { unordered, unique, reference }
    * @param end2 Port::redefinedPort: Port [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedPort_port
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_redefinedProperty_property
    *
    * @param end1 A_redefinedProperty_property::property: Property [0..*] { unordered, unique, reference }
    * @param end2 Property::redefinedProperty: Property [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedProperty_property
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_redefinedState_state
    *
    * @param end1 A_redefinedState_state::state: State [0..*] { unordered, unique, reference }
    * @param end2 State::redefinedState: State [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedState_state
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_redefinedTransition_transition
    *
    * @param end1 A_redefinedTransition_transition::transition: Transition [0..*] { unordered, unique, reference }
    * @param end2 Transition::redefinedTransition: Transition [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_redefinedTransition_transition
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_reducer_reduceAction
    *
    * @param end1 A_reducer_reduceAction::reduceAction: ReduceAction [0..*] { unordered, unique, reference }
    * @param end2 ReduceAction::reducer: Behavior [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_reducer_reduceAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_refersTo_interactionUse
    *
    * @param end1 A_refersTo_interactionUse::interactionUse: InteractionUse [0..*] { unordered, unique, reference }
    * @param end2 InteractionUse::refersTo: Interaction [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_refersTo_interactionUse
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_replyToCall_replyAction
    *
    * @param end1 A_replyToCall_replyAction::replyAction: ReplyAction [0..1] { unordered, unique, reference }
    * @param end2 ReplyAction::replyToCall: Trigger [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_replyToCall_replyAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_representation_classifier
    *
    * @param end1 A_representation_classifier::classifier: Classifier [0..1] { unordered, unique, reference }
    * @param end2 Classifier::representation: CollaborationUse [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_representation_classifier
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_represented_representation
    *
    * @param end1 A_represented_representation::representation: InformationItem [0..*] { unordered, unique, reference }
    * @param end2 InformationItem::represented: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_represented_representation
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_represents_activityPartition
    *
    * @param end1 A_represents_activityPartition::activityPartition: ActivityPartition [0..*] { unordered, unique, reference }
    * @param end2 ActivityPartition::represents: Element [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_represents_activityPartition
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_represents_lifeline
    *
    * @param end1 A_represents_lifeline::lifeline: Lifeline [0..*] { unordered, unique, reference }
    * @param end2 Lifeline::represents: ConnectableElement [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_represents_lifeline
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_returnValueRecipient_interactionUse
    *
    * @param end1 A_returnValueRecipient_interactionUse::interactionUse: InteractionUse [0..*] { unordered, unique, reference }
    * @param end2 InteractionUse::returnValueRecipient: Property [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_returnValueRecipient_interactionUse
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_selection_objectFlow
    *
    * @param end1 A_selection_objectFlow::objectFlow: ObjectFlow [0..*] { unordered, unique, reference }
    * @param end2 ObjectFlow::selection: Behavior [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_selection_objectFlow
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_selection_objectNode
    *
    * @param end1 A_selection_objectNode::objectNode: ObjectNode [0..*] { unordered, unique, reference }
    * @param end2 ObjectNode::selection: Behavior [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_selection_objectNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_sendEvent_endMessage
    *
    * @param end1 A_sendEvent_endMessage::endMessage: Message [0..1] { unordered, unique, reference }
    * @param end2 Message::sendEvent: MessageEnd [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_sendEvent_endMessage
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_setupPart_loopNode
    *
    * @param end1 A_setupPart_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param end2 LoopNode::setupPart: ExecutableNode [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_setupPart_loopNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_signal_broadcastSignalAction
    *
    * @param end1 A_signal_broadcastSignalAction::broadcastSignalAction: BroadcastSignalAction [0..*] { unordered, unique, reference }
    * @param end2 BroadcastSignalAction::signal: Signal [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_signal_broadcastSignalAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_signal_reception
    *
    * @param end1 A_signal_reception::reception: Reception [0..*] { unordered, unique, reference }
    * @param end2 Reception::signal: Signal [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_signal_reception
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_signal_sendSignalAction
    *
    * @param end1 A_signal_sendSignalAction::sendSignalAction: SendSignalAction [0..*] { unordered, unique, reference }
    * @param end2 SendSignalAction::signal: Signal [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_signal_sendSignalAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_signal_signalEvent
    *
    * @param end1 A_signal_signalEvent::signalEvent: SignalEvent [0..*] { unordered, unique, reference }
    * @param end2 SignalEvent::signal: Signal [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_signal_signalEvent
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_signature_message
    *
    * @param end1 A_signature_message::message: Message [0..*] { unordered, unique, reference }
    * @param end2 Message::signature: NamedElement [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_signature_message
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_signature_templateBinding
    *
    * @param end1 A_signature_templateBinding::templateBinding: TemplateBinding [0..*] { unordered, unique, reference }
    * @param end2 TemplateBinding::signature: TemplateSignature [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_signature_templateBinding
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_start_executionSpecification
    *
    * @param end1 A_start_executionSpecification::executionSpecification: ExecutionSpecification [0..*] { unordered, unique, reference }
    * @param end2 ExecutionSpecification::start: OccurrenceSpecification [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_start_executionSpecification
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_structuralFeature_structuralFeatureAction
    *
    * @param end1 A_structuralFeature_structuralFeatureAction::structuralFeatureAction: StructuralFeatureAction [0..*] { unordered, unique, reference }
    * @param end2 StructuralFeatureAction::structuralFeature: StructuralFeature [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_structuralFeature_structuralFeatureAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_subject_useCase
    *
    * @param end1 Classifier::useCase: UseCase [0..*] { unordered, unique, reference }
    * @param end2 UseCase::subject: Classifier [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_subject_useCase
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_submachineState_submachine
    *
    * @param end1 State::submachine: StateMachine [0..1] { unordered, unique, reference }
    * @param end2 StateMachine::submachineState: State [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_submachineState_submachine
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_subsettedProperty_property
    *
    * @param end1 A_subsettedProperty_property::property: Property [0..*] { unordered, unique, reference }
    * @param end2 Property::subsettedProperty: Property [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_subsettedProperty_property
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_supplier_supplierDependency
    *
    * @param end1 A_supplier_supplierDependency::supplierDependency: Dependency [0..*] { unordered, unique, reference }
    * @param end2 Dependency::supplier: NamedElement [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_supplier_supplierDependency
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_test_clause
    *
    * @param end1 A_test_clause::clause: Clause [0..1] { unordered, unique, reference }
    * @param end2 Clause::test: ExecutableNode [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_test_clause
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_test_loopNode
    *
    * @param end1 A_test_loopNode::loopNode: LoopNode [0..1] { unordered, unique, reference }
    * @param end2 LoopNode::test: ExecutableNode [1..*] { unordered, unique, reference }
    */
  case class OTIUMLA_test_loopNode
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_toBefore_after
    *
    * @param end1 GeneralOrdering::after: OccurrenceSpecification [1..1] { unordered, unique, reference }
    * @param end2 OccurrenceSpecification::toBefore: GeneralOrdering [0..*] { unordered, unique, reference }
    */
  case class OTIUMLA_toBefore_after
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_transformation_objectFlow
    *
    * @param end1 A_transformation_objectFlow::objectFlow: ObjectFlow [0..*] { unordered, unique, reference }
    * @param end2 ObjectFlow::transformation: Behavior [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_transformation_objectFlow
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_type_collaborationUse
    *
    * @param end1 A_type_collaborationUse::collaborationUse: CollaborationUse [0..*] { unordered, unique, reference }
    * @param end2 CollaborationUse::type: Collaboration [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_type_collaborationUse
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_type_connector
    *
    * @param end1 A_type_connector::connector: Connector [0..*] { unordered, unique, reference }
    * @param end2 Connector::type: Association [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_type_connector
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_type_extensionEnd
    *
    * @param end1 A_type_extensionEnd::extensionEnd: ExtensionEnd [0..*] { unordered, unique, reference }
    * @param end2 ExtensionEnd::type: Stereotype [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_type_extensionEnd
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_type_typedElement
    *
    * @param end1 A_type_typedElement::typedElement: TypedElement [0..*] { unordered, unique, reference }
    * @param end2 TypedElement::type: Type [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_type_typedElement
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_unmarshallType_unmarshallAction
    *
    * @param end1 A_unmarshallType_unmarshallAction::unmarshallAction: UnmarshallAction [0..*] { unordered, unique, reference }
    * @param end2 UnmarshallAction::unmarshallType: Classifier [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_unmarshallType_unmarshallAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_utilizedElement_manifestation
    *
    * @param end1 A_utilizedElement_manifestation::manifestation: Manifestation [0..*] { unordered, unique, reference }
    * @param end2 Manifestation::utilizedElement: PackageableElement [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_utilizedElement_manifestation
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_value_linkEndData
    *
    * @param end1 A_value_linkEndData::linkEndData: LinkEndData [0..1] { unordered, unique, reference }
    * @param end2 LinkEndData::value: InputPin [0..1] { unordered, unique, reference }
    */
  case class OTIUMLA_value_linkEndData
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_value_qualifierValue
    *
    * @param end1 A_value_qualifierValue::qualifierValue: QualifierValue [0..1] { unordered, unique, reference }
    * @param end2 QualifierValue::value: InputPin [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_value_qualifierValue
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * A_variable_variableAction
    *
    * @param end1 A_variable_variableAction::variableAction: VariableAction [0..*] { unordered, unique, reference }
    * @param end2 VariableAction::variable: Variable [1..1] { unordered, unique, reference }
    */
  case class OTIUMLA_variable_variableAction
  ( override val end1: ToolSpecificElementDocumentURL,
    override val end2: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

}
