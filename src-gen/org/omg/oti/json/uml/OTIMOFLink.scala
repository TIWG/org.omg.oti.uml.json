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
  * <!-- End of user code OTIMOFLink -->
  */
sealed trait OTIMOFLink {

  def source: ToolSpecificElementDocumentURL
  def target: ToolSpecificElementDocumentURL

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
  * <!-- Start of user code OTIMOFSourceOrderedLink -->
  * A MOF link for an association where the source end is ordered & the target end is unordered
  * <!-- End of user code OTIMOFSourceOrderedLink -->
  */
sealed trait OTIMOFSourceOrderedLink {
  def sourceIndex: Int
}

/**
  * <!-- Start of user code OTIMOFTargetOrderedLink -->
  * A MOF link for an association where the source end is unordered & the target end is ordered
  * <!-- End of user code OTIMOFTargetOrderedLink -->
  */
sealed trait OTIMOFTargetOrderedLink {
  def targetIndex: Int
}

object OTIMOFLink {
  
  /**
    * @param: source mapping: OpaqueExpression ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target abstraction: Abstraction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_mapping_abstraction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source returnInformation: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target acceptCallAction: AcceptCallAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_returnInformation_acceptCallAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target acceptEventAction: AcceptEventAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_acceptEventAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source trigger: Trigger ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
    * @param: target acceptEventAction: AcceptEventAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_trigger_acceptEventAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source localPostcondition: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target action: Action ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_localPostcondition_action
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source localPrecondition: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target action: Action ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_localPrecondition_action
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source fromAction: Action ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target actionInputPin: ActionInputPin ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_fromAction_actionInputPin
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source edge: ActivityEdge ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target activity: Activity ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_edge_activity
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source group: ActivityGroup ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target inActivity: Activity ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_group_inActivity
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source node: ActivityNode ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target activity: Activity ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_node_activity
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source variable: Variable ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target activityScope: Activity ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_variable_activityScope
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source guard: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target activityEdge: ActivityEdge ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_guard_activityEdge
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source weight: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target activityEdge: ActivityEdge ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_weight_activityEdge
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source subpartition: ActivityPartition ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target superPartition: ActivityPartition ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_subpartition_superPartition
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source insertAt: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target addStructuralFeatureValueAction: AddStructuralFeatureValueAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_insertAt_addStructuralFeatureValueAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source insertAt: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target addVariableValueAction: AddVariableValueAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_insertAt_addVariableValueAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source manifestation: Manifestation ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target artifact: Artifact ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_manifestation_artifact
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source nestedArtifact: Artifact ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target artifact: Artifact ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_nestedArtifact_artifact
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedAttribute: Property ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target artifact: Artifact ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedAttribute_artifact
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedOperation: Operation ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target artifact: Artifact ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedOperation_artifact
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedEnd: Property ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target owningAssociation: Association ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedEnd_owningAssociation
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedParameter: Parameter ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target behavior: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedParameter_behavior
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedParameterSet: ParameterSet ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target behavior: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedParameterSet_behavior
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source postcondition: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target behavior: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_postcondition_behavior
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source precondition: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target behavior: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_precondition_behavior
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedParameter: Parameter ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target ownerFormalParam: BehavioralFeature ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedParameter_ownerFormalParam
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedParameterSet: ParameterSet ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target behavioralFeature: BehavioralFeature ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedParameterSet_behavioralFeature
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source interfaceRealization: InterfaceRealization ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target implementingClassifier: BehavioredClassifier ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_interfaceRealization_implementingClassifier
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedBehavior: Behavior ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target behavioredClassifier: BehavioredClassifier ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedBehavior_behavioredClassifier
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target callAction: CallAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_callAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source target: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target callOperationAction: CallOperationAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_target_callOperationAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source changeExpression: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target changeEvent: ChangeEvent ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_changeExpression_changeEvent
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source nestedClassifier: Classifier ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target nestingClass: Class ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_nestedClassifier_nestingClass
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedAttribute: Property ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target class: Class ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedAttribute_class
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedOperation: Operation ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target class: Class ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedOperation_class
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedReception: Reception ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target class: Class ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedReception_class
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source collaborationUse: CollaborationUse ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target classifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_collaborationUse_classifier
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source generalization: Generalization ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target specific: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_generalization_specific
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedTemplateSignature: RedefinableTemplateSignature ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target classifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_ownedTemplateSignature_classifier
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedUseCase: UseCase ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target classifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedUseCase_classifier
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source substitution: Substitution ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target substitutingClassifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_substitution_substitutingClassifier
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source object: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target clearAssociationAction: ClearAssociationAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_object_clearAssociationAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target clearStructuralFeatureAction: ClearStructuralFeatureAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_clearStructuralFeatureAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source roleBinding: Dependency ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target collaborationUse: CollaborationUse ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_roleBinding_collaborationUse
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source cfragmentGate: Gate ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target combinedFragment: CombinedFragment ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_cfragmentGate_combinedFragment
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source operand: InteractionOperand ordered="true" unique="true" aggregation="composite" multiplicity="1..*"
    * @param: target combinedFragment: CombinedFragment ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_operand_combinedFragment
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source packagedElement: PackageableElement ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target component: Component ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_packagedElement_component
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source realization: ComponentRealization ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target abstraction: Component ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_realization_abstraction_component
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source clause: Clause ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
    * @param: target conditionalNode: ConditionalNode ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_clause_conditionalNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target conditionalNode: ConditionalNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_conditionalNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source end: ConnectorEnd ordered="true" unique="true" aggregation="composite" multiplicity="2..*"
    * @param: target connector: Connector ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_end_connector
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source specification: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target owningConstraint: Constraint ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_specification_owningConstraint
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source endData: LinkEndCreationData ordered="false" unique="true" aggregation="composite" multiplicity="2..*"
    * @param: target createLinkAction: CreateLinkAction ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_endData_createLinkAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target createLinkObjectAction: CreateLinkObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_createLinkObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target createObjectAction: CreateObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_createObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedAttribute: Property ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target datatype: DataType ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedAttribute_datatype
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedOperation: Operation ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target datatype: DataType ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedOperation_datatype
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source configuration: DeploymentSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target deployment: Deployment ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_configuration_deployment
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source deployment: Deployment ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target location: DeploymentTarget ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_deployment_location
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source endData: LinkEndDestructionData ordered="false" unique="true" aggregation="composite" multiplicity="2..*"
    * @param: target destroyLinkAction: DestroyLinkAction ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_endData_destroyLinkAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source target: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target destroyObjectAction: DestroyObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_target_destroyObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source expr: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target duration: Duration ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_expr_duration
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source specification: DurationInterval ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target durationConstraint: DurationConstraint ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_specification_durationConstraint
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedComment: Comment ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target owningElement: Element ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedComment_owningElement
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedLiteral: EnumerationLiteral ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target enumeration: Enumeration ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_ownedLiteral_enumeration
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source handler: ExceptionHandler ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target protectedNode: ExecutableNode ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_handler_protectedNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source operand: ValueSpecification ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target expression: Expression ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_operand_expression
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source condition: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target extend: Extend ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_condition_extend
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedEnd: ExtensionEnd ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target extension: Extension ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_ownedEnd_extension
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source slot: Slot ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target owningInstance: InstanceSpecification ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_slot_owningInstance
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source specification: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target owningInstanceSpec: InstanceSpecification ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_specification_owningInstanceSpec
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source action: Action ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target interaction: Interaction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_action_interaction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source formalGate: Gate ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target interaction: Interaction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_formalGate_interaction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source fragment: InteractionFragment ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target enclosingInteraction: Interaction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_fragment_enclosingInteraction
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source lifeline: Lifeline ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target interaction: Interaction ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_lifeline_interaction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source message: Message ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target interaction: Interaction ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_message_interaction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source maxint: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target interactionConstraint: InteractionConstraint ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_maxint_interactionConstraint
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source minint: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target interactionConstraint: InteractionConstraint ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_minint_interactionConstraint
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source generalOrdering: GeneralOrdering ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target interactionFragment: InteractionFragment ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_generalOrdering_interactionFragment
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source fragment: InteractionFragment ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target enclosingOperand: InteractionOperand ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_fragment_enclosingOperand
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source guard: InteractionConstraint ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target interactionOperand: InteractionOperand ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_guard_interactionOperand
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source actualGate: Gate ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target interactionUse: InteractionUse ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_actualGate_interactionUse
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source argument: ValueSpecification ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target interactionUse: InteractionUse ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_argument_interactionUse
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source returnValue: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target interactionUse: InteractionUse ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_returnValue_interactionUse
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source nestedClassifier: Classifier ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target interface: Interface ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_nestedClassifier_interface
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedAttribute: Property ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target interface: Interface ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedAttribute_interface
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedOperation: Operation ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target interface: Interface ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedOperation_interface
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedReception: Reception ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target interface: Interface ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedReception_interface
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source protocol: ProtocolStateMachine ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target interface: Interface ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_protocol_interface
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source specification: Interval ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target intervalConstraint: IntervalConstraint ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_specification_intervalConstraint
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source argument: InputPin ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target invocationAction: InvocationAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_argument_invocationAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source joinSpec: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target joinNode: JoinNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_joinSpec_joinNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source selector: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target lifeline: Lifeline ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_selector_lifeline
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source endData: LinkEndData ordered="false" unique="true" aggregation="composite" multiplicity="2..*"
    * @param: target linkAction: LinkAction ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_endData_linkAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source inputValue: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
    * @param: target linkAction: LinkAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_inputValue_linkAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source qualifier: QualifierValue ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target linkEndData: LinkEndData ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_qualifier_linkEndData
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source loopVariable: OutputPin ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target loopNode: LoopNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_loopVariable_loopNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source loopVariableInput: InputPin ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target loopNode: LoopNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_loopVariableInput_loopNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source result: OutputPin ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target loopNode: LoopNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_loopNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source argument: ValueSpecification ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target message: Message ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_argument_message
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source lowerValue: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target owningLower: MultiplicityElement ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_lowerValue_owningLower
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source upperValue: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target owningUpper: MultiplicityElement ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_upperValue_owningUpper
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source nameExpression: StringExpression ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target namedElement: NamedElement ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_nameExpression_namedElement
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source elementImport: ElementImport ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target importingNamespace: Namespace ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_elementImport_importingNamespace
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedRule: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target context: Namespace ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedRule_context
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source packageImport: PackageImport ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target importingNamespace: Namespace ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_packageImport_importingNamespace
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source nestedNode: Node ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target node: Node ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_nestedNode_node
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source upperBound: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target objectNode: ObjectNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_upperBound_objectNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source inputValue: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target opaqueAction: OpaqueAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_inputValue_opaqueAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source outputValue: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target opaqueAction: OpaqueAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_outputValue_opaqueAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source bodyCondition: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target bodyContext: Operation ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_bodyCondition_bodyContext
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedParameter: Parameter ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target operation: Operation ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedParameter_operation
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source postcondition: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target postContext: Operation ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_postcondition_postContext
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source precondition: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target preContext: Operation ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_precondition_preContext
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source packageMerge: PackageMerge ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target receivingPackage: Package ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_packageMerge_receivingPackage
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source packagedElement: PackageableElement ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target owningPackage: Package ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_packagedElement_owningPackage
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source profileApplication: ProfileApplication ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target applyingPackage: Package ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_profileApplication_applyingPackage
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source defaultValue: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target owningParameter: Parameter ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_defaultValue_owningParameter
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source condition: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target parameterSet: ParameterSet ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_condition_parameterSet
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source metaclassReference: ElementImport ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target profile: Profile ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_metaclassReference_profile
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source metamodelReference: PackageImport ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target profile: Profile ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_metamodelReference_profile
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source defaultValue: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target owningProperty: Property ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_defaultValue_owningProperty
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source qualifier: Property ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target associationEnd: Property ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_qualifier_associationEnd
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source conformance: ProtocolConformance ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target specificMachine: ProtocolStateMachine ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_conformance_specificMachine
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source postCondition: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target owningTransition: ProtocolTransition ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_postCondition_owningTransition
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source preCondition: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target protocolTransition: ProtocolTransition ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_preCondition_protocolTransition
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source exception: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target raiseExceptionAction: RaiseExceptionAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_exception_raiseExceptionAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target readExtentAction: ReadExtentAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_readExtentAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source object: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target readIsClassifiedObjectAction: ReadIsClassifiedObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_object_readIsClassifiedObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target readIsClassifiedObjectAction: ReadIsClassifiedObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_readIsClassifiedObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target readLinkAction: ReadLinkAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_readLinkAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source object: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target readLinkObjectEndAction: ReadLinkObjectEndAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_object_readLinkObjectEndAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target readLinkObjectEndAction: ReadLinkObjectEndAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_readLinkObjectEndAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source object: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target readLinkObjectEndQualifierAction: ReadLinkObjectEndQualifierAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_object_readLinkObjectEndQualifierAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target readLinkObjectEndQualifierAction: ReadLinkObjectEndQualifierAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_readLinkObjectEndQualifierAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target readSelfAction: ReadSelfAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_readSelfAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target readStructuralFeatureAction: ReadStructuralFeatureAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_readStructuralFeatureAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target readVariableAction: ReadVariableAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_readVariableAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source object: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target reclassifyObjectAction: ReclassifyObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_object_reclassifyObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source collection: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target reduceAction: ReduceAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_collection_reduceAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target reduceAction: ReduceAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_reduceAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source subvertex: Vertex ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target container: Region ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_subvertex_container
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source transition: Transition ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target container: Region ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_transition_container
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source removeAt: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target removeStructuralFeatureValueAction: RemoveStructuralFeatureValueAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_removeAt_removeStructuralFeatureValueAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source removeAt: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target removeVariableValueAction: RemoveVariableValueAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_removeAt_removeVariableValueAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source replyValue: InputPin ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target replyAction: ReplyAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_replyValue_replyAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source returnInformation: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target replyAction: ReplyAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_returnInformation_replyAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source request: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target sendObjectAction: SendObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_request_sendObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source target: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target sendObjectAction: SendObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_target_sendObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source target: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target sendSignalAction: SendSignalAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_target_sendSignalAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source executableNode: ExecutableNode ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target sequenceNode: SequenceNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_executableNode_sequenceNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedAttribute: Property ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target owningSignal: Signal ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedAttribute_owningSignal
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source value: ValueSpecification ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target owningSlot: Slot ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_value_owningSlot
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source object: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target startClassifierBehaviorAction: StartClassifierBehaviorAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_object_startClassifierBehaviorAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source object: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target startObjectBehaviorAction: StartObjectBehaviorAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_object_startObjectBehaviorAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source connection: ConnectionPointReference ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target state: State ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_connection_state
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source connectionPoint: Pseudostate ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target state: State ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_connectionPoint_state
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source deferrableTrigger: Trigger ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target state: State ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_deferrableTrigger_state
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source doActivity: Behavior ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target state: State ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_doActivity_state
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source entry: Behavior ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target state: State ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_entry_state
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source exit: Behavior ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target state: State ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_exit_state
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source region: Region ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target state: State ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_region_state
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source stateInvariant: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target owningState: State ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_stateInvariant_owningState
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source invariant: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target stateInvariant: StateInvariant ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_invariant_stateInvariant
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source connectionPoint: Pseudostate ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target stateMachine: StateMachine ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_connectionPoint_stateMachine
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source region: Region ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
    * @param: target stateMachine: StateMachine ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_region_stateMachine
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source icon: Image ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target stereotype: Stereotype ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_icon_stereotype
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source subExpression: StringExpression ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target owningExpression: StringExpression ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_subExpression_owningExpression
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source object: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target structuralFeatureAction: StructuralFeatureAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_object_structuralFeatureAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source edge: ActivityEdge ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target inStructuredNode: StructuredActivityNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_edge_inStructuredNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source node: ActivityNode ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target inStructuredNode: StructuredActivityNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_node_inStructuredNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source structuredNodeInput: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target structuredActivityNode: StructuredActivityNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_structuredNodeInput_structuredActivityNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source structuredNodeOutput: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target structuredActivityNode: StructuredActivityNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_structuredNodeOutput_structuredActivityNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source variable: Variable ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target scope: StructuredActivityNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_variable_scope
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedAttribute: Property ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target structuredClassifier: StructuredClassifier ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedAttribute_structuredClassifier
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedConnector: Connector ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target structuredClassifier: StructuredClassifier ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedConnector_structuredClassifier
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source parameterSubstitution: TemplateParameterSubstitution ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target templateBinding: TemplateBinding ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_parameterSubstitution_templateBinding
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedDefault: ParameterableElement ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target templateParameter: TemplateParameter ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedDefault_templateParameter
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedParameteredElement: ParameterableElement ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target owningTemplateParameter: TemplateParameter ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedParameteredElement_owningTemplateParameter
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedActual: ParameterableElement ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target owningTemplateParameterSubstitution: TemplateParameterSubstitution ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_ownedActual_owningTemplateParameterSubstitution
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source ownedParameter: TemplateParameter ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target signature: TemplateSignature ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_ownedParameter_signature
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source ownedTemplateSignature: TemplateSignature ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target template: TemplateableElement ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_ownedTemplateSignature_template
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source templateBinding: TemplateBinding ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target boundElement: TemplateableElement ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_templateBinding_boundElement
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source first: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target testIdentityAction: TestIdentityAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_first_testIdentityAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target testIdentityAction: TestIdentityAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_testIdentityAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source second: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target testIdentityAction: TestIdentityAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_second_testIdentityAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source specification: TimeInterval ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target timeConstraint: TimeConstraint ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_specification_timeConstraint
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source when: TimeExpression ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target timeEvent: TimeEvent ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_when_timeEvent
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source expr: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target timeExpression: TimeExpression ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_expr_timeExpression
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source effect: Behavior ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target transition: Transition ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_effect_transition
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source guard: Constraint ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target transition: Transition ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_guard_transition
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source trigger: Trigger ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target transition: Transition ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_trigger_transition
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source object: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target unmarshallAction: UnmarshallAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_object_unmarshallAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="true" unique="true" aggregation="composite" multiplicity="1..*"
    * @param: target unmarshallAction: UnmarshallAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_unmarshallAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source extend: Extend ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target extension: UseCase ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_extend_extension
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source extensionPoint: ExtensionPoint ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target useCase: UseCase ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_extensionPoint_useCase
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source include: Include ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * @param: target includingCase: UseCase ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_include_includingCase
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source value: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target valuePin: ValuePin ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_value_valuePin
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target valueSpecificationAction: ValueSpecificationAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_valueSpecificationAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source value: ValueSpecification ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * @param: target valueSpecificationAction: ValueSpecificationAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_value_valueSpecificationAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source result: OutputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target writeStructuralFeatureAction: WriteStructuralFeatureAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_result_writeStructuralFeatureAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source value: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target writeStructuralFeatureAction: WriteStructuralFeatureAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_value_writeStructuralFeatureAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}

  /**
    * @param: source value: InputPin ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * @param: target writeVariableAction: WriteVariableAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_value_writeVariableAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFCompositeLink
  {}


  /**
    * @param: source action: Action ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target actionExecutionSpecification: ActionExecutionSpecification ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_action_actionExecutionSpecification
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source partition: ActivityPartition ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target activity: Activity ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_partition_activity
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source inPartition: ActivityPartition ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target edge: ActivityEdge ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_edge_inPartition
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source redefinedEdge: ActivityEdge ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target activityEdge: ActivityEdge ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_redefinedEdge_activityEdge
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source inPartition: ActivityPartition ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target node: ActivityNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_inPartition_node
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source incoming: ActivityEdge ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target target: ActivityNode ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_incoming_target_node
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source outgoing: ActivityEdge ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target source: ActivityNode ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_outgoing_source_node
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source redefinedNode: ActivityNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target activityNode: ActivityNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_redefinedNode_activityNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source parameter: Parameter ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target activityParameterNode: ActivityParameterNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_parameter_activityParameterNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source represents: Element ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target activityPartition: ActivityPartition ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_represents_activityPartition
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source memberEnd: Property ordered="true" unique="true" aggregation="none" multiplicity="2..*"
    * @param: target association: Association ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_memberEnd_association
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source navigableOwnedEnd: Property ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target association: Association ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_navigableOwnedEnd_association
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source redefinedBehavior: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target behavior: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_redefinedBehavior_behavior
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source specification: BehavioralFeature ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target method: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_method_specification
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source behavior: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target behaviorExecutionSpecification: BehaviorExecutionSpecification ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_behavior_behaviorExecutionSpecification
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source raisedException: Type ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target behavioralFeature: BehavioralFeature ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_raisedException_behavioralFeature
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source classifierBehavior: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target behavioredClassifier: BehavioredClassifier ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_classifierBehavior_behavioredClassifier
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source signal: Signal ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target broadcastSignalAction: BroadcastSignalAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_signal_broadcastSignalAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source behavior: Behavior ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target callBehaviorAction: CallBehaviorAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_behavior_callBehaviorAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source operation: Operation ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target callEvent: CallEvent ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_operation_callEvent
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source operation: Operation ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target callOperationAction: CallOperationAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_operation_callOperationAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source powertypeExtent: GeneralizationSet ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target powertype: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_powertypeExtent_powertype
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source redefinedClassifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target classifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_redefinedClassifier_classifier
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source representation: CollaborationUse ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target classifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_representation_classifier
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source templateParameter: ClassifierTemplateParameter ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target parameteredElement: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_classifier_templateParameter_parameteredElement
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source constrainingClassifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target classifierTemplateParameter: ClassifierTemplateParameter ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_constrainingClassifier_classifierTemplateParameter
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source body: ExecutableNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target clause: Clause ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_body_clause
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source bodyOutput: OutputPin ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target clause: Clause ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_bodyOutput_clause
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source decider: OutputPin ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target clause: Clause ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_decider_clause
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source successorClause: Clause ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target predecessorClause: Clause ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_predecessorClause_successorClause
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source test: ExecutableNode ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target clause: Clause ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_test_clause
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source association: Association ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target clearAssociationAction: ClearAssociationAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_association_clearAssociationAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source collaborationRole: ConnectableElement ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target collaboration: Collaboration ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_collaborationRole_collaboration
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source type: Collaboration ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target collaborationUse: CollaborationUse ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_type_collaborationUse
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source annotatedElement: Element ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target comment: Comment ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_annotatedElement_comment
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source realizingClassifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target componentRealization: ComponentRealization ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_realizingClassifier_componentRealization
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source parameteredElement: ConnectableElement ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target templateParameter: ConnectableElementTemplateParameter ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_connectableElement_templateParameter_parameteredElement
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source entry: Pseudostate ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target connectionPointReference: ConnectionPointReference ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_entry_connectionPointReference
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source exit: Pseudostate ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target connectionPointReference: ConnectionPointReference ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_exit_connectionPointReference
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source contract: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target connector: Connector ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_contract_connector
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source redefinedConnector: Connector ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target connector: Connector ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_redefinedConnector_connector
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source type: Association ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target connector: Connector ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_type_connector
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source partWithPort: Property ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target connectorEnd: ConnectorEnd ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_partWithPort_connectorEnd
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source role: ConnectableElement ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target end: ConnectorEnd ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_end_role
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source message: NamedElement ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target considerIgnoreFragment: ConsiderIgnoreFragment ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_message_considerIgnoreFragment
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source constrainedElement: Element ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target constraint: Constraint ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_constrainedElement_constraint
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source classifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target createObjectAction: CreateObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_classifier_createObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source decisionInput: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target decisionNode: DecisionNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_decisionInput_decisionNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source decisionInputFlow: ObjectFlow ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target decisionNode: DecisionNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_decisionInputFlow_decisionNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source client: NamedElement ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target clientDependency: Dependency ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_clientDependency_client
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source supplier: NamedElement ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target supplierDependency: Dependency ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_supplier_supplierDependency
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source deployedArtifact: DeployedArtifact ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target deploymentForArtifact: Deployment ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_deployedArtifact_deploymentForArtifact
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source observation: Observation ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target duration: Duration ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_observation_duration
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source max: Duration ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target durationInterval: DurationInterval ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_max_durationInterval
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source min: Duration ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target durationInterval: DurationInterval ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_min_durationInterval
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source event: NamedElement ordered="true" unique="true" aggregation="none" multiplicity="1..2"
    * @param: target durationObservation: DurationObservation ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_event_durationObservation
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source importedElement: PackageableElement ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target import: ElementImport ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_importedElement_import
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source exceptionInput: ObjectNode ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target exceptionHandler: ExceptionHandler ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_exceptionInput_exceptionHandler
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source exceptionType: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target exceptionHandler: ExceptionHandler ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_exceptionType_exceptionHandler
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source handlerBody: ExecutableNode ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target exceptionHandler: ExceptionHandler ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_handlerBody_exceptionHandler
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source execution: ExecutionSpecification ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target executionOccurrenceSpecification: ExecutionOccurrenceSpecification ordered="false" unique="true" aggregation="none" multiplicity="0..2"
    */
  case class OTIUMLA_execution_executionOccurrenceSpecification
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source finish: OccurrenceSpecification ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target executionSpecification: ExecutionSpecification ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_finish_executionSpecification
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source start: OccurrenceSpecification ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target executionSpecification: ExecutionSpecification ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_start_executionSpecification
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source inputElement: ExpansionNode ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target regionAsInput: ExpansionRegion ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_inputElement_regionAsInput
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source outputElement: ExpansionNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target regionAsOutput: ExpansionRegion ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_outputElement_regionAsOutput
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source extendedCase: UseCase ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target extend: Extend ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_extendedCase_extend
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source extensionLocation: ExtensionPoint ordered="true" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target extension: Extend ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_extensionLocation_extension
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source type: Stereotype ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target extensionEnd: ExtensionEnd ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_type_extensionEnd
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source general: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target generalization: Generalization ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_general_generalization
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source generalization: Generalization ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target generalizationSet: GeneralizationSet ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_generalizationSet_generalization
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source addition: UseCase ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target include: Include ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_addition_include
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source conveyed: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target conveyingFlow: InformationFlow ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_conveyed_conveyingFlow
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source informationSource: NamedElement ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target informationFlow: InformationFlow ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_informationSource_informationFlow
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source informationTarget: NamedElement ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target informationFlow: InformationFlow ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_informationTarget_informationFlow
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source realization: Relationship ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target abstraction: InformationFlow ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_realization_abstraction_flow
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source realizingActivityEdge: ActivityEdge ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target informationFlow: InformationFlow ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_realizingActivityEdge_informationFlow
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source realizingConnector: Connector ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target informationFlow: InformationFlow ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_realizingConnector_informationFlow
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source realizingMessage: Message ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target informationFlow: InformationFlow ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_realizingMessage_informationFlow
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source represented: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target representation: InformationItem ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_represented_representation
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source classifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target instanceSpecification: InstanceSpecification ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_classifier_instanceSpecification
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source instance: InstanceSpecification ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target instanceValue: InstanceValue ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_instance_instanceValue
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source refersTo: Interaction ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target interactionUse: InteractionUse ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_refersTo_interactionUse
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source returnValueRecipient: Property ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target interactionUse: InteractionUse ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_returnValueRecipient_interactionUse
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source redefinedInterface: Interface ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target interface: Interface ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_redefinedInterface_interface
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source contract: Interface ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target interfaceRealization: InterfaceRealization ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_contract_interfaceRealization
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source interruptingEdge: ActivityEdge ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target interrupts: InterruptibleActivityRegion ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_interruptingEdge_interrupts
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source node: ActivityNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target inInterruptibleRegion: InterruptibleActivityRegion ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_inInterruptibleRegion_node
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source max: ValueSpecification ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target interval: Interval ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_max_interval
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source min: ValueSpecification ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target interval: Interval ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_min_interval
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source onPort: Port ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target invocationAction: InvocationAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_onPort_invocationAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source coveredBy: InteractionFragment ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target covered: Lifeline ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_covered_coveredBy
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source decomposedAs: PartDecomposition ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target lifeline: Lifeline ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_decomposedAs_lifeline
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source represents: ConnectableElement ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target lifeline: Lifeline ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_represents_lifeline
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source insertAt: InputPin ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target linkEndCreationData: LinkEndCreationData ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_insertAt_linkEndCreationData
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source end: Property ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target linkEndData: LinkEndData ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_end_linkEndData
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source value: InputPin ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target linkEndData: LinkEndData ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_value_linkEndData
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source destroyAt: InputPin ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target linkEndDestructionData: LinkEndDestructionData ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_destroyAt_linkEndDestructionData
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source bodyOutput: OutputPin ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target loopNode: LoopNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_bodyOutput_loopNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source bodyPart: ExecutableNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target loopNode: LoopNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_bodyPart_loopNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source decider: OutputPin ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target loopNode: LoopNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_decider_loopNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source setupPart: ExecutableNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target loopNode: LoopNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_setupPart_loopNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source test: ExecutableNode ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target loopNode: LoopNode ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_test_loopNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source utilizedElement: PackageableElement ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target manifestation: Manifestation ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_utilizedElement_manifestation
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source connector: Connector ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target message: Message ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_connector_message
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source receiveEvent: MessageEnd ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target endMessage: Message ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_receiveEvent_endMessage
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source sendEvent: MessageEnd ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target endMessage: Message ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_sendEvent_endMessage
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source signature: NamedElement ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target message: Message ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_signature_message
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source message: Message ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target messageEnd: MessageEnd ordered="false" unique="true" aggregation="none" multiplicity="0..2"
    */
  case class OTIUMLA_message_messageEnd
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source selection: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target objectFlow: ObjectFlow ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_selection_objectFlow
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source transformation: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target objectFlow: ObjectFlow ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_transformation_objectFlow
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source inState: State ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target objectNode: ObjectNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_inState_objectNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source selection: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target objectNode: ObjectNode ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_selection_objectNode
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source covered: Lifeline ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target events: OccurrenceSpecification ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_covered_events
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL,
    override val targetIndex: Int )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFTargetOrderedLink
  {}

  /**
    * @param: source toAfter: GeneralOrdering ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target before: OccurrenceSpecification ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_before_toAfter
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source toBefore: GeneralOrdering ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target after: OccurrenceSpecification ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_toBefore_after
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source behavior: Behavior ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target opaqueExpression: OpaqueExpression ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_behavior_opaqueExpression
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source raisedException: Type ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target operation: Operation ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_raisedException_operation
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source redefinedOperation: Operation ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target operation: Operation ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_redefinedOperation_operation
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source parameteredElement: Operation ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target templateParameter: OperationTemplateParameter ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_operation_templateParameter_parameteredElement
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source importedPackage: Package ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target packageImport: PackageImport ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_importedPackage_packageImport
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source mergedPackage: Package ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target packageMerge: PackageMerge ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_mergedPackage_packageMerge
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source parameter: Parameter ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target parameterSet: ParameterSet ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_parameterSet_parameter
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source templateParameter: TemplateParameter ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target parameteredElement: ParameterableElement ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  case class OTIUMLA_parameteredElement_templateParameter
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source protocol: ProtocolStateMachine ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target port: Port ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_protocol_port
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source redefinedPort: Port ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target port: Port ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_redefinedPort_port
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source appliedProfile: Profile ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target profileApplication: ProfileApplication ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_appliedProfile_profileApplication
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source redefinedProperty: Property ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target property: Property ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_redefinedProperty_property
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source subsettedProperty: Property ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target property: Property ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_subsettedProperty_property
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source generalMachine: ProtocolStateMachine ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target protocolConformance: ProtocolConformance ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_generalMachine_protocolConformance
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source qualifier: Property ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target qualifierValue: QualifierValue ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_qualifier_qualifierValue
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source value: InputPin ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target qualifierValue: QualifierValue ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_value_qualifierValue
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source classifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target readExtentAction: ReadExtentAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_classifier_readExtentAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source classifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target readIsClassifiedObjectAction: ReadIsClassifiedObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_classifier_readIsClassifiedObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source end: Property ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target readLinkObjectEndAction: ReadLinkObjectEndAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_end_readLinkObjectEndAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source qualifier: Property ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target readLinkObjectEndQualifierAction: ReadLinkObjectEndQualifierAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_qualifier_readLinkObjectEndQualifierAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source signal: Signal ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target reception: Reception ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_signal_reception
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source newClassifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target reclassifyObjectAction: ReclassifyObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_newClassifier_reclassifyObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source oldClassifier: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target reclassifyObjectAction: ReclassifyObjectAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_oldClassifier_reclassifyObjectAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source extendedSignature: RedefinableTemplateSignature ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target redefinableTemplateSignature: RedefinableTemplateSignature ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_extendedSignature_redefinableTemplateSignature
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source reducer: Behavior ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target reduceAction: ReduceAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_reducer_reduceAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source extendedRegion: Region ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target region: Region ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_extendedRegion_region
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source replyToCall: Trigger ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target replyAction: ReplyAction ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_replyToCall_replyAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source signal: Signal ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target sendSignalAction: SendSignalAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_signal_sendSignalAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source signal: Signal ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target signalEvent: SignalEvent ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_signal_signalEvent
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source definingFeature: StructuralFeature ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target slot: Slot ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_definingFeature_slot
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source redefinedState: State ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target state: State ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_redefinedState_state
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source covered: Lifeline ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target stateInvariant: StateInvariant ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_covered_stateInvariant
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source extendedStateMachine: StateMachine ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target stateMachine: StateMachine ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_extendedStateMachine_stateMachine
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source submachineState: State ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target submachine: StateMachine ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_submachineState_submachine
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source structuralFeature: StructuralFeature ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target structuralFeatureAction: StructuralFeatureAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_structuralFeature_structuralFeatureAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source contract: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target substitution: Substitution ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_contract_substitution
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source signature: TemplateSignature ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target templateBinding: TemplateBinding ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_signature_templateBinding
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source default: ParameterableElement ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target templateParameter: TemplateParameter ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_default_templateParameter
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source actual: ParameterableElement ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target templateParameterSubstitution: TemplateParameterSubstitution ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_actual_templateParameterSubstitution
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source formal: TemplateParameter ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target templateParameterSubstitution: TemplateParameterSubstitution ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_formal_templateParameterSubstitution
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source parameter: TemplateParameter ordered="true" unique="true" aggregation="none" multiplicity="1..*"
    * @param: target templateSignature: TemplateSignature ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_parameter_templateSignature
  ( override val source: ToolSpecificElementDocumentURL,
    override val sourceIndex: Int,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  with OTIMOFSourceOrderedLink
  {}

  /**
    * @param: source observation: Observation ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target timeExpression: TimeExpression ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  case class OTIUMLA_observation_timeExpression
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source max: TimeExpression ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target timeInterval: TimeInterval ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_max_timeInterval
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source min: TimeExpression ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target timeInterval: TimeInterval ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_min_timeInterval
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source event: NamedElement ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target timeObservation: TimeObservation ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_event_timeObservation
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source redefinedTransition: Transition ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target transition: Transition ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_redefinedTransition_transition
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source source: Vertex ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target outgoing: Transition ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_outgoing_source_vertex
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source target: Vertex ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target incoming: Transition ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_incoming_target_vertex
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source event: Event ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target trigger: Trigger ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_event_trigger
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source port: Port ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target trigger: Trigger ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_port_trigger
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source type: Type ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * @param: target typedElement: TypedElement ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_type_typedElement
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source unmarshallType: Classifier ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target unmarshallAction: UnmarshallAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_unmarshallType_unmarshallAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source subject: Classifier ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * @param: target useCase: UseCase ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_subject_useCase
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

  /**
    * @param: source variable: Variable ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * @param: target variableAction: VariableAction ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    */
  case class OTIUMLA_variable_variableAction
  ( override val source: ToolSpecificElementDocumentURL,
    override val target: ToolSpecificElementDocumentURL )
  extends OTIMOFLink
  with OTIMOFReferenceLink
  {}

}
