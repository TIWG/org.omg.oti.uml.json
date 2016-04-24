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
import org.omg.oti.json.uml.enums._

import play.json.extra._
import play.api.libs.json._
import play.api.libs.functional.syntax._

import scala.collection.immutable._
import scala.{Boolean,Double,Int,Option,Ordering}
import scala.Predef.String
import scalaz.@@
// <!-- End of user code imports -->

/** <!-- Start of user code OTI MOF Element documentation -->
  * In OMG MOF 2.5, a MOF Element is an instance of exactly 1 MOF metaclass.
  * This means that for serializing a MOF Element, it is sufficient to have support for concrete MOF metaclasses.
  *
  * OTIMOFElement is intended to be the single parent of case classes, 1 case class per distinct concrete MOF metaclass.
  * OTIMOFElement provides the common data attributes necessary for uniquely identifying a MOF Element that is an
  * instance of a single MOF metaclass in an OMG CMOF metamodel (e.g., OMG UML 2.5).
  * The information about the MOF metaclass is represented as a JSon `type` field 
  * <!-- End of user code OTI MOF Element documentation -->
  */
sealed trait OTIMOFElement {
  val otiMOFElementLocation: ElementLocation
}

object OTIMOFElement {

  // traits for all OMG UML 2.5 metaclasses
  // trait U1 extends U2 if UML 2.5 metaclass U1 has a direct generalization relationship to UML 2.5 metaclass U2

  /**
    * An Abstraction is a Relationship that relates two Elements or sets of Elements that represent the same concept at different levels of abstraction or from different viewpoints.
    */
  trait UMLAbstraction
		extends UMLDependency
  {}

  /**
    * An AcceptCallAction is an AcceptEventAction that handles the receipt of a synchronous call request. In addition to the values from the Operation input parameters, the Action produces an output that is needed later to supply the information to the ReplyAction necessary to return control to the caller. An AcceptCallAction is for synchronous calls. If it is used to handle an asynchronous call, execution of the subsequent ReplyAction will complete immediately with no effect.
    */
  trait UMLAcceptCallAction
		extends UMLAcceptEventAction
  {}

  /**
    * An AcceptEventAction is an Action that waits for the occurrence of one or more specific Events.
    */
  trait UMLAcceptEventAction
		extends UMLAction
  {}

  /**
    * An Action is the fundamental unit of executable functionality. The execution of an Action represents some transformation or processing in the modeled system. Actions provide the ExecutableNodes within Activities and may also be used within Interactions.
    */
  trait UMLAction
		extends UMLExecutableNode
  {}

  /**
    * An ActionExecutionSpecification is a kind of ExecutionSpecification representing the execution of an Action.
    */
  trait UMLActionExecutionSpecification
		extends UMLExecutionSpecification
  {}

  /**
    * An ActionInputPin is a kind of InputPin that executes an Action to determine the values to input to another Action.
    */
  trait UMLActionInputPin
		extends UMLInputPin
  {}

  /**
    * An Activity is the specification of parameterized Behavior as the coordinated sequencing of subordinate units.
    */
  trait UMLActivity
		extends UMLBehavior
  {}

  /**
    * An ActivityEdge is an abstract class for directed connections between two ActivityNodes.
    */
  trait UMLActivityEdge
		extends UMLRedefinableElement
  {}

  /**
    * An ActivityFinalNode is a FinalNode that terminates the execution of its owning Activity or StructuredActivityNode.
    */
  trait UMLActivityFinalNode
		extends UMLFinalNode
  {}

  /**
    * ActivityGroup is an abstract class for defining sets of ActivityNodes and ActivityEdges in an Activity.
    */
  trait UMLActivityGroup
		extends UMLNamedElement
  {}

  /**
    * ActivityNode is an abstract class for points in the flow of an Activity connected by ActivityEdges.
    */
  trait UMLActivityNode
		extends UMLRedefinableElement
  {}

  /**
    * An ActivityParameterNode is an ObjectNode for accepting values from the input Parameters or providing values to the output Parameters of an Activity.
    */
  trait UMLActivityParameterNode
		extends UMLObjectNode
  {}

  /**
    * An ActivityPartition is a kind of ActivityGroup for identifying ActivityNodes that have some characteristic in common.
    */
  trait UMLActivityPartition
		extends UMLActivityGroup
  {}

  /**
    * An Actor specifies a role played by a user or any other system that interacts with the subject.
    */
  trait UMLActor
		extends UMLBehavioredClassifier
  {}

  /**
    * An AddStructuralFeatureValueAction is a WriteStructuralFeatureAction for adding values to a StructuralFeature.
    */
  trait UMLAddStructuralFeatureValueAction
		extends UMLWriteStructuralFeatureAction
  {}

  /**
    * An AddVariableValueAction is a WriteVariableAction for adding values to a Variable.
    */
  trait UMLAddVariableValueAction
		extends UMLWriteVariableAction
  {}

  /**
    * A trigger for an AnyReceiveEvent is triggered by the receipt of any message that is not explicitly handled by any related trigger.
    */
  trait UMLAnyReceiveEvent
		extends UMLMessageEvent
  {}

  /**
    * An artifact is the specification of a physical piece of information that is used or produced by a software development process, or by deployment and operation of a system. Examples of artifacts include model files, source files, scripts, and binary executable files, a table in a database system, a development deliverable, or a word-processing document, a mail message.An artifact is the source of a deployment to a node.
    */
  trait UMLArtifact
		extends UMLClassifier
		with UMLDeployedArtifact
  {}

  /**
    * A link is a tuple of values that refer to typed objects.  An Association classifies a set of links, each of which is an instance of the Association.  Each value in the link refers to an instance of the type of the corresponding end of the Association.
    */
  trait UMLAssociation
		extends UMLClassifier
		with UMLRelationship
  {}

  /**
    * A model element that has both Association and Class properties. An AssociationClass can be seen as an Association that also has Class properties, or as a Class that also has Association properties. It not only connects a set of Classifiers but also defines a set of Features that belong to the Association itself and not to any of the associated Classifiers.
    */
  trait UMLAssociationClass
		extends UMLAssociation
		with UMLClass
  {}

  /**
    * Behavior is a specification of how its context BehavioredClassifier changes state over time. This specification may be either a definition of possible behavior execution or emergent behavior, or a selective illustration of an interesting subset of possible executions. The latter form is typically used for capturing examples, such as a trace of a particular execution.
    */
  trait UMLBehavior
		extends UMLClass
  {}

  /**
    * A BehaviorExecutionSpecification is a kind of ExecutionSpecification representing the execution of a Behavior.
    */
  trait UMLBehaviorExecutionSpecification
		extends UMLExecutionSpecification
  {}

  /**
    * A BehavioralFeature is a feature of a Classifier that specifies an aspect of the behavior of its instances.  A BehavioralFeature is implemented (realized) by a Behavior. A BehavioralFeature specifies that a Classifier will respond to a designated request by invoking its implementing method.
    */
  trait UMLBehavioralFeature
		extends UMLFeature
		with UMLNamespace
  {}

  /**
    * A BehavioredClassifier may have InterfaceRealizations, and owns a set of Behaviors one of which may specify the behavior of the BehavioredClassifier itself.
    */
  trait UMLBehavioredClassifier
		extends UMLClassifier
  {}

  /**
    * A BroadcastSignalAction is an InvocationAction that transmits a Signal instance to all the potential target objects in the system. Values from the argument InputPins are used to provide values for the attributes of the Signal. The requestor continues execution immediately after the Signal instances are sent out and cannot receive reply values.
    */
  trait UMLBroadcastSignalAction
		extends UMLInvocationAction
  {}

  /**
    * CallAction is an abstract class for Actions that invoke a Behavior with given argument values and (if the invocation is synchronous) receive reply values.
    */
  trait UMLCallAction
		extends UMLInvocationAction
  {}

  /**
    * A CallBehaviorAction is a CallAction that invokes a Behavior directly. The argument values of the CallBehaviorAction are passed on the input Parameters of the invoked Behavior. If the call is synchronous, the execution of the CallBehaviorAction waits until the execution of the invoked Behavior completes and the values of output Parameters of the Behavior are placed on the result OutputPins. If the call is asynchronous, the CallBehaviorAction completes immediately and no results values can be provided.
    */
  trait UMLCallBehaviorAction
		extends UMLCallAction
  {}

  /**
    * A CallEvent models the receipt by an object of a message invoking a call of an Operation.
    */
  trait UMLCallEvent
		extends UMLMessageEvent
  {}

  /**
    * A CallOperationAction is a CallAction that transmits an Operation call request to the target object, where it may cause the invocation of associated Behavior. The argument values of the CallOperationAction are passed on the input Parameters of the Operation. If call is synchronous, the execution of the CallOperationAction waits until the execution of the invoked Operation completes and the values of output Parameters of the Operation are placed on the result OutputPins. If the call is asynchronous, the CallOperationAction completes immediately and no results values can be provided.
    */
  trait UMLCallOperationAction
		extends UMLCallAction
  {}

  /**
    * A CentralBufferNode is an ObjectNode for managing flows from multiple sources and targets.
    */
  trait UMLCentralBufferNode
		extends UMLObjectNode
  {}

  /**
    * A ChangeEvent models a change in the system configuration that makes a condition true.
    */
  trait UMLChangeEvent
		extends UMLEvent
  {}

  /**
    * A Class classifies a set of objects and specifies the features that characterize the structure and behavior of those objects.  A Class may have an internal structure and Ports.
    */
  trait UMLClass
		extends UMLBehavioredClassifier
		with UMLEncapsulatedClassifier
  {}

  /**
    * A Classifier represents a classification of instances according to their Features.
    */
  trait UMLClassifier
		extends UMLNamespace
		with UMLRedefinableElement
		with UMLTemplateableElement
		with UMLType
  {}

  /**
    * A ClassifierTemplateParameter exposes a Classifier as a formal template parameter.
    */
  trait UMLClassifierTemplateParameter
		extends UMLTemplateParameter
  {}

  /**
    * A Clause is an Element that represents a single branch of a ConditionalNode, including a test and a body section. The body section is executed only if (but not necessarily if) the test section evaluates to true.
    */
  trait UMLClause
		extends UMLElement
  {}

  /**
    * A ClearAssociationAction is an Action that destroys all links of an Association in which a particular object participates.
    */
  trait UMLClearAssociationAction
		extends UMLAction
  {}

  /**
    * A ClearStructuralFeatureAction is a StructuralFeatureAction that removes all values of a StructuralFeature.
    */
  trait UMLClearStructuralFeatureAction
		extends UMLStructuralFeatureAction
  {}

  /**
    * A ClearVariableAction is a VariableAction that removes all values of a Variable.
    */
  trait UMLClearVariableAction
		extends UMLVariableAction
  {}

  /**
    * A Collaboration describes a structure of collaborating elements (roles), each performing a specialized function, which collectively accomplish some desired functionality. 
    */
  trait UMLCollaboration
		extends UMLBehavioredClassifier
		with UMLStructuredClassifier
  {}

  /**
    * A CollaborationUse is used to specify the application of a pattern specified by a Collaboration to a specific situation.
    */
  trait UMLCollaborationUse
		extends UMLNamedElement
  {}

  /**
    * A CombinedFragment defines an expression of InteractionFragments. A CombinedFragment is defined by an interaction operator and corresponding InteractionOperands. Through the use of CombinedFragments the user will be able to describe a number of traces in a compact and concise manner.
    */
  trait UMLCombinedFragment
		extends UMLInteractionFragment
  {}

  /**
    * A Comment is a textual annotation that can be attached to a set of Elements.
    */
  trait UMLComment
		extends UMLElement
  {}

  /**
    * A communication path is an association between two deployment targets, through which they are able to exchange signals and messages.
    */
  trait UMLCommunicationPath
		extends UMLAssociation
  {}

  /**
    * A Component represents a modular part of a system that encapsulates its contents and whose manifestation is replaceable within its environment.  
    */
  trait UMLComponent
		extends UMLClass
  {}

  /**
    * Realization is specialized to (optionally) define the Classifiers that realize the contract offered by a Component in terms of its provided and required Interfaces. The Component forms an abstraction from these various Classifiers.
    */
  trait UMLComponentRealization
		extends UMLRealization
  {}

  /**
    * A ConditionalNode is a StructuredActivityNode that chooses one among some number of alternative collections of ExecutableNodes to execute.
    */
  trait UMLConditionalNode
		extends UMLStructuredActivityNode
  {}

  /**
    * ConnectableElement is an abstract metaclass representing a set of instances that play roles of a StructuredClassifier. ConnectableElements may be joined by attached Connectors and specify configurations of linked instances to be created within an instance of the containing StructuredClassifier.
    */
  trait UMLConnectableElement
		extends UMLParameterableElement
		with UMLTypedElement
  {}

  /**
    * A ConnectableElementTemplateParameter exposes a ConnectableElement as a formal parameter for a template.
    */
  trait UMLConnectableElementTemplateParameter
		extends UMLTemplateParameter
  {}

  /**
    * A ConnectionPointReference represents a usage (as part of a submachine State) of an entry/exit point Pseudostate defined in the StateMachine referenced by the submachine State.
    */
  trait UMLConnectionPointReference
		extends UMLVertex
  {}

  /**
    * A Connector specifies links that enables communication between two or more instances. In contrast to Associations, which specify links between any instance of the associated Classifiers, Connectors specify links between instances playing the connected parts only.
    */
  trait UMLConnector
		extends UMLFeature
  {}

  /**
    * A ConnectorEnd is an endpoint of a Connector, which attaches the Connector to a ConnectableElement.
    */
  trait UMLConnectorEnd
		extends UMLMultiplicityElement
  {}

  /**
    * A ConsiderIgnoreFragment is a kind of CombinedFragment that is used for the consider and ignore cases, which require lists of pertinent Messages to be specified.
    */
  trait UMLConsiderIgnoreFragment
		extends UMLCombinedFragment
  {}

  /**
    * A Constraint is a condition or restriction expressed in natural language text or in a machine readable language for the purpose of declaring some of the semantics of an Element or set of Elements.
    */
  trait UMLConstraint
		extends UMLPackageableElement
  {}

  /**
    * A Continuation is a syntactic way to define continuations of different branches of an alternative CombinedFragment. Continuations are intuitively similar to labels representing intermediate points in a flow of control.
    */
  trait UMLContinuation
		extends UMLInteractionFragment
  {}

  /**
    * A ControlFlow is an ActivityEdge traversed by control tokens or object tokens of control type, which are use to control the execution of ExecutableNodes.
    */
  trait UMLControlFlow
		extends UMLActivityEdge
  {}

  /**
    * A ControlNode is an abstract ActivityNode that coordinates flows in an Activity.
    */
  trait UMLControlNode
		extends UMLActivityNode
  {}

  /**
    * A CreateLinkAction is a WriteLinkAction for creating links.
    */
  trait UMLCreateLinkAction
		extends UMLWriteLinkAction
  {}

  /**
    * A CreateLinkObjectAction is a CreateLinkAction for creating link objects (AssociationClasse instances).
    */
  trait UMLCreateLinkObjectAction
		extends UMLCreateLinkAction
  {}

  /**
    * A CreateObjectAction is an Action that creates an instance of the specified Classifier.
    */
  trait UMLCreateObjectAction
		extends UMLAction
  {}

  /**
    * A DataStoreNode is a CentralBufferNode for persistent data.
    */
  trait UMLDataStoreNode
		extends UMLCentralBufferNode
  {}

  /**
    * A DataType is a type whose instances are identified only by their value.
    */
  trait UMLDataType
		extends UMLClassifier
  {}

  /**
    * A DecisionNode is a ControlNode that chooses between outgoing ActivityEdges for the routing of tokens.
    */
  trait UMLDecisionNode
		extends UMLControlNode
  {}

  /**
    * A Dependency is a Relationship that signifies that a single model Element or a set of model Elements requires other model Elements for their specification or implementation. This means that the complete semantics of the client Element(s) are either semantically or structurally dependent on the definition of the supplier Element(s).
    */
  trait UMLDependency
		extends UMLDirectedRelationship
		with UMLPackageableElement
  {}

  /**
    * A deployed artifact is an artifact or artifact instance that has been deployed to a deployment target.
    */
  trait UMLDeployedArtifact
		extends UMLNamedElement
  {}

  /**
    * A deployment is the allocation of an artifact or artifact instance to a deployment target.A component deployment is the deployment of one or more artifacts or artifact instances to a deployment target, optionally parameterized by a deployment specification. Examples are executables and configuration files.
    */
  trait UMLDeployment
		extends UMLDependency
  {}

  /**
    * A deployment specification specifies a set of properties that determine execution parameters of a component artifact that is deployed on a node. A deployment specification can be aimed at a specific type of container. An artifact that reifies or implements deployment specification properties is a deployment descriptor.
    */
  trait UMLDeploymentSpecification
		extends UMLArtifact
  {}

  /**
    * A deployment target is the location for a deployed artifact.
    */
  trait UMLDeploymentTarget
		extends UMLNamedElement
  {}

  /**
    * A DestroyLinkAction is a WriteLinkAction that destroys links (including link objects).
    */
  trait UMLDestroyLinkAction
		extends UMLWriteLinkAction
  {}

  /**
    * A DestroyObjectAction is an Action that destroys objects.
    */
  trait UMLDestroyObjectAction
		extends UMLAction
  {}

  /**
    * A DestructionOccurenceSpecification models the destruction of an object.
    */
  trait UMLDestructionOccurrenceSpecification
		extends UMLMessageOccurrenceSpecification
  {}

  /**
    * A device is a physical computational resource with processing capability upon which artifacts may be deployed for execution. Devices may be complex (i.e., they may consist of other devices).
    */
  trait UMLDevice
		extends UMLNode
  {}

  /**
    * A DirectedRelationship represents a relationship between a collection of source model Elements and a collection of target model Elements.
    */
  trait UMLDirectedRelationship
		extends UMLRelationship
  {}

  /**
    * A Duration is a ValueSpecification that specifies the temporal distance between two time instants.
    */
  trait UMLDuration
		extends UMLValueSpecification
  {}

  /**
    * A DurationConstraint is a Constraint that refers to a DurationInterval.
    */
  trait UMLDurationConstraint
		extends UMLIntervalConstraint
  {}

  /**
    * A DurationInterval defines the range between two Durations.
    */
  trait UMLDurationInterval
		extends UMLInterval
  {}

  /**
    * A DurationObservation is a reference to a duration during an execution. It points out the NamedElement(s) in the model to observe and whether the observations are when this NamedElement is entered or when it is exited.
    */
  trait UMLDurationObservation
		extends UMLObservation
  {}

  /**
    * An Element is a constituent of a model. As such, it has the capability of owning other Elements.
    */
  trait UMLElement
  {}

  /**
    * An ElementImport identifies a NamedElement in a Namespace other than the one that owns that NamedElement and allows the NamedElement to be referenced using an unqualified name in the Namespace owning the ElementImport.
    */
  trait UMLElementImport
		extends UMLDirectedRelationship
  {}

  /**
    * 
    */
  trait UMLElementValue
		extends UMLValueSpecification
  {}

  /**
    * An EncapsulatedClassifier may own Ports to specify typed interaction points.
    */
  trait UMLEncapsulatedClassifier
		extends UMLStructuredClassifier
  {}

  /**
    * An Enumeration is a DataType whose values are enumerated in the model as EnumerationLiterals.
    */
  trait UMLEnumeration
		extends UMLDataType
  {}

  /**
    * An EnumerationLiteral is a user-defined data value for an Enumeration.
    */
  trait UMLEnumerationLiteral
		extends UMLInstanceSpecification
  {}

  /**
    * An Event is the specification of some occurrence that may potentially trigger effects by an object.
    */
  trait UMLEvent
		extends UMLPackageableElement
  {}

  /**
    * An ExceptionHandler is an Element that specifies a handlerBody ExecutableNode to execute in case the specified exception occurs during the execution of the protected ExecutableNode.
    */
  trait UMLExceptionHandler
		extends UMLElement
  {}

  /**
    * An ExecutableNode is an abstract class for ActivityNodes whose execution may be controlled using ControlFlows and to which ExceptionHandlers may be attached.
    */
  trait UMLExecutableNode
		extends UMLActivityNode
  {}

  /**
    * An execution environment is a node that offers an execution environment for specific types of components that are deployed on it in the form of executable artifacts.
    */
  trait UMLExecutionEnvironment
		extends UMLNode
  {}

  /**
    * An ExecutionOccurrenceSpecification represents moments in time at which Actions or Behaviors start or finish.
    */
  trait UMLExecutionOccurrenceSpecification
		extends UMLOccurrenceSpecification
  {}

  /**
    * An ExecutionSpecification is a specification of the execution of a unit of Behavior or Action within the Lifeline. The duration of an ExecutionSpecification is represented by two OccurrenceSpecifications, the start OccurrenceSpecification and the finish OccurrenceSpecification.
    */
  trait UMLExecutionSpecification
		extends UMLInteractionFragment
  {}

  /**
    * An ExpansionNode is an ObjectNode used to indicate a collection input or output for an ExpansionRegion. A collection input of an ExpansionRegion contains a collection that is broken into its individual elements inside the region, whose content is executed once per element. A collection output of an ExpansionRegion combines individual elements produced by the execution of the region into a collection for use outside the region.
    */
  trait UMLExpansionNode
		extends UMLObjectNode
  {}

  /**
    * An ExpansionRegion is a StructuredActivityNode that executes its content multiple times corresponding to elements of input collection(s).
    */
  trait UMLExpansionRegion
		extends UMLStructuredActivityNode
  {}

  /**
    * An Expression represents a node in an expression tree, which may be non-terminal or terminal. It defines a symbol, and has a possibly empty sequence of operands that are ValueSpecifications. It denotes a (possibly empty) set of values when evaluated in a context.
    */
  trait UMLExpression
		extends UMLValueSpecification
  {}

  /**
    * A relationship from an extending UseCase to an extended UseCase that specifies how and when the behavior defined in the extending UseCase can be inserted into the behavior defined in the extended UseCase.
    */
  trait UMLExtend
		extends UMLDirectedRelationship
		with UMLNamedElement
  {}

  /**
    * An extension is used to indicate that the properties of a metaclass are extended through a stereotype, and gives the ability to flexibly add (and later remove) stereotypes to classes.
    */
  trait UMLExtension
		extends UMLAssociation
  {}

  /**
    * An extension end is used to tie an extension to a stereotype when extending a metaclass.The default multiplicity of an extension end is 0..1.
    */
  trait UMLExtensionEnd
		extends UMLProperty
  {}

  /**
    * An ExtensionPoint identifies a point in the behavior of a UseCase where that behavior can be extended by the behavior of some other (extending) UseCase, as specified by an Extend relationship.
    */
  trait UMLExtensionPoint
		extends UMLRedefinableElement
  {}

  /**
    * A Feature declares a behavioral or structural characteristic of Classifiers.
    */
  trait UMLFeature
		extends UMLRedefinableElement
  {}

  /**
    * A FinalNode is an abstract ControlNode at which a flow in an Activity stops.
    */
  trait UMLFinalNode
		extends UMLControlNode
  {}

  /**
    * A special kind of State, which, when entered, signifies that the enclosing Region has completed. If the enclosing Region is directly contained in a StateMachine and all other Regions in that StateMachine also are completed, then it means that the entire StateMachine behavior is completed.
    */
  trait UMLFinalState
		extends UMLState
  {}

  /**
    * A FlowFinalNode is a FinalNode that terminates a flow by consuming the tokens offered to it.
    */
  trait UMLFlowFinalNode
		extends UMLFinalNode
  {}

  /**
    * A ForkNode is a ControlNode that splits a flow into multiple concurrent flows.
    */
  trait UMLForkNode
		extends UMLControlNode
  {}

  /**
    * A FunctionBehavior is an OpaqueBehavior that does not access or modify any objects or other external data.
    */
  trait UMLFunctionBehavior
		extends UMLOpaqueBehavior
  {}

  /**
    * A Gate is a MessageEnd which serves as a connection point for relating a Message which has a MessageEnd (sendEvent / receiveEvent) outside an InteractionFragment with another Message which has a MessageEnd (receiveEvent / sendEvent)  inside that InteractionFragment.
    */
  trait UMLGate
		extends UMLMessageEnd
  {}

  /**
    * A GeneralOrdering represents a binary relation between two OccurrenceSpecifications, to describe that one OccurrenceSpecification must occur before the other in a valid trace. This mechanism provides the ability to define partial orders of OccurrenceSpecifications that may otherwise not have a specified order.
    */
  trait UMLGeneralOrdering
		extends UMLNamedElement
  {}

  /**
    * A Generalization is a taxonomic relationship between a more general Classifier and a more specific Classifier. Each instance of the specific Classifier is also an instance of the general Classifier. The specific Classifier inherits the features of the more general Classifier. A Generalization is owned by the specific Classifier.
    */
  trait UMLGeneralization
		extends UMLDirectedRelationship
  {}

  /**
    * A GeneralizationSet is a PackageableElement whose instances represent sets of Generalization relationships.
    */
  trait UMLGeneralizationSet
		extends UMLPackageableElement
  {}

  /**
    * Physical definition of a graphical image.
    */
  trait UMLImage
		extends UMLElement
  {}

  /**
    * An Include relationship specifies that a UseCase contains the behavior defined in another UseCase.
    */
  trait UMLInclude
		extends UMLDirectedRelationship
		with UMLNamedElement
  {}

  /**
    * InformationFlows describe circulation of information through a system in a general manner. They do not specify the nature of the information, mechanisms by which it is conveyed, sequences of exchange or any control conditions. During more detailed modeling, representation and realization links may be added to specify which model elements implement an InformationFlow and to show how information is conveyed.  InformationFlows require some kind of ?information channel? for unidirectional transmission of information items from sources to targets.? They specify the information channel?s realizations, if any, and identify the information that flows along them.? Information moving along the information channel may be represented by abstract InformationItems and by concrete Classifiers.
    */
  trait UMLInformationFlow
		extends UMLDirectedRelationship
		with UMLPackageableElement
  {}

  /**
    * InformationItems represent many kinds of information that can flow from sources to targets in very abstract ways.? They represent the kinds of information that may move within a system, but do not elaborate details of the transferred information.? Details of transferred information are the province of other Classifiers that may ultimately define InformationItems.? Consequently, InformationItems cannot be instantiated and do not themselves have features, generalizations, or associations.?An important use of InformationItems is to represent information during early design stages, possibly before the detailed modeling decisions that will ultimately define them have been made. Another purpose of InformationItems is to abstract portions of complex models in less precise, but perhaps more general and communicable, ways. 
    */
  trait UMLInformationItem
		extends UMLClassifier
  {}

  /**
    * An InitialNode is a ControlNode that offers a single control token when initially enabled.
    */
  trait UMLInitialNode
		extends UMLControlNode
  {}

  /**
    * An InputPin is a Pin that holds input values to be consumed by an Action.
    */
  trait UMLInputPin
		extends UMLPin
  {}

  /**
    * An InstanceSpecification is a model element that represents an instance in a modeled system. An InstanceSpecification can act as a DeploymentTarget in a Deployment relationship, in the case that it represents an instance of a Node. It can also act as a DeployedArtifact, if it represents an instance of an Artifact.
    */
  trait UMLInstanceSpecification
		extends UMLDeployedArtifact
		with UMLDeploymentTarget
		with UMLPackageableElement
  {}

  /**
    * An InstanceValue is a ValueSpecification that identifies an instance.
    */
  trait UMLInstanceValue
		extends UMLValueSpecification
  {}

  /**
    * An Interaction is a unit of Behavior that focuses on the observable exchange of information between connectable elements.
    */
  trait UMLInteraction
		extends UMLBehavior
		with UMLInteractionFragment
  {}

  /**
    * An InteractionConstraint is a Boolean expression that guards an operand in a CombinedFragment.
    */
  trait UMLInteractionConstraint
		extends UMLConstraint
  {}

  /**
    * InteractionFragment is an abstract notion of the most general interaction unit. An InteractionFragment is a piece of an Interaction. Each InteractionFragment is conceptually like an Interaction by itself.
    */
  trait UMLInteractionFragment
		extends UMLNamedElement
  {}

  /**
    * An InteractionOperand is contained in a CombinedFragment. An InteractionOperand represents one operand of the expression given by the enclosing CombinedFragment.
    */
  trait UMLInteractionOperand
		extends UMLInteractionFragment
		with UMLNamespace
  {}

  /**
    * An InteractionUse refers to an Interaction. The InteractionUse is a shorthand for copying the contents of the referenced Interaction where the InteractionUse is. To be accurate the copying must take into account substituting parameters with arguments and connect the formal Gates with the actual ones.
    */
  trait UMLInteractionUse
		extends UMLInteractionFragment
  {}

  /**
    * Interfaces declare coherent services that are implemented by BehavioredClassifiers that implement the Interfaces via InterfaceRealizations.
    */
  trait UMLInterface
		extends UMLClassifier
  {}

  /**
    * An InterfaceRealization is a specialized realization relationship between a BehavioredClassifier and an Interface. This relationship signifies that the realizing BehavioredClassifier conforms to the contract specified by the Interface.
    */
  trait UMLInterfaceRealization
		extends UMLRealization
  {}

  /**
    * An InterruptibleActivityRegion is an ActivityGroup that supports the termination of tokens flowing in the portions of an activity within it.
    */
  trait UMLInterruptibleActivityRegion
		extends UMLActivityGroup
  {}

  /**
    * An Interval defines the range between two ValueSpecifications.
    */
  trait UMLInterval
		extends UMLValueSpecification
  {}

  /**
    * An IntervalConstraint is a Constraint that is specified by an Interval.
    */
  trait UMLIntervalConstraint
		extends UMLConstraint
  {}

  /**
    * InvocationAction is an abstract class for the various actions that request Behavior invocation.
    */
  trait UMLInvocationAction
		extends UMLAction
  {}

  /**
    * A JoinNode is a ControlNode that synchronizes multiple flows.
    */
  trait UMLJoinNode
		extends UMLControlNode
  {}

  /**
    * A Lifeline represents an individual participant in the Interaction. While parts and structural features may have multiplicity greater than 1, Lifelines represent only one interacting entity.
    */
  trait UMLLifeline
		extends UMLNamedElement
  {}

  /**
    * LinkAction is an abstract class for all Actions that identify the links to be acted on using LinkEndData.
    */
  trait UMLLinkAction
		extends UMLAction
  {}

  /**
    * LinkEndCreationData is LinkEndData used to provide values for one end of a link to be created by a CreateLinkAction.
    */
  trait UMLLinkEndCreationData
		extends UMLLinkEndData
  {}

  /**
    * LinkEndData is an Element that identifies on end of a link to be read or written by a LinkAction. As a link (that is not a link object) cannot be passed as a runtime value to or from an Action, it is instead identified by its end objects and qualifier values, if any. A LinkEndData instance provides these values for a single Association end.
    */
  trait UMLLinkEndData
		extends UMLElement
  {}

  /**
    * LinkEndDestructionData is LinkEndData used to provide values for one end of a link to be destroyed by a DestroyLinkAction.
    */
  trait UMLLinkEndDestructionData
		extends UMLLinkEndData
  {}

  /**
    * A LiteralBoolean is a specification of a Boolean value.
    */
  trait UMLLiteralBoolean
		extends UMLLiteralSpecification
  {}

  /**
    * A LiteralInteger is a specification of an Integer value.
    */
  trait UMLLiteralInteger
		extends UMLLiteralSpecification
  {}

  /**
    * A LiteralNull specifies the lack of a value.
    */
  trait UMLLiteralNull
		extends UMLLiteralSpecification
  {}

  /**
    * A LiteralReal is a specification of a Real value.
    */
  trait UMLLiteralReal
		extends UMLLiteralSpecification
  {}

  /**
    * A LiteralSpecification identifies a literal constant being modeled.
    */
  trait UMLLiteralSpecification
		extends UMLValueSpecification
  {}

  /**
    * A LiteralString is a specification of a String value.
    */
  trait UMLLiteralString
		extends UMLLiteralSpecification
  {}

  /**
    * A LiteralUnlimitedNatural is a specification of an UnlimitedNatural number.
    */
  trait UMLLiteralUnlimitedNatural
		extends UMLLiteralSpecification
  {}

  /**
    * A LoopNode is a StructuredActivityNode that represents an iterative loop with setup, test, and body sections.
    */
  trait UMLLoopNode
		extends UMLStructuredActivityNode
  {}

  /**
    * A manifestation is the concrete physical rendering of one or more model elements by an artifact.
    */
  trait UMLManifestation
		extends UMLAbstraction
  {}

  /**
    * A merge node is a control node that brings together multiple alternate flows. It is not used to synchronize concurrent flows but to accept one among several alternate flows.
    */
  trait UMLMergeNode
		extends UMLControlNode
  {}

  /**
    * A Message defines a particular communication between Lifelines of an Interaction.
    */
  trait UMLMessage
		extends UMLNamedElement
  {}

  /**
    * MessageEnd is an abstract specialization of NamedElement that represents what can occur at the end of a Message.
    */
  trait UMLMessageEnd
		extends UMLNamedElement
  {}

  /**
    * A MessageEvent specifies the receipt by an object of either an Operation call or a Signal instance.
    */
  trait UMLMessageEvent
		extends UMLEvent
  {}

  /**
    * A MessageOccurrenceSpecification specifies the occurrence of Message events, such as sending and receiving of Signals or invoking or receiving of Operation calls. A MessageOccurrenceSpecification is a kind of MessageEnd. Messages are generated either by synchronous Operation calls or asynchronous Signal sends. They are received by the execution of corresponding AcceptEventActions.
    */
  trait UMLMessageOccurrenceSpecification
		extends UMLMessageEnd
		with UMLOccurrenceSpecification
  {}

  /**
    * A model captures a view of a physical system. It is an abstraction of the physical system, with a certain purpose. This purpose determines what is to be included in the model and what is irrelevant. Thus the model completely describes those aspects of the physical system that are relevant to the purpose of the model, at the appropriate level of detail.
    */
  trait UMLModel
		extends UMLPackage
  {}

  /**
    * A multiplicity is a definition of an inclusive interval of non-negative integers beginning with a lower bound and ending with a (possibly infinite) upper bound. A MultiplicityElement embeds this information to specify the allowable cardinalities for an instantiation of the Element.
    */
  trait UMLMultiplicityElement
		extends UMLElement
  {}

  /**
    * A NamedElement is an Element in a model that may have a name. The name may be given directly and/or via the use of a StringExpression.
    */
  trait UMLNamedElement
		extends UMLElement
  {}

  /**
    * A Namespace is an Element in a model that owns and/or imports a set of NamedElements that can be identified by name.
    */
  trait UMLNamespace
		extends UMLNamedElement
  {}

  /**
    * A Node is computational resource upon which artifacts may be deployed for execution. Nodes can be interconnected through communication paths to define network structures.
    */
  trait UMLNode
		extends UMLClass
		with UMLDeploymentTarget
  {}

  /**
    * An ObjectFlow is an ActivityEdge that is traversed by object tokens that may hold values. Object flows also support multicast/receive, token selection from object nodes, and transformation of tokens.
    */
  trait UMLObjectFlow
		extends UMLActivityEdge
  {}

  /**
    * An ObjectNode is an abstract ActivityNode that may hold tokens within the object flow in an Activity. ObjectNodes also support token selection, limitation on the number of tokens held, specification of the state required for tokens being held, and carrying control values.
    */
  trait UMLObjectNode
		extends UMLActivityNode
		with UMLTypedElement
  {}

  /**
    * Observation specifies a value determined by observing an event or events that occur relative to other model Elements.
    */
  trait UMLObservation
		extends UMLPackageableElement
  {}

  /**
    * An OccurrenceSpecification is the basic semantic unit of Interactions. The sequences of occurrences specified by them are the meanings of Interactions.
    */
  trait UMLOccurrenceSpecification
		extends UMLInteractionFragment
  {}

  /**
    * An OpaqueAction is an Action whose functionality is not specified within UML.
    */
  trait UMLOpaqueAction
		extends UMLAction
  {}

  /**
    * An OpaqueBehavior is a Behavior whose specification is given in a textual language other than UML.
    */
  trait UMLOpaqueBehavior
		extends UMLBehavior
  {}

  /**
    * An OpaqueExpression is a ValueSpecification that specifies the computation of a collection of values either in terms of a UML Behavior or based on a textual statement in a language other than UML
    */
  trait UMLOpaqueExpression
		extends UMLValueSpecification
  {}

  /**
    * An Operation is a BehavioralFeature of a Classifier that specifies the name, type, parameters, and constraints for invoking an associated Behavior. An Operation may invoke both the execution of method behaviors as well as other behavioral responses. Operation specializes TemplateableElement in order to support specification of template operations and bound operations. Operation specializes ParameterableElement to specify that an operation can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
    */
  trait UMLOperation
		extends UMLBehavioralFeature
		with UMLParameterableElement
		with UMLTemplateableElement
  {}

  /**
    * An OperationTemplateParameter exposes an Operation as a formal parameter for a template.
    */
  trait UMLOperationTemplateParameter
		extends UMLTemplateParameter
  {}

  /**
    * An OutputPin is a Pin that holds output values produced by an Action.
    */
  trait UMLOutputPin
		extends UMLPin
  {}

  /**
    * A package can have one or more profile applications to indicate which profiles have been applied. Because a profile is a package, it is possible to apply a profile not only to packages, but also to profiles.Package specializes TemplateableElement and PackageableElement specializes ParameterableElement to specify that a package can be used as a template and a PackageableElement as a template parameter.A package is used to group elements, and provides a namespace for the grouped elements.
    */
  trait UMLPackage
		extends UMLNamespace
		with UMLPackageableElement
		with UMLTemplateableElement
  {}

  /**
    * A PackageImport is a Relationship that imports all the non-private members of a Package into the Namespace owning the PackageImport, so that those Elements may be referred to by their unqualified names in the importingNamespace.
    */
  trait UMLPackageImport
		extends UMLDirectedRelationship
  {}

  /**
    * A package merge defines how the contents of one package are extended by the contents of another package.
    */
  trait UMLPackageMerge
		extends UMLDirectedRelationship
  {}

  /**
    * A PackageableElement is a NamedElement that may be owned directly by a Package. A PackageableElement is also able to serve as the parameteredElement of a TemplateParameter.
    */
  trait UMLPackageableElement
		extends UMLNamedElement
		with UMLParameterableElement
  {}

  /**
    * A Parameter is a specification of an argument used to pass information into or out of an invocation of a BehavioralFeature.  Parameters can be treated as ConnectableElements within Collaborations.
    */
  trait UMLParameter
		extends UMLConnectableElement
		with UMLMultiplicityElement
  {}

  /**
    * A ParameterSet designates alternative sets of inputs or outputs that a Behavior may use.
    */
  trait UMLParameterSet
		extends UMLNamedElement
  {}

  /**
    * A ParameterableElement is an Element that can be exposed as a formal TemplateParameter for a template, or specified as an actual parameter in a binding of a template.
    */
  trait UMLParameterableElement
		extends UMLElement
  {}

  /**
    * A PartDecomposition is a description of the internal Interactions of one Lifeline relative to an Interaction.
    */
  trait UMLPartDecomposition
		extends UMLInteractionUse
  {}

  /**
    * A Pin is an ObjectNode and MultiplicityElement that provides input values to an Action or accepts output values from an Action.
    */
  trait UMLPin
		extends UMLMultiplicityElement
		with UMLObjectNode
  {}

  /**
    * A Port is a property of an EncapsulatedClassifier that specifies a distinct interaction point between that EncapsulatedClassifier and its environment or between the (behavior of the) EncapsulatedClassifier and its internal parts. Ports are connected to Properties of the EncapsulatedClassifier by Connectors through which requests can be made to invoke BehavioralFeatures. A Port may specify the services an EncapsulatedClassifier provides (offers) to its environment as well as the services that an EncapsulatedClassifier expects (requires) of its environment.  A Port may have an associated ProtocolStateMachine.
    */
  trait UMLPort
		extends UMLProperty
  {}

  /**
    * A PrimitiveType defines a predefined DataType, without any substructure. A PrimitiveType may have an algebra and operations defined outside of UML, for example, mathematically.
    */
  trait UMLPrimitiveType
		extends UMLDataType
  {}

  /**
    * A profile defines limited extensions to a reference metamodel with the purpose of adapting the metamodel to a specific platform or domain.
    */
  trait UMLProfile
		extends UMLPackage
  {}

  /**
    * A profile application is used to show which profiles have been applied to a package.
    */
  trait UMLProfileApplication
		extends UMLDirectedRelationship
  {}

  /**
    * A Property is a StructuralFeature. A Property related by ownedAttribute to a Classifier (other than an association) represents an attribute and might also represent an association end. It relates an instance of the Classifier to a value or set of values of the type of the attribute. A Property related by memberEnd to an Association represents an end of the Association. The type of the Property is the type of the end of the Association. A Property has the capability of being a DeploymentTarget in a Deployment relationship. This enables modeling the deployment to hierarchical nodes that have Properties functioning as internal parts.  Property specializes ParameterableElement to specify that a Property can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
    */
  trait UMLProperty
		extends UMLConnectableElement
		with UMLDeploymentTarget
		with UMLStructuralFeature
  {}

  /**
    * A ProtocolStateMachine can be redefined into a more specific ProtocolStateMachine or into behavioral StateMachine. ProtocolConformance declares that the specific ProtocolStateMachine specifies a protocol that conforms to the general ProtocolStateMachine or that the specific behavioral StateMachine abides by the protocol of the general ProtocolStateMachine.
    */
  trait UMLProtocolConformance
		extends UMLDirectedRelationship
  {}

  /**
    * A ProtocolStateMachine is always defined in the context of a Classifier. It specifies which BehavioralFeatures of the Classifier can be called in which State and under which conditions, thus specifying the allowed invocation sequences on the Classifier's BehavioralFeatures. A ProtocolStateMachine specifies the possible and permitted Transitions on the instances of its context Classifier, together with the BehavioralFeatures that carry the Transitions. In this manner, an instance lifecycle can be specified for a Classifier, by defining the order in which the BehavioralFeatures can be activated and the States through which an instance progresses during its existence.
    */
  trait UMLProtocolStateMachine
		extends UMLStateMachine
  {}

  /**
    * A ProtocolTransition specifies a legal Transition for an Operation. Transitions of ProtocolStateMachines have the following information: a pre-condition (guard), a Trigger, and a post-condition. Every ProtocolTransition is associated with at most one BehavioralFeature belonging to the context Classifier of the ProtocolStateMachine.
    */
  trait UMLProtocolTransition
		extends UMLTransition
  {}

  /**
    * A Pseudostate is an abstraction that encompasses different types of transient Vertices in the StateMachine graph. A StateMachine instance never comes to rest in a Pseudostate, instead, it will exit and enter the Pseudostate within a single run-to-completion step.
    */
  trait UMLPseudostate
		extends UMLVertex
  {}

  /**
    * A QualifierValue is an Element that is used as part of LinkEndData to provide the value for a single qualifier of the end given by the LinkEndData.
    */
  trait UMLQualifierValue
		extends UMLElement
  {}

  /**
    * A RaiseExceptionAction is an Action that causes an exception to occur. The input value becomes the exception object.
    */
  trait UMLRaiseExceptionAction
		extends UMLAction
  {}

  /**
    * A ReadExtentAction is an Action that retrieves the current instances of a Classifier.
    */
  trait UMLReadExtentAction
		extends UMLAction
  {}

  /**
    * A ReadIsClassifiedObjectAction is an Action that determines whether an object is classified by a given Classifier.
    */
  trait UMLReadIsClassifiedObjectAction
		extends UMLAction
  {}

  /**
    * A ReadLinkAction is a LinkAction that navigates across an Association to retrieve the objects on one end.
    */
  trait UMLReadLinkAction
		extends UMLLinkAction
  {}

  /**
    * A ReadLinkObjectEndAction is an Action that retrieves an end object from a link object.
    */
  trait UMLReadLinkObjectEndAction
		extends UMLAction
  {}

  /**
    * A ReadLinkObjectEndQualifierAction is an Action that retrieves a qualifier end value from a link object.
    */
  trait UMLReadLinkObjectEndQualifierAction
		extends UMLAction
  {}

  /**
    * A ReadSelfAction is an Action that retrieves the context object of the Behavior execution within which the ReadSelfAction execution is taking place.
    */
  trait UMLReadSelfAction
		extends UMLAction
  {}

  /**
    * A ReadStructuralFeatureAction is a StructuralFeatureAction that retrieves the values of a StructuralFeature.
    */
  trait UMLReadStructuralFeatureAction
		extends UMLStructuralFeatureAction
  {}

  /**
    * A ReadVariableAction is a VariableAction that retrieves the values of a Variable.
    */
  trait UMLReadVariableAction
		extends UMLVariableAction
  {}

  /**
    * Realization is a specialized Abstraction relationship between two sets of model Elements, one representing a specification (the supplier) and the other represents an implementation of the latter (the client). Realization can be used to model stepwise refinement, optimizations, transformations, templates, model synthesis, framework composition, etc.
    */
  trait UMLRealization
		extends UMLAbstraction
  {}

  /**
    * A Reception is a declaration stating that a Classifier is prepared to react to the receipt of a Signal.
    */
  trait UMLReception
		extends UMLBehavioralFeature
  {}

  /**
    * A ReclassifyObjectAction is an Action that changes the Classifiers that classify an object.
    */
  trait UMLReclassifyObjectAction
		extends UMLAction
  {}

  /**
    * A RedefinableElement is an element that, when defined in the context of a Classifier, can be redefined more specifically or differently in the context of another Classifier that specializes (directly or indirectly) the context Classifier.
    */
  trait UMLRedefinableElement
		extends UMLNamedElement
  {}

  /**
    * A RedefinableTemplateSignature supports the addition of formal template parameters in a specialization of a template classifier.
    */
  trait UMLRedefinableTemplateSignature
		extends UMLRedefinableElement
		with UMLTemplateSignature
  {}

  /**
    * A ReduceAction is an Action that reduces a collection to a single value by repeatedly combining the elements of the collection using a reducer Behavior.
    */
  trait UMLReduceAction
		extends UMLAction
  {}

  /**
    * A Region is a top-level part of a StateMachine or a composite State, that serves as a container for the Vertices and Transitions of the StateMachine. A StateMachine or composite State may contain multiple Regions representing behaviors that may occur in parallel.
    */
  trait UMLRegion
		extends UMLNamespace
		with UMLRedefinableElement
  {}

  /**
    * Relationship is an abstract concept that specifies some kind of relationship between Elements.
    */
  trait UMLRelationship
		extends UMLElement
  {}

  /**
    * A RemoveStructuralFeatureValueAction is a WriteStructuralFeatureAction that removes values from a StructuralFeature.
    */
  trait UMLRemoveStructuralFeatureValueAction
		extends UMLWriteStructuralFeatureAction
  {}

  /**
    * A RemoveVariableValueAction is a WriteVariableAction that removes values from a Variables.
    */
  trait UMLRemoveVariableValueAction
		extends UMLWriteVariableAction
  {}

  /**
    * A ReplyAction is an Action that accepts a set of reply values and a value containing return information produced by a previous AcceptCallAction. The ReplyAction returns the values to the caller of the previous call, completing execution of the call.
    */
  trait UMLReplyAction
		extends UMLAction
  {}

  /**
    * A SendObjectAction is an InvocationAction that transmits an input object to the target object, which is handled as a request message by the target object. The requestor continues execution immediately after the object is sent out and cannot receive reply values.
    */
  trait UMLSendObjectAction
		extends UMLInvocationAction
  {}

  /**
    * A SendSignalAction is an InvocationAction that creates a Signal instance and transmits it to the target object. Values from the argument InputPins are used to provide values for the attributes of the Signal. The requestor continues execution immediately after the Signal instance is sent out and cannot receive reply values.
    */
  trait UMLSendSignalAction
		extends UMLInvocationAction
  {}

  /**
    * A SequenceNode is a StructuredActivityNode that executes a sequence of ExecutableNodes in order.
    */
  trait UMLSequenceNode
		extends UMLStructuredActivityNode
  {}

  /**
    * A Signal is a specification of a kind of communication between objects in which a reaction is asynchronously triggered in the receiver without a reply.
    */
  trait UMLSignal
		extends UMLClassifier
  {}

  /**
    * A SignalEvent represents the receipt of an asynchronous Signal instance.
    */
  trait UMLSignalEvent
		extends UMLMessageEvent
  {}

  /**
    * A Slot designates that an entity modeled by an InstanceSpecification has a value or values for a specific StructuralFeature.
    */
  trait UMLSlot
		extends UMLElement
  {}

  /**
    * A StartClassifierBehaviorAction is an Action that starts the classifierBehavior of the input object.
    */
  trait UMLStartClassifierBehaviorAction
		extends UMLAction
  {}

  /**
    * A StartObjectBehaviorAction is an InvocationAction that starts the execution either of a directly instantiated Behavior or of the classifierBehavior of an object. Argument values may be supplied for the input Parameters of the Behavior. If the Behavior is invoked synchronously, then output values may be obtained for output Parameters.
    */
  trait UMLStartObjectBehaviorAction
		extends UMLCallAction
  {}

  /**
    * A State models a situation during which some (usually implicit) invariant condition holds.
    */
  trait UMLState
		extends UMLNamespace
		with UMLRedefinableElement
		with UMLVertex
  {}

  /**
    * A StateInvariant is a runtime constraint on the participants of the Interaction. It may be used to specify a variety of different kinds of Constraints, such as values of Attributes or Variables, internal or external States, and so on. A StateInvariant is an InteractionFragment and it is placed on a Lifeline.
    */
  trait UMLStateInvariant
		extends UMLInteractionFragment
  {}

  /**
    * StateMachines can be used to express event-driven behaviors of parts of a system. Behavior is modeled as a traversal of a graph of Vertices interconnected by one or more joined Transition arcs that are triggered by the dispatching of successive Event occurrences. During this traversal, the StateMachine may execute a sequence of Behaviors associated with various elements of the StateMachine.
    */
  trait UMLStateMachine
		extends UMLBehavior
  {}

  /**
    * A stereotype defines how an existing metaclass may be extended, and enables the use of platform or domain specific terminology or notation in place of, or in addition to, the ones used for the extended metaclass.
    */
  trait UMLStereotype
		extends UMLClass
  {}

  /**
    * A StringExpression is an Expression that specifies a String value that is derived by concatenating a sequence of operands with String values or a sequence of subExpressions, some of which might be template parameters.
    */
  trait UMLStringExpression
		extends UMLExpression
		with UMLTemplateableElement
  {}

  /**
    * A StructuralFeature is a typed feature of a Classifier that specifies the structure of instances of the Classifier.
    */
  trait UMLStructuralFeature
		extends UMLFeature
		with UMLMultiplicityElement
		with UMLTypedElement
  {}

  /**
    * StructuralFeatureAction is an abstract class for all Actions that operate on StructuralFeatures.
    */
  trait UMLStructuralFeatureAction
		extends UMLAction
  {}

  /**
    * A StructuredActivityNode is an Action that is also an ActivityGroup and whose behavior is specified by the ActivityNodes and ActivityEdges it so contains. Unlike other kinds of ActivityGroup, a StructuredActivityNode owns the ActivityNodes and ActivityEdges it contains, and so a node or edge can only be directly contained in one StructuredActivityNode, though StructuredActivityNodes may be nested.
    */
  trait UMLStructuredActivityNode
		extends UMLAction
		with UMLActivityGroup
		with UMLNamespace
  {}

  /**
    * StructuredClassifiers may contain an internal structure of connected elements each of which plays a role in the overall Behavior modeled by the StructuredClassifier.
    */
  trait UMLStructuredClassifier
		extends UMLClassifier
  {}

  /**
    * A substitution is a relationship between two classifiers signifying that the substituting classifier complies with the contract specified by the contract classifier. This implies that instances of the substituting classifier are runtime substitutable where instances of the contract classifier are expected.
    */
  trait UMLSubstitution
		extends UMLRealization
  {}

  /**
    * A TemplateBinding is a DirectedRelationship between a TemplateableElement and a template. A TemplateBinding specifies the TemplateParameterSubstitutions of actual parameters for the formal parameters of the template.
    */
  trait UMLTemplateBinding
		extends UMLDirectedRelationship
  {}

  /**
    * A TemplateParameter exposes a ParameterableElement as a formal parameter of a template.
    */
  trait UMLTemplateParameter
		extends UMLElement
  {}

  /**
    * A TemplateParameterSubstitution relates the actual parameter to a formal TemplateParameter as part of a template binding.
    */
  trait UMLTemplateParameterSubstitution
		extends UMLElement
  {}

  /**
    * A Template Signature bundles the set of formal TemplateParameters for a template.
    */
  trait UMLTemplateSignature
		extends UMLElement
  {}

  /**
    * A TemplateableElement is an Element that can optionally be defined as a template and bound to other templates.
    */
  trait UMLTemplateableElement
		extends UMLElement
  {}

  /**
    * A TestIdentityAction is an Action that tests if two values are identical objects.
    */
  trait UMLTestIdentityAction
		extends UMLAction
  {}

  /**
    * A TimeConstraint is a Constraint that refers to a TimeInterval.
    */
  trait UMLTimeConstraint
		extends UMLIntervalConstraint
  {}

  /**
    * A TimeEvent is an Event that occurs at a specific point in time.
    */
  trait UMLTimeEvent
		extends UMLEvent
  {}

  /**
    * A TimeExpression is a ValueSpecification that represents a time value.
    */
  trait UMLTimeExpression
		extends UMLValueSpecification
  {}

  /**
    * A TimeInterval defines the range between two TimeExpressions.
    */
  trait UMLTimeInterval
		extends UMLInterval
  {}

  /**
    * A TimeObservation is a reference to a time instant during an execution. It points out the NamedElement in the model to observe and whether the observation is when this NamedElement is entered or when it is exited.
    */
  trait UMLTimeObservation
		extends UMLObservation
  {}

  /**
    * A Transition represents an arc between exactly one source Vertex and exactly one Target vertex (the source and targets may be the same Vertex). It may form part of a compound transition, which takes the StateMachine from one steady State configuration to another, representing the full response of the StateMachine to an occurrence of an Event that triggered it.
    */
  trait UMLTransition
		extends UMLNamespace
		with UMLRedefinableElement
  {}

  /**
    * A Trigger specifies a specific point  at which an Event occurrence may trigger an effect in a Behavior. A Trigger may be qualified by the Port on which the Event occurred.
    */
  trait UMLTrigger
		extends UMLNamedElement
  {}

  /**
    * A Type constrains the values represented by a TypedElement.
    */
  trait UMLType
		extends UMLPackageableElement
  {}

  /**
    * A TypedElement is a NamedElement that may have a Type specified for it.
    */
  trait UMLTypedElement
		extends UMLNamedElement
  {}

  /**
    * An UnmarshallAction is an Action that retrieves the values of the StructuralFeatures of an object and places them on OutputPins. 
    */
  trait UMLUnmarshallAction
		extends UMLAction
  {}

  /**
    * A Usage is a Dependency in which the client Element requires the supplier Element (or set of Elements) for its full implementation or operation.
    */
  trait UMLUsage
		extends UMLDependency
  {}

  /**
    * A UseCase specifies a set of actions performed by its subjects, which yields an observable result that is of value for one or more Actors or other stakeholders of each subject.
    */
  trait UMLUseCase
		extends UMLBehavioredClassifier
  {}

  /**
    * A ValuePin is an InputPin that provides a value by evaluating a ValueSpecification.
    */
  trait UMLValuePin
		extends UMLInputPin
  {}

  /**
    * A ValueSpecification is the specification of a (possibly empty) set of values. A ValueSpecification is a ParameterableElement that may be exposed as a formal TemplateParameter and provided as the actual parameter in the binding of a template.
    */
  trait UMLValueSpecification
		extends UMLPackageableElement
		with UMLTypedElement
  {}

  /**
    * A ValueSpecificationAction is an Action that evaluates a ValueSpecification and provides a result.
    */
  trait UMLValueSpecificationAction
		extends UMLAction
  {}

  /**
    * A Variable is a ConnectableElement that may store values during the execution of an Activity. Reading and writing the values of a Variable provides an alternative means for passing data than the use of ObjectFlows. A Variable may be owned directly by an Activity, in which case it is accessible from anywhere within that activity, or it may be owned by a StructuredActivityNode, in which case it is only accessible within that node.
    */
  trait UMLVariable
		extends UMLConnectableElement
		with UMLMultiplicityElement
  {}

  /**
    * VariableAction is an abstract class for Actions that operate on a specified Variable.
    */
  trait UMLVariableAction
		extends UMLAction
  {}

  /**
    * A Vertex is an abstraction of a node in a StateMachine graph. It can be the source or destination of any number of Transitions.
    */
  trait UMLVertex
		extends UMLNamedElement
  {}

  /**
    * WriteLinkAction is an abstract class for LinkActions that create and destroy links.
    */
  trait UMLWriteLinkAction
		extends UMLLinkAction
  {}

  /**
    * WriteStructuralFeatureAction is an abstract class for StructuralFeatureActions that change StructuralFeature values.
    */
  trait UMLWriteStructuralFeatureAction
		extends UMLStructuralFeatureAction
  {}

  /**
    * WriteVariableAction is an abstract class for VariableActions that change Variable values.
    */
  trait UMLWriteVariableAction
		extends UMLVariableAction
  {}

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLAbstraction
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLAbstraction
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLAbstraction
  {}

  object OTIUMLAbstraction {

    implicit def reads
    : Reads[OTIUMLAbstraction]
    = Json.reads[OTIUMLAbstraction]

    implicit def writes
    : Writes[OTIUMLAbstraction]
    = Json.writes[OTIUMLAbstraction]

    implicit def formats
    : Format[OTIUMLAbstraction]
    = Json.format[OTIUMLAbstraction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLAcceptCallAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isUnmarshall Defined in AcceptEventAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLAcceptCallAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isUnmarshall: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLAcceptCallAction
  {}

  object OTIUMLAcceptCallAction {

    implicit def reads
    : Reads[OTIUMLAcceptCallAction]
    = Json.reads[OTIUMLAcceptCallAction]

    implicit def writes
    : Writes[OTIUMLAcceptCallAction]
    = Json.writes[OTIUMLAcceptCallAction]

    implicit def formats
    : Format[OTIUMLAcceptCallAction]
    = Json.format[OTIUMLAcceptCallAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLAcceptEventAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isUnmarshall Defined in AcceptEventAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLAcceptEventAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isUnmarshall: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLAcceptEventAction
  {}

  object OTIUMLAcceptEventAction {

    implicit def reads
    : Reads[OTIUMLAcceptEventAction]
    = Json.reads[OTIUMLAcceptEventAction]

    implicit def writes
    : Writes[OTIUMLAcceptEventAction]
    = Json.writes[OTIUMLAcceptEventAction]

    implicit def formats
    : Format[OTIUMLAcceptEventAction]
    = Json.format[OTIUMLAcceptEventAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLActionExecutionSpecification
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLActionExecutionSpecification
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLActionExecutionSpecification
  {}

  object OTIUMLActionExecutionSpecification {

    implicit def reads
    : Reads[OTIUMLActionExecutionSpecification]
    = Json.reads[OTIUMLActionExecutionSpecification]

    implicit def writes
    : Writes[OTIUMLActionExecutionSpecification]
    = Json.writes[OTIUMLActionExecutionSpecification]

    implicit def formats
    : Format[OTIUMLActionExecutionSpecification]
    = Json.format[OTIUMLActionExecutionSpecification]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLActionInputPin
    * @param isControl Defined in Pin
    * @param isControlType Defined in ObjectNode
    * @param isLeaf Defined in RedefinableElement
    * @param isOrdered Defined in MultiplicityElement
    * @param isUnique Defined in MultiplicityElement
    * @param name Defined in NamedElement
    * @param ordering Defined in ObjectNode
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLActionInputPin
  ( override val otiMOFElementLocation: ElementLocation,
    isControl: Boolean,
    isControlType: Boolean,
    isLeaf: Boolean,
    isOrdered: Boolean,
    isUnique: Boolean,
    name: Option[String],
    ordering: Option[UMLObjectNodeOrderingKind],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLActionInputPin
  {}

  object OTIUMLActionInputPin {

    implicit def reads
    : Reads[OTIUMLActionInputPin]
    = Json.reads[OTIUMLActionInputPin]

    implicit def writes
    : Writes[OTIUMLActionInputPin]
    = Json.writes[OTIUMLActionInputPin]

    implicit def formats
    : Format[OTIUMLActionInputPin]
    = Json.format[OTIUMLActionInputPin]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLActivity
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param isReadOnly Defined in Activity
    * @param isReentrant Defined in Behavior
    * @param isSingleExecution Defined in Activity
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLActivity
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    isReadOnly: Boolean,
    isReentrant: Boolean,
    isSingleExecution: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLActivity
  {}

  object OTIUMLActivity {

    implicit def reads
    : Reads[OTIUMLActivity]
    = Json.reads[OTIUMLActivity]

    implicit def writes
    : Writes[OTIUMLActivity]
    = Json.writes[OTIUMLActivity]

    implicit def formats
    : Format[OTIUMLActivity]
    = Json.format[OTIUMLActivity]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLActivityFinalNode
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLActivityFinalNode
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLActivityFinalNode
  {}

  object OTIUMLActivityFinalNode {

    implicit def reads
    : Reads[OTIUMLActivityFinalNode]
    = Json.reads[OTIUMLActivityFinalNode]

    implicit def writes
    : Writes[OTIUMLActivityFinalNode]
    = Json.writes[OTIUMLActivityFinalNode]

    implicit def formats
    : Format[OTIUMLActivityFinalNode]
    = Json.format[OTIUMLActivityFinalNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLActivityParameterNode
    * @param isControlType Defined in ObjectNode
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param ordering Defined in ObjectNode
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLActivityParameterNode
  ( override val otiMOFElementLocation: ElementLocation,
    isControlType: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    ordering: Option[UMLObjectNodeOrderingKind],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLActivityParameterNode
  {}

  object OTIUMLActivityParameterNode {

    implicit def reads
    : Reads[OTIUMLActivityParameterNode]
    = Json.reads[OTIUMLActivityParameterNode]

    implicit def writes
    : Writes[OTIUMLActivityParameterNode]
    = Json.writes[OTIUMLActivityParameterNode]

    implicit def formats
    : Format[OTIUMLActivityParameterNode]
    = Json.format[OTIUMLActivityParameterNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLActivityPartition
    * @param isDimension Defined in ActivityPartition
    * @param isExternal Defined in ActivityPartition
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLActivityPartition
  ( override val otiMOFElementLocation: ElementLocation,
    isDimension: Boolean,
    isExternal: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLActivityPartition
  {}

  object OTIUMLActivityPartition {

    implicit def reads
    : Reads[OTIUMLActivityPartition]
    = Json.reads[OTIUMLActivityPartition]

    implicit def writes
    : Writes[OTIUMLActivityPartition]
    = Json.writes[OTIUMLActivityPartition]

    implicit def formats
    : Format[OTIUMLActivityPartition]
    = Json.format[OTIUMLActivityPartition]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLActor
    * @param isAbstract Defined in Classifier
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLActor
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLActor
  {}

  object OTIUMLActor {

    implicit def reads
    : Reads[OTIUMLActor]
    = Json.reads[OTIUMLActor]

    implicit def writes
    : Writes[OTIUMLActor]
    = Json.writes[OTIUMLActor]

    implicit def formats
    : Format[OTIUMLActor]
    = Json.format[OTIUMLActor]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLAddStructuralFeatureValueAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isReplaceAll Defined in AddStructuralFeatureValueAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLAddStructuralFeatureValueAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isReplaceAll: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLAddStructuralFeatureValueAction
  {}

  object OTIUMLAddStructuralFeatureValueAction {

    implicit def reads
    : Reads[OTIUMLAddStructuralFeatureValueAction]
    = Json.reads[OTIUMLAddStructuralFeatureValueAction]

    implicit def writes
    : Writes[OTIUMLAddStructuralFeatureValueAction]
    = Json.writes[OTIUMLAddStructuralFeatureValueAction]

    implicit def formats
    : Format[OTIUMLAddStructuralFeatureValueAction]
    = Json.format[OTIUMLAddStructuralFeatureValueAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLAddVariableValueAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isReplaceAll Defined in AddVariableValueAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLAddVariableValueAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isReplaceAll: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLAddVariableValueAction
  {}

  object OTIUMLAddVariableValueAction {

    implicit def reads
    : Reads[OTIUMLAddVariableValueAction]
    = Json.reads[OTIUMLAddVariableValueAction]

    implicit def writes
    : Writes[OTIUMLAddVariableValueAction]
    = Json.writes[OTIUMLAddVariableValueAction]

    implicit def formats
    : Format[OTIUMLAddVariableValueAction]
    = Json.format[OTIUMLAddVariableValueAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLAnyReceiveEvent
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLAnyReceiveEvent
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLAnyReceiveEvent
  {}

  object OTIUMLAnyReceiveEvent {

    implicit def reads
    : Reads[OTIUMLAnyReceiveEvent]
    = Json.reads[OTIUMLAnyReceiveEvent]

    implicit def writes
    : Writes[OTIUMLAnyReceiveEvent]
    = Json.writes[OTIUMLAnyReceiveEvent]

    implicit def formats
    : Format[OTIUMLAnyReceiveEvent]
    = Json.format[OTIUMLAnyReceiveEvent]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLArtifact
    * @param fileName Defined in Artifact
    * @param isAbstract Defined in Classifier
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLArtifact
  ( override val otiMOFElementLocation: ElementLocation,
    fileName: Option[String],
    isAbstract: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLArtifact
  {}

  object OTIUMLArtifact {

    implicit def reads
    : Reads[OTIUMLArtifact]
    = Json.reads[OTIUMLArtifact]

    implicit def writes
    : Writes[OTIUMLArtifact]
    = Json.writes[OTIUMLArtifact]

    implicit def formats
    : Format[OTIUMLArtifact]
    = Json.format[OTIUMLArtifact]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLAssociation
    * @param isAbstract Defined in Classifier
    * @param isDerived Defined in Association
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLAssociation
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isDerived: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLAssociation
  {}

  object OTIUMLAssociation {

    implicit def reads
    : Reads[OTIUMLAssociation]
    = Json.reads[OTIUMLAssociation]

    implicit def writes
    : Writes[OTIUMLAssociation]
    = Json.writes[OTIUMLAssociation]

    implicit def formats
    : Format[OTIUMLAssociation]
    = Json.format[OTIUMLAssociation]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLAssociationClass
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isDerived Defined in Association
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLAssociationClass
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isActive: Boolean,
    isDerived: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLAssociationClass
  {}

  object OTIUMLAssociationClass {

    implicit def reads
    : Reads[OTIUMLAssociationClass]
    = Json.reads[OTIUMLAssociationClass]

    implicit def writes
    : Writes[OTIUMLAssociationClass]
    = Json.writes[OTIUMLAssociationClass]

    implicit def formats
    : Format[OTIUMLAssociationClass]
    = Json.format[OTIUMLAssociationClass]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLBehaviorExecutionSpecification
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLBehaviorExecutionSpecification
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLBehaviorExecutionSpecification
  {}

  object OTIUMLBehaviorExecutionSpecification {

    implicit def reads
    : Reads[OTIUMLBehaviorExecutionSpecification]
    = Json.reads[OTIUMLBehaviorExecutionSpecification]

    implicit def writes
    : Writes[OTIUMLBehaviorExecutionSpecification]
    = Json.writes[OTIUMLBehaviorExecutionSpecification]

    implicit def formats
    : Format[OTIUMLBehaviorExecutionSpecification]
    = Json.format[OTIUMLBehaviorExecutionSpecification]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLBroadcastSignalAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLBroadcastSignalAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLBroadcastSignalAction
  {}

  object OTIUMLBroadcastSignalAction {

    implicit def reads
    : Reads[OTIUMLBroadcastSignalAction]
    = Json.reads[OTIUMLBroadcastSignalAction]

    implicit def writes
    : Writes[OTIUMLBroadcastSignalAction]
    = Json.writes[OTIUMLBroadcastSignalAction]

    implicit def formats
    : Format[OTIUMLBroadcastSignalAction]
    = Json.format[OTIUMLBroadcastSignalAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLCallBehaviorAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isSynchronous Defined in CallAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLCallBehaviorAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isSynchronous: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLCallBehaviorAction
  {}

  object OTIUMLCallBehaviorAction {

    implicit def reads
    : Reads[OTIUMLCallBehaviorAction]
    = Json.reads[OTIUMLCallBehaviorAction]

    implicit def writes
    : Writes[OTIUMLCallBehaviorAction]
    = Json.writes[OTIUMLCallBehaviorAction]

    implicit def formats
    : Format[OTIUMLCallBehaviorAction]
    = Json.format[OTIUMLCallBehaviorAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLCallEvent
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLCallEvent
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLCallEvent
  {}

  object OTIUMLCallEvent {

    implicit def reads
    : Reads[OTIUMLCallEvent]
    = Json.reads[OTIUMLCallEvent]

    implicit def writes
    : Writes[OTIUMLCallEvent]
    = Json.writes[OTIUMLCallEvent]

    implicit def formats
    : Format[OTIUMLCallEvent]
    = Json.format[OTIUMLCallEvent]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLCallOperationAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isSynchronous Defined in CallAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLCallOperationAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isSynchronous: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLCallOperationAction
  {}

  object OTIUMLCallOperationAction {

    implicit def reads
    : Reads[OTIUMLCallOperationAction]
    = Json.reads[OTIUMLCallOperationAction]

    implicit def writes
    : Writes[OTIUMLCallOperationAction]
    = Json.writes[OTIUMLCallOperationAction]

    implicit def formats
    : Format[OTIUMLCallOperationAction]
    = Json.format[OTIUMLCallOperationAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLCentralBufferNode
    * @param isControlType Defined in ObjectNode
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param ordering Defined in ObjectNode
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLCentralBufferNode
  ( override val otiMOFElementLocation: ElementLocation,
    isControlType: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    ordering: Option[UMLObjectNodeOrderingKind],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLCentralBufferNode
  {}

  object OTIUMLCentralBufferNode {

    implicit def reads
    : Reads[OTIUMLCentralBufferNode]
    = Json.reads[OTIUMLCentralBufferNode]

    implicit def writes
    : Writes[OTIUMLCentralBufferNode]
    = Json.writes[OTIUMLCentralBufferNode]

    implicit def formats
    : Format[OTIUMLCentralBufferNode]
    = Json.format[OTIUMLCentralBufferNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLChangeEvent
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLChangeEvent
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLChangeEvent
  {}

  object OTIUMLChangeEvent {

    implicit def reads
    : Reads[OTIUMLChangeEvent]
    = Json.reads[OTIUMLChangeEvent]

    implicit def writes
    : Writes[OTIUMLChangeEvent]
    = Json.writes[OTIUMLChangeEvent]

    implicit def formats
    : Format[OTIUMLChangeEvent]
    = Json.format[OTIUMLChangeEvent]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLClass
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLClass
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLClass
  {}

  object OTIUMLClass {

    implicit def reads
    : Reads[OTIUMLClass]
    = Json.reads[OTIUMLClass]

    implicit def writes
    : Writes[OTIUMLClass]
    = Json.writes[OTIUMLClass]

    implicit def formats
    : Format[OTIUMLClass]
    = Json.format[OTIUMLClass]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLClassifierTemplateParameter
    * @param allowSubstitutable Defined in ClassifierTemplateParameter
    */
  case class OTIUMLClassifierTemplateParameter
  ( override val otiMOFElementLocation: ElementLocation,
    allowSubstitutable: Boolean)
  extends OTIMOFElement
  with UMLClassifierTemplateParameter
  {}

  object OTIUMLClassifierTemplateParameter {

    implicit def reads
    : Reads[OTIUMLClassifierTemplateParameter]
    = Json.reads[OTIUMLClassifierTemplateParameter]

    implicit def writes
    : Writes[OTIUMLClassifierTemplateParameter]
    = Json.writes[OTIUMLClassifierTemplateParameter]

    implicit def formats
    : Format[OTIUMLClassifierTemplateParameter]
    = Json.format[OTIUMLClassifierTemplateParameter]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLClause
    */
  case class OTIUMLClause
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLClause
  {}

  object OTIUMLClause {

    implicit def reads
    : Reads[OTIUMLClause]
    = Json.reads[OTIUMLClause]

    implicit def writes
    : Writes[OTIUMLClause]
    = Json.writes[OTIUMLClause]

    implicit def formats
    : Format[OTIUMLClause]
    = Json.format[OTIUMLClause]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLClearAssociationAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLClearAssociationAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLClearAssociationAction
  {}

  object OTIUMLClearAssociationAction {

    implicit def reads
    : Reads[OTIUMLClearAssociationAction]
    = Json.reads[OTIUMLClearAssociationAction]

    implicit def writes
    : Writes[OTIUMLClearAssociationAction]
    = Json.writes[OTIUMLClearAssociationAction]

    implicit def formats
    : Format[OTIUMLClearAssociationAction]
    = Json.format[OTIUMLClearAssociationAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLClearStructuralFeatureAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLClearStructuralFeatureAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLClearStructuralFeatureAction
  {}

  object OTIUMLClearStructuralFeatureAction {

    implicit def reads
    : Reads[OTIUMLClearStructuralFeatureAction]
    = Json.reads[OTIUMLClearStructuralFeatureAction]

    implicit def writes
    : Writes[OTIUMLClearStructuralFeatureAction]
    = Json.writes[OTIUMLClearStructuralFeatureAction]

    implicit def formats
    : Format[OTIUMLClearStructuralFeatureAction]
    = Json.format[OTIUMLClearStructuralFeatureAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLClearVariableAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLClearVariableAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLClearVariableAction
  {}

  object OTIUMLClearVariableAction {

    implicit def reads
    : Reads[OTIUMLClearVariableAction]
    = Json.reads[OTIUMLClearVariableAction]

    implicit def writes
    : Writes[OTIUMLClearVariableAction]
    = Json.writes[OTIUMLClearVariableAction]

    implicit def formats
    : Format[OTIUMLClearVariableAction]
    = Json.format[OTIUMLClearVariableAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLCollaboration
    * @param isAbstract Defined in Classifier
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLCollaboration
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLCollaboration
  {}

  object OTIUMLCollaboration {

    implicit def reads
    : Reads[OTIUMLCollaboration]
    = Json.reads[OTIUMLCollaboration]

    implicit def writes
    : Writes[OTIUMLCollaboration]
    = Json.writes[OTIUMLCollaboration]

    implicit def formats
    : Format[OTIUMLCollaboration]
    = Json.format[OTIUMLCollaboration]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLCollaborationUse
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLCollaborationUse
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLCollaborationUse
  {}

  object OTIUMLCollaborationUse {

    implicit def reads
    : Reads[OTIUMLCollaborationUse]
    = Json.reads[OTIUMLCollaborationUse]

    implicit def writes
    : Writes[OTIUMLCollaborationUse]
    = Json.writes[OTIUMLCollaborationUse]

    implicit def formats
    : Format[OTIUMLCollaborationUse]
    = Json.format[OTIUMLCollaborationUse]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLCombinedFragment
    * @param interactionOperator Defined in CombinedFragment
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLCombinedFragment
  ( override val otiMOFElementLocation: ElementLocation,
    interactionOperator: Option[UMLInteractionOperatorKind],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLCombinedFragment
  {}

  object OTIUMLCombinedFragment {

    implicit def reads
    : Reads[OTIUMLCombinedFragment]
    = Json.reads[OTIUMLCombinedFragment]

    implicit def writes
    : Writes[OTIUMLCombinedFragment]
    = Json.writes[OTIUMLCombinedFragment]

    implicit def formats
    : Format[OTIUMLCombinedFragment]
    = Json.format[OTIUMLCombinedFragment]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLComment
    * @param body Defined in Comment
    */
  case class OTIUMLComment
  ( override val otiMOFElementLocation: ElementLocation,
    body: Option[String])
  extends OTIMOFElement
  with UMLComment
  {}

  object OTIUMLComment {

    implicit def reads
    : Reads[OTIUMLComment]
    = Json.reads[OTIUMLComment]

    implicit def writes
    : Writes[OTIUMLComment]
    = Json.writes[OTIUMLComment]

    implicit def formats
    : Format[OTIUMLComment]
    = Json.format[OTIUMLComment]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLCommunicationPath
    * @param isAbstract Defined in Classifier
    * @param isDerived Defined in Association
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLCommunicationPath
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isDerived: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLCommunicationPath
  {}

  object OTIUMLCommunicationPath {

    implicit def reads
    : Reads[OTIUMLCommunicationPath]
    = Json.reads[OTIUMLCommunicationPath]

    implicit def writes
    : Writes[OTIUMLCommunicationPath]
    = Json.writes[OTIUMLCommunicationPath]

    implicit def formats
    : Format[OTIUMLCommunicationPath]
    = Json.format[OTIUMLCommunicationPath]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLComponent
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isIndirectlyInstantiated Defined in Component
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLComponent
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isIndirectlyInstantiated: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLComponent
  {}

  object OTIUMLComponent {

    implicit def reads
    : Reads[OTIUMLComponent]
    = Json.reads[OTIUMLComponent]

    implicit def writes
    : Writes[OTIUMLComponent]
    = Json.writes[OTIUMLComponent]

    implicit def formats
    : Format[OTIUMLComponent]
    = Json.format[OTIUMLComponent]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLComponentRealization
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLComponentRealization
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLComponentRealization
  {}

  object OTIUMLComponentRealization {

    implicit def reads
    : Reads[OTIUMLComponentRealization]
    = Json.reads[OTIUMLComponentRealization]

    implicit def writes
    : Writes[OTIUMLComponentRealization]
    = Json.writes[OTIUMLComponentRealization]

    implicit def formats
    : Format[OTIUMLComponentRealization]
    = Json.format[OTIUMLComponentRealization]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLConditionalNode
    * @param isAssured Defined in ConditionalNode
    * @param isDeterminate Defined in ConditionalNode
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param mustIsolate Defined in StructuredActivityNode
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLConditionalNode
  ( override val otiMOFElementLocation: ElementLocation,
    isAssured: Boolean,
    isDeterminate: Boolean,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    mustIsolate: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLConditionalNode
  {}

  object OTIUMLConditionalNode {

    implicit def reads
    : Reads[OTIUMLConditionalNode]
    = Json.reads[OTIUMLConditionalNode]

    implicit def writes
    : Writes[OTIUMLConditionalNode]
    = Json.writes[OTIUMLConditionalNode]

    implicit def formats
    : Format[OTIUMLConditionalNode]
    = Json.format[OTIUMLConditionalNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLConnectableElementTemplateParameter
    */
  case class OTIUMLConnectableElementTemplateParameter
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLConnectableElementTemplateParameter
  {}

  object OTIUMLConnectableElementTemplateParameter {

    implicit def reads
    : Reads[OTIUMLConnectableElementTemplateParameter]
    = Json.reads[OTIUMLConnectableElementTemplateParameter]

    implicit def writes
    : Writes[OTIUMLConnectableElementTemplateParameter]
    = Json.writes[OTIUMLConnectableElementTemplateParameter]

    implicit def formats
    : Format[OTIUMLConnectableElementTemplateParameter]
    = Json.format[OTIUMLConnectableElementTemplateParameter]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLConnectionPointReference
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLConnectionPointReference
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLConnectionPointReference
  {}

  object OTIUMLConnectionPointReference {

    implicit def reads
    : Reads[OTIUMLConnectionPointReference]
    = Json.reads[OTIUMLConnectionPointReference]

    implicit def writes
    : Writes[OTIUMLConnectionPointReference]
    = Json.writes[OTIUMLConnectionPointReference]

    implicit def formats
    : Format[OTIUMLConnectionPointReference]
    = Json.format[OTIUMLConnectionPointReference]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLConnector
    * @param isLeaf Defined in RedefinableElement
    * @param isStatic Defined in Feature
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLConnector
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isStatic: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLConnector
  {}

  object OTIUMLConnector {

    implicit def reads
    : Reads[OTIUMLConnector]
    = Json.reads[OTIUMLConnector]

    implicit def writes
    : Writes[OTIUMLConnector]
    = Json.writes[OTIUMLConnector]

    implicit def formats
    : Format[OTIUMLConnector]
    = Json.format[OTIUMLConnector]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLConnectorEnd
    * @param isOrdered Defined in MultiplicityElement
    * @param isUnique Defined in MultiplicityElement
    */
  case class OTIUMLConnectorEnd
  ( override val otiMOFElementLocation: ElementLocation,
    isOrdered: Boolean,
    isUnique: Boolean)
  extends OTIMOFElement
  with UMLConnectorEnd
  {}

  object OTIUMLConnectorEnd {

    implicit def reads
    : Reads[OTIUMLConnectorEnd]
    = Json.reads[OTIUMLConnectorEnd]

    implicit def writes
    : Writes[OTIUMLConnectorEnd]
    = Json.writes[OTIUMLConnectorEnd]

    implicit def formats
    : Format[OTIUMLConnectorEnd]
    = Json.format[OTIUMLConnectorEnd]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLConsiderIgnoreFragment
    * @param interactionOperator Defined in CombinedFragment
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLConsiderIgnoreFragment
  ( override val otiMOFElementLocation: ElementLocation,
    interactionOperator: Option[UMLInteractionOperatorKind],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLConsiderIgnoreFragment
  {}

  object OTIUMLConsiderIgnoreFragment {

    implicit def reads
    : Reads[OTIUMLConsiderIgnoreFragment]
    = Json.reads[OTIUMLConsiderIgnoreFragment]

    implicit def writes
    : Writes[OTIUMLConsiderIgnoreFragment]
    = Json.writes[OTIUMLConsiderIgnoreFragment]

    implicit def formats
    : Format[OTIUMLConsiderIgnoreFragment]
    = Json.format[OTIUMLConsiderIgnoreFragment]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLConstraint
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLConstraint
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLConstraint
  {}

  object OTIUMLConstraint {

    implicit def reads
    : Reads[OTIUMLConstraint]
    = Json.reads[OTIUMLConstraint]

    implicit def writes
    : Writes[OTIUMLConstraint]
    = Json.writes[OTIUMLConstraint]

    implicit def formats
    : Format[OTIUMLConstraint]
    = Json.format[OTIUMLConstraint]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLContinuation
    * @param name Defined in NamedElement
    * @param setting Defined in Continuation
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLContinuation
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    setting: Boolean,
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLContinuation
  {}

  object OTIUMLContinuation {

    implicit def reads
    : Reads[OTIUMLContinuation]
    = Json.reads[OTIUMLContinuation]

    implicit def writes
    : Writes[OTIUMLContinuation]
    = Json.writes[OTIUMLContinuation]

    implicit def formats
    : Format[OTIUMLContinuation]
    = Json.format[OTIUMLContinuation]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLControlFlow
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLControlFlow
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLControlFlow
  {}

  object OTIUMLControlFlow {

    implicit def reads
    : Reads[OTIUMLControlFlow]
    = Json.reads[OTIUMLControlFlow]

    implicit def writes
    : Writes[OTIUMLControlFlow]
    = Json.writes[OTIUMLControlFlow]

    implicit def formats
    : Format[OTIUMLControlFlow]
    = Json.format[OTIUMLControlFlow]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLCreateLinkAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLCreateLinkAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLCreateLinkAction
  {}

  object OTIUMLCreateLinkAction {

    implicit def reads
    : Reads[OTIUMLCreateLinkAction]
    = Json.reads[OTIUMLCreateLinkAction]

    implicit def writes
    : Writes[OTIUMLCreateLinkAction]
    = Json.writes[OTIUMLCreateLinkAction]

    implicit def formats
    : Format[OTIUMLCreateLinkAction]
    = Json.format[OTIUMLCreateLinkAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLCreateLinkObjectAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLCreateLinkObjectAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLCreateLinkObjectAction
  {}

  object OTIUMLCreateLinkObjectAction {

    implicit def reads
    : Reads[OTIUMLCreateLinkObjectAction]
    = Json.reads[OTIUMLCreateLinkObjectAction]

    implicit def writes
    : Writes[OTIUMLCreateLinkObjectAction]
    = Json.writes[OTIUMLCreateLinkObjectAction]

    implicit def formats
    : Format[OTIUMLCreateLinkObjectAction]
    = Json.format[OTIUMLCreateLinkObjectAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLCreateObjectAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLCreateObjectAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLCreateObjectAction
  {}

  object OTIUMLCreateObjectAction {

    implicit def reads
    : Reads[OTIUMLCreateObjectAction]
    = Json.reads[OTIUMLCreateObjectAction]

    implicit def writes
    : Writes[OTIUMLCreateObjectAction]
    = Json.writes[OTIUMLCreateObjectAction]

    implicit def formats
    : Format[OTIUMLCreateObjectAction]
    = Json.format[OTIUMLCreateObjectAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDataStoreNode
    * @param isControlType Defined in ObjectNode
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param ordering Defined in ObjectNode
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLDataStoreNode
  ( override val otiMOFElementLocation: ElementLocation,
    isControlType: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    ordering: Option[UMLObjectNodeOrderingKind],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDataStoreNode
  {}

  object OTIUMLDataStoreNode {

    implicit def reads
    : Reads[OTIUMLDataStoreNode]
    = Json.reads[OTIUMLDataStoreNode]

    implicit def writes
    : Writes[OTIUMLDataStoreNode]
    = Json.writes[OTIUMLDataStoreNode]

    implicit def formats
    : Format[OTIUMLDataStoreNode]
    = Json.format[OTIUMLDataStoreNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDataType
    * @param isAbstract Defined in Classifier
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLDataType
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDataType
  {}

  object OTIUMLDataType {

    implicit def reads
    : Reads[OTIUMLDataType]
    = Json.reads[OTIUMLDataType]

    implicit def writes
    : Writes[OTIUMLDataType]
    = Json.writes[OTIUMLDataType]

    implicit def formats
    : Format[OTIUMLDataType]
    = Json.format[OTIUMLDataType]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDecisionNode
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLDecisionNode
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDecisionNode
  {}

  object OTIUMLDecisionNode {

    implicit def reads
    : Reads[OTIUMLDecisionNode]
    = Json.reads[OTIUMLDecisionNode]

    implicit def writes
    : Writes[OTIUMLDecisionNode]
    = Json.writes[OTIUMLDecisionNode]

    implicit def formats
    : Format[OTIUMLDecisionNode]
    = Json.format[OTIUMLDecisionNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDependency
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLDependency
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDependency
  {}

  object OTIUMLDependency {

    implicit def reads
    : Reads[OTIUMLDependency]
    = Json.reads[OTIUMLDependency]

    implicit def writes
    : Writes[OTIUMLDependency]
    = Json.writes[OTIUMLDependency]

    implicit def formats
    : Format[OTIUMLDependency]
    = Json.format[OTIUMLDependency]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDeployment
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLDeployment
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDeployment
  {}

  object OTIUMLDeployment {

    implicit def reads
    : Reads[OTIUMLDeployment]
    = Json.reads[OTIUMLDeployment]

    implicit def writes
    : Writes[OTIUMLDeployment]
    = Json.writes[OTIUMLDeployment]

    implicit def formats
    : Format[OTIUMLDeployment]
    = Json.format[OTIUMLDeployment]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDeploymentSpecification
    * @param deploymentLocation Defined in DeploymentSpecification
    * @param executionLocation Defined in DeploymentSpecification
    * @param fileName Defined in Artifact
    * @param isAbstract Defined in Classifier
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLDeploymentSpecification
  ( override val otiMOFElementLocation: ElementLocation,
    deploymentLocation: Option[String],
    executionLocation: Option[String],
    fileName: Option[String],
    isAbstract: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDeploymentSpecification
  {}

  object OTIUMLDeploymentSpecification {

    implicit def reads
    : Reads[OTIUMLDeploymentSpecification]
    = Json.reads[OTIUMLDeploymentSpecification]

    implicit def writes
    : Writes[OTIUMLDeploymentSpecification]
    = Json.writes[OTIUMLDeploymentSpecification]

    implicit def formats
    : Format[OTIUMLDeploymentSpecification]
    = Json.format[OTIUMLDeploymentSpecification]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDestroyLinkAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLDestroyLinkAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDestroyLinkAction
  {}

  object OTIUMLDestroyLinkAction {

    implicit def reads
    : Reads[OTIUMLDestroyLinkAction]
    = Json.reads[OTIUMLDestroyLinkAction]

    implicit def writes
    : Writes[OTIUMLDestroyLinkAction]
    = Json.writes[OTIUMLDestroyLinkAction]

    implicit def formats
    : Format[OTIUMLDestroyLinkAction]
    = Json.format[OTIUMLDestroyLinkAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDestroyObjectAction
    * @param isDestroyLinks Defined in DestroyObjectAction
    * @param isDestroyOwnedObjects Defined in DestroyObjectAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLDestroyObjectAction
  ( override val otiMOFElementLocation: ElementLocation,
    isDestroyLinks: Boolean,
    isDestroyOwnedObjects: Boolean,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDestroyObjectAction
  {}

  object OTIUMLDestroyObjectAction {

    implicit def reads
    : Reads[OTIUMLDestroyObjectAction]
    = Json.reads[OTIUMLDestroyObjectAction]

    implicit def writes
    : Writes[OTIUMLDestroyObjectAction]
    = Json.writes[OTIUMLDestroyObjectAction]

    implicit def formats
    : Format[OTIUMLDestroyObjectAction]
    = Json.format[OTIUMLDestroyObjectAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDestructionOccurrenceSpecification
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLDestructionOccurrenceSpecification
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDestructionOccurrenceSpecification
  {}

  object OTIUMLDestructionOccurrenceSpecification {

    implicit def reads
    : Reads[OTIUMLDestructionOccurrenceSpecification]
    = Json.reads[OTIUMLDestructionOccurrenceSpecification]

    implicit def writes
    : Writes[OTIUMLDestructionOccurrenceSpecification]
    = Json.writes[OTIUMLDestructionOccurrenceSpecification]

    implicit def formats
    : Format[OTIUMLDestructionOccurrenceSpecification]
    = Json.format[OTIUMLDestructionOccurrenceSpecification]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDevice
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLDevice
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDevice
  {}

  object OTIUMLDevice {

    implicit def reads
    : Reads[OTIUMLDevice]
    = Json.reads[OTIUMLDevice]

    implicit def writes
    : Writes[OTIUMLDevice]
    = Json.writes[OTIUMLDevice]

    implicit def formats
    : Format[OTIUMLDevice]
    = Json.format[OTIUMLDevice]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDuration
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLDuration
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDuration
  {}

  object OTIUMLDuration {

    implicit def reads
    : Reads[OTIUMLDuration]
    = Json.reads[OTIUMLDuration]

    implicit def writes
    : Writes[OTIUMLDuration]
    = Json.writes[OTIUMLDuration]

    implicit def formats
    : Format[OTIUMLDuration]
    = Json.format[OTIUMLDuration]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDurationConstraint
    * @param firstEvent Defined in DurationConstraint
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLDurationConstraint
  ( override val otiMOFElementLocation: ElementLocation,
    firstEvent: Set[Boolean],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDurationConstraint
  {}

  object OTIUMLDurationConstraint {

    implicit def reads
    : Reads[OTIUMLDurationConstraint]
    = Json.reads[OTIUMLDurationConstraint]

    implicit def writes
    : Writes[OTIUMLDurationConstraint]
    = Json.writes[OTIUMLDurationConstraint]

    implicit def formats
    : Format[OTIUMLDurationConstraint]
    = Json.format[OTIUMLDurationConstraint]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDurationInterval
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLDurationInterval
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDurationInterval
  {}

  object OTIUMLDurationInterval {

    implicit def reads
    : Reads[OTIUMLDurationInterval]
    = Json.reads[OTIUMLDurationInterval]

    implicit def writes
    : Writes[OTIUMLDurationInterval]
    = Json.writes[OTIUMLDurationInterval]

    implicit def formats
    : Format[OTIUMLDurationInterval]
    = Json.format[OTIUMLDurationInterval]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLDurationObservation
    * @param firstEvent Defined in DurationObservation
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLDurationObservation
  ( override val otiMOFElementLocation: ElementLocation,
    firstEvent: Seq[Boolean],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLDurationObservation
  {}

  object OTIUMLDurationObservation {

    implicit def reads
    : Reads[OTIUMLDurationObservation]
    = Json.reads[OTIUMLDurationObservation]

    implicit def writes
    : Writes[OTIUMLDurationObservation]
    = Json.writes[OTIUMLDurationObservation]

    implicit def formats
    : Format[OTIUMLDurationObservation]
    = Json.format[OTIUMLDurationObservation]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLElementImport
    * @param alias Defined in ElementImport
    * @param visibility Defined in ElementImport
    */
  case class OTIUMLElementImport
  ( override val otiMOFElementLocation: ElementLocation,
    alias: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLElementImport
  {}

  object OTIUMLElementImport {

    implicit def reads
    : Reads[OTIUMLElementImport]
    = Json.reads[OTIUMLElementImport]

    implicit def writes
    : Writes[OTIUMLElementImport]
    = Json.writes[OTIUMLElementImport]

    implicit def formats
    : Format[OTIUMLElementImport]
    = Json.format[OTIUMLElementImport]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLElementValue
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLElementValue
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLElementValue
  {}

  object OTIUMLElementValue {

    implicit def reads
    : Reads[OTIUMLElementValue]
    = Json.reads[OTIUMLElementValue]

    implicit def writes
    : Writes[OTIUMLElementValue]
    = Json.writes[OTIUMLElementValue]

    implicit def formats
    : Format[OTIUMLElementValue]
    = Json.format[OTIUMLElementValue]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLEnumeration
    * @param isAbstract Defined in Classifier
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLEnumeration
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLEnumeration
  {}

  object OTIUMLEnumeration {

    implicit def reads
    : Reads[OTIUMLEnumeration]
    = Json.reads[OTIUMLEnumeration]

    implicit def writes
    : Writes[OTIUMLEnumeration]
    = Json.writes[OTIUMLEnumeration]

    implicit def formats
    : Format[OTIUMLEnumeration]
    = Json.format[OTIUMLEnumeration]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLEnumerationLiteral
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLEnumerationLiteral
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLEnumerationLiteral
  {}

  object OTIUMLEnumerationLiteral {

    implicit def reads
    : Reads[OTIUMLEnumerationLiteral]
    = Json.reads[OTIUMLEnumerationLiteral]

    implicit def writes
    : Writes[OTIUMLEnumerationLiteral]
    = Json.writes[OTIUMLEnumerationLiteral]

    implicit def formats
    : Format[OTIUMLEnumerationLiteral]
    = Json.format[OTIUMLEnumerationLiteral]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLExceptionHandler
    */
  case class OTIUMLExceptionHandler
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLExceptionHandler
  {}

  object OTIUMLExceptionHandler {

    implicit def reads
    : Reads[OTIUMLExceptionHandler]
    = Json.reads[OTIUMLExceptionHandler]

    implicit def writes
    : Writes[OTIUMLExceptionHandler]
    = Json.writes[OTIUMLExceptionHandler]

    implicit def formats
    : Format[OTIUMLExceptionHandler]
    = Json.format[OTIUMLExceptionHandler]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLExecutionEnvironment
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLExecutionEnvironment
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLExecutionEnvironment
  {}

  object OTIUMLExecutionEnvironment {

    implicit def reads
    : Reads[OTIUMLExecutionEnvironment]
    = Json.reads[OTIUMLExecutionEnvironment]

    implicit def writes
    : Writes[OTIUMLExecutionEnvironment]
    = Json.writes[OTIUMLExecutionEnvironment]

    implicit def formats
    : Format[OTIUMLExecutionEnvironment]
    = Json.format[OTIUMLExecutionEnvironment]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLExecutionOccurrenceSpecification
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLExecutionOccurrenceSpecification
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLExecutionOccurrenceSpecification
  {}

  object OTIUMLExecutionOccurrenceSpecification {

    implicit def reads
    : Reads[OTIUMLExecutionOccurrenceSpecification]
    = Json.reads[OTIUMLExecutionOccurrenceSpecification]

    implicit def writes
    : Writes[OTIUMLExecutionOccurrenceSpecification]
    = Json.writes[OTIUMLExecutionOccurrenceSpecification]

    implicit def formats
    : Format[OTIUMLExecutionOccurrenceSpecification]
    = Json.format[OTIUMLExecutionOccurrenceSpecification]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLExpansionNode
    * @param isControlType Defined in ObjectNode
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param ordering Defined in ObjectNode
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLExpansionNode
  ( override val otiMOFElementLocation: ElementLocation,
    isControlType: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    ordering: Option[UMLObjectNodeOrderingKind],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLExpansionNode
  {}

  object OTIUMLExpansionNode {

    implicit def reads
    : Reads[OTIUMLExpansionNode]
    = Json.reads[OTIUMLExpansionNode]

    implicit def writes
    : Writes[OTIUMLExpansionNode]
    = Json.writes[OTIUMLExpansionNode]

    implicit def formats
    : Format[OTIUMLExpansionNode]
    = Json.format[OTIUMLExpansionNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLExpansionRegion
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param mode Defined in ExpansionRegion
    * @param mustIsolate Defined in StructuredActivityNode
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLExpansionRegion
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    mode: Option[UMLExpansionKind],
    mustIsolate: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLExpansionRegion
  {}

  object OTIUMLExpansionRegion {

    implicit def reads
    : Reads[OTIUMLExpansionRegion]
    = Json.reads[OTIUMLExpansionRegion]

    implicit def writes
    : Writes[OTIUMLExpansionRegion]
    = Json.writes[OTIUMLExpansionRegion]

    implicit def formats
    : Format[OTIUMLExpansionRegion]
    = Json.format[OTIUMLExpansionRegion]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLExpression
    * @param name Defined in NamedElement
    * @param symbol Defined in Expression
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLExpression
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    symbol: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLExpression
  {}

  object OTIUMLExpression {

    implicit def reads
    : Reads[OTIUMLExpression]
    = Json.reads[OTIUMLExpression]

    implicit def writes
    : Writes[OTIUMLExpression]
    = Json.writes[OTIUMLExpression]

    implicit def formats
    : Format[OTIUMLExpression]
    = Json.format[OTIUMLExpression]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLExtend
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLExtend
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLExtend
  {}

  object OTIUMLExtend {

    implicit def reads
    : Reads[OTIUMLExtend]
    = Json.reads[OTIUMLExtend]

    implicit def writes
    : Writes[OTIUMLExtend]
    = Json.writes[OTIUMLExtend]

    implicit def formats
    : Format[OTIUMLExtend]
    = Json.format[OTIUMLExtend]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLExtension
    * @param isAbstract Defined in Classifier
    * @param isDerived Defined in Association
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLExtension
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isDerived: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLExtension
  {}

  object OTIUMLExtension {

    implicit def reads
    : Reads[OTIUMLExtension]
    = Json.reads[OTIUMLExtension]

    implicit def writes
    : Writes[OTIUMLExtension]
    = Json.writes[OTIUMLExtension]

    implicit def formats
    : Format[OTIUMLExtension]
    = Json.format[OTIUMLExtension]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLExtensionEnd
    * @param aggregation Defined in Property
    * @param isDerived Defined in Property
    * @param isDerivedUnion Defined in Property
    * @param isID Defined in Property
    * @param isLeaf Defined in RedefinableElement
    * @param isOrdered Defined in MultiplicityElement
    * @param isReadOnly Defined in StructuralFeature
    * @param isStatic Defined in Feature
    * @param isUnique Defined in MultiplicityElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLExtensionEnd
  ( override val otiMOFElementLocation: ElementLocation,
    aggregation: Option[UMLAggregationKind],
    isDerived: Boolean,
    isDerivedUnion: Boolean,
    isID: Boolean,
    isLeaf: Boolean,
    isOrdered: Boolean,
    isReadOnly: Boolean,
    isStatic: Boolean,
    isUnique: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLExtensionEnd
  {}

  object OTIUMLExtensionEnd {

    implicit def reads
    : Reads[OTIUMLExtensionEnd]
    = Json.reads[OTIUMLExtensionEnd]

    implicit def writes
    : Writes[OTIUMLExtensionEnd]
    = Json.writes[OTIUMLExtensionEnd]

    implicit def formats
    : Format[OTIUMLExtensionEnd]
    = Json.format[OTIUMLExtensionEnd]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLExtensionPoint
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLExtensionPoint
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLExtensionPoint
  {}

  object OTIUMLExtensionPoint {

    implicit def reads
    : Reads[OTIUMLExtensionPoint]
    = Json.reads[OTIUMLExtensionPoint]

    implicit def writes
    : Writes[OTIUMLExtensionPoint]
    = Json.writes[OTIUMLExtensionPoint]

    implicit def formats
    : Format[OTIUMLExtensionPoint]
    = Json.format[OTIUMLExtensionPoint]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLFinalState
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLFinalState
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLFinalState
  {}

  object OTIUMLFinalState {

    implicit def reads
    : Reads[OTIUMLFinalState]
    = Json.reads[OTIUMLFinalState]

    implicit def writes
    : Writes[OTIUMLFinalState]
    = Json.writes[OTIUMLFinalState]

    implicit def formats
    : Format[OTIUMLFinalState]
    = Json.format[OTIUMLFinalState]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLFlowFinalNode
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLFlowFinalNode
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLFlowFinalNode
  {}

  object OTIUMLFlowFinalNode {

    implicit def reads
    : Reads[OTIUMLFlowFinalNode]
    = Json.reads[OTIUMLFlowFinalNode]

    implicit def writes
    : Writes[OTIUMLFlowFinalNode]
    = Json.writes[OTIUMLFlowFinalNode]

    implicit def formats
    : Format[OTIUMLFlowFinalNode]
    = Json.format[OTIUMLFlowFinalNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLForkNode
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLForkNode
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLForkNode
  {}

  object OTIUMLForkNode {

    implicit def reads
    : Reads[OTIUMLForkNode]
    = Json.reads[OTIUMLForkNode]

    implicit def writes
    : Writes[OTIUMLForkNode]
    = Json.writes[OTIUMLForkNode]

    implicit def formats
    : Format[OTIUMLForkNode]
    = Json.format[OTIUMLForkNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLFunctionBehavior
    * @param body Defined in OpaqueBehavior
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param isReentrant Defined in Behavior
    * @param language Defined in OpaqueBehavior
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLFunctionBehavior
  ( override val otiMOFElementLocation: ElementLocation,
    body: Seq[String],
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    isReentrant: Boolean,
    language: Seq[String],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLFunctionBehavior
  {}

  object OTIUMLFunctionBehavior {

    implicit def reads
    : Reads[OTIUMLFunctionBehavior]
    = Json.reads[OTIUMLFunctionBehavior]

    implicit def writes
    : Writes[OTIUMLFunctionBehavior]
    = Json.writes[OTIUMLFunctionBehavior]

    implicit def formats
    : Format[OTIUMLFunctionBehavior]
    = Json.format[OTIUMLFunctionBehavior]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLGate
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLGate
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLGate
  {}

  object OTIUMLGate {

    implicit def reads
    : Reads[OTIUMLGate]
    = Json.reads[OTIUMLGate]

    implicit def writes
    : Writes[OTIUMLGate]
    = Json.writes[OTIUMLGate]

    implicit def formats
    : Format[OTIUMLGate]
    = Json.format[OTIUMLGate]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLGeneralOrdering
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLGeneralOrdering
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLGeneralOrdering
  {}

  object OTIUMLGeneralOrdering {

    implicit def reads
    : Reads[OTIUMLGeneralOrdering]
    = Json.reads[OTIUMLGeneralOrdering]

    implicit def writes
    : Writes[OTIUMLGeneralOrdering]
    = Json.writes[OTIUMLGeneralOrdering]

    implicit def formats
    : Format[OTIUMLGeneralOrdering]
    = Json.format[OTIUMLGeneralOrdering]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLGeneralization
    * @param isSubstitutable Defined in Generalization
    */
  case class OTIUMLGeneralization
  ( override val otiMOFElementLocation: ElementLocation,
    isSubstitutable: Option[Boolean])
  extends OTIMOFElement
  with UMLGeneralization
  {}

  object OTIUMLGeneralization {

    implicit def reads
    : Reads[OTIUMLGeneralization]
    = Json.reads[OTIUMLGeneralization]

    implicit def writes
    : Writes[OTIUMLGeneralization]
    = Json.writes[OTIUMLGeneralization]

    implicit def formats
    : Format[OTIUMLGeneralization]
    = Json.format[OTIUMLGeneralization]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLGeneralizationSet
    * @param isCovering Defined in GeneralizationSet
    * @param isDisjoint Defined in GeneralizationSet
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLGeneralizationSet
  ( override val otiMOFElementLocation: ElementLocation,
    isCovering: Boolean,
    isDisjoint: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLGeneralizationSet
  {}

  object OTIUMLGeneralizationSet {

    implicit def reads
    : Reads[OTIUMLGeneralizationSet]
    = Json.reads[OTIUMLGeneralizationSet]

    implicit def writes
    : Writes[OTIUMLGeneralizationSet]
    = Json.writes[OTIUMLGeneralizationSet]

    implicit def formats
    : Format[OTIUMLGeneralizationSet]
    = Json.format[OTIUMLGeneralizationSet]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLImage
    * @param content Defined in Image
    * @param format Defined in Image
    * @param location Defined in Image
    */
  case class OTIUMLImage
  ( override val otiMOFElementLocation: ElementLocation,
    content: Option[String],
    format: Option[String],
    location: Option[String])
  extends OTIMOFElement
  with UMLImage
  {}

  object OTIUMLImage {

    implicit def reads
    : Reads[OTIUMLImage]
    = Json.reads[OTIUMLImage]

    implicit def writes
    : Writes[OTIUMLImage]
    = Json.writes[OTIUMLImage]

    implicit def formats
    : Format[OTIUMLImage]
    = Json.format[OTIUMLImage]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInclude
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLInclude
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInclude
  {}

  object OTIUMLInclude {

    implicit def reads
    : Reads[OTIUMLInclude]
    = Json.reads[OTIUMLInclude]

    implicit def writes
    : Writes[OTIUMLInclude]
    = Json.writes[OTIUMLInclude]

    implicit def formats
    : Format[OTIUMLInclude]
    = Json.format[OTIUMLInclude]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInformationFlow
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLInformationFlow
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInformationFlow
  {}

  object OTIUMLInformationFlow {

    implicit def reads
    : Reads[OTIUMLInformationFlow]
    = Json.reads[OTIUMLInformationFlow]

    implicit def writes
    : Writes[OTIUMLInformationFlow]
    = Json.writes[OTIUMLInformationFlow]

    implicit def formats
    : Format[OTIUMLInformationFlow]
    = Json.format[OTIUMLInformationFlow]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInformationItem
    * @param isAbstract Defined in Classifier
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLInformationItem
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInformationItem
  {}

  object OTIUMLInformationItem {

    implicit def reads
    : Reads[OTIUMLInformationItem]
    = Json.reads[OTIUMLInformationItem]

    implicit def writes
    : Writes[OTIUMLInformationItem]
    = Json.writes[OTIUMLInformationItem]

    implicit def formats
    : Format[OTIUMLInformationItem]
    = Json.format[OTIUMLInformationItem]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInitialNode
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLInitialNode
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInitialNode
  {}

  object OTIUMLInitialNode {

    implicit def reads
    : Reads[OTIUMLInitialNode]
    = Json.reads[OTIUMLInitialNode]

    implicit def writes
    : Writes[OTIUMLInitialNode]
    = Json.writes[OTIUMLInitialNode]

    implicit def formats
    : Format[OTIUMLInitialNode]
    = Json.format[OTIUMLInitialNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInputPin
    * @param isControl Defined in Pin
    * @param isControlType Defined in ObjectNode
    * @param isLeaf Defined in RedefinableElement
    * @param isOrdered Defined in MultiplicityElement
    * @param isUnique Defined in MultiplicityElement
    * @param name Defined in NamedElement
    * @param ordering Defined in ObjectNode
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLInputPin
  ( override val otiMOFElementLocation: ElementLocation,
    isControl: Boolean,
    isControlType: Boolean,
    isLeaf: Boolean,
    isOrdered: Boolean,
    isUnique: Boolean,
    name: Option[String],
    ordering: Option[UMLObjectNodeOrderingKind],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInputPin
  {}

  object OTIUMLInputPin {

    implicit def reads
    : Reads[OTIUMLInputPin]
    = Json.reads[OTIUMLInputPin]

    implicit def writes
    : Writes[OTIUMLInputPin]
    = Json.writes[OTIUMLInputPin]

    implicit def formats
    : Format[OTIUMLInputPin]
    = Json.format[OTIUMLInputPin]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInstanceSpecification
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLInstanceSpecification
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInstanceSpecification
  {}

  object OTIUMLInstanceSpecification {

    implicit def reads
    : Reads[OTIUMLInstanceSpecification]
    = Json.reads[OTIUMLInstanceSpecification]

    implicit def writes
    : Writes[OTIUMLInstanceSpecification]
    = Json.writes[OTIUMLInstanceSpecification]

    implicit def formats
    : Format[OTIUMLInstanceSpecification]
    = Json.format[OTIUMLInstanceSpecification]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInstanceValue
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLInstanceValue
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInstanceValue
  {}

  object OTIUMLInstanceValue {

    implicit def reads
    : Reads[OTIUMLInstanceValue]
    = Json.reads[OTIUMLInstanceValue]

    implicit def writes
    : Writes[OTIUMLInstanceValue]
    = Json.writes[OTIUMLInstanceValue]

    implicit def formats
    : Format[OTIUMLInstanceValue]
    = Json.format[OTIUMLInstanceValue]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInteraction
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param isReentrant Defined in Behavior
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLInteraction
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    isReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInteraction
  {}

  object OTIUMLInteraction {

    implicit def reads
    : Reads[OTIUMLInteraction]
    = Json.reads[OTIUMLInteraction]

    implicit def writes
    : Writes[OTIUMLInteraction]
    = Json.writes[OTIUMLInteraction]

    implicit def formats
    : Format[OTIUMLInteraction]
    = Json.format[OTIUMLInteraction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInteractionConstraint
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLInteractionConstraint
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInteractionConstraint
  {}

  object OTIUMLInteractionConstraint {

    implicit def reads
    : Reads[OTIUMLInteractionConstraint]
    = Json.reads[OTIUMLInteractionConstraint]

    implicit def writes
    : Writes[OTIUMLInteractionConstraint]
    = Json.writes[OTIUMLInteractionConstraint]

    implicit def formats
    : Format[OTIUMLInteractionConstraint]
    = Json.format[OTIUMLInteractionConstraint]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInteractionOperand
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLInteractionOperand
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInteractionOperand
  {}

  object OTIUMLInteractionOperand {

    implicit def reads
    : Reads[OTIUMLInteractionOperand]
    = Json.reads[OTIUMLInteractionOperand]

    implicit def writes
    : Writes[OTIUMLInteractionOperand]
    = Json.writes[OTIUMLInteractionOperand]

    implicit def formats
    : Format[OTIUMLInteractionOperand]
    = Json.format[OTIUMLInteractionOperand]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInteractionUse
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLInteractionUse
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInteractionUse
  {}

  object OTIUMLInteractionUse {

    implicit def reads
    : Reads[OTIUMLInteractionUse]
    = Json.reads[OTIUMLInteractionUse]

    implicit def writes
    : Writes[OTIUMLInteractionUse]
    = Json.writes[OTIUMLInteractionUse]

    implicit def formats
    : Format[OTIUMLInteractionUse]
    = Json.format[OTIUMLInteractionUse]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInterface
    * @param isAbstract Defined in Classifier
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLInterface
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInterface
  {}

  object OTIUMLInterface {

    implicit def reads
    : Reads[OTIUMLInterface]
    = Json.reads[OTIUMLInterface]

    implicit def writes
    : Writes[OTIUMLInterface]
    = Json.writes[OTIUMLInterface]

    implicit def formats
    : Format[OTIUMLInterface]
    = Json.format[OTIUMLInterface]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInterfaceRealization
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLInterfaceRealization
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInterfaceRealization
  {}

  object OTIUMLInterfaceRealization {

    implicit def reads
    : Reads[OTIUMLInterfaceRealization]
    = Json.reads[OTIUMLInterfaceRealization]

    implicit def writes
    : Writes[OTIUMLInterfaceRealization]
    = Json.writes[OTIUMLInterfaceRealization]

    implicit def formats
    : Format[OTIUMLInterfaceRealization]
    = Json.format[OTIUMLInterfaceRealization]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInterruptibleActivityRegion
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLInterruptibleActivityRegion
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInterruptibleActivityRegion
  {}

  object OTIUMLInterruptibleActivityRegion {

    implicit def reads
    : Reads[OTIUMLInterruptibleActivityRegion]
    = Json.reads[OTIUMLInterruptibleActivityRegion]

    implicit def writes
    : Writes[OTIUMLInterruptibleActivityRegion]
    = Json.writes[OTIUMLInterruptibleActivityRegion]

    implicit def formats
    : Format[OTIUMLInterruptibleActivityRegion]
    = Json.format[OTIUMLInterruptibleActivityRegion]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLInterval
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLInterval
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLInterval
  {}

  object OTIUMLInterval {

    implicit def reads
    : Reads[OTIUMLInterval]
    = Json.reads[OTIUMLInterval]

    implicit def writes
    : Writes[OTIUMLInterval]
    = Json.writes[OTIUMLInterval]

    implicit def formats
    : Format[OTIUMLInterval]
    = Json.format[OTIUMLInterval]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLIntervalConstraint
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLIntervalConstraint
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLIntervalConstraint
  {}

  object OTIUMLIntervalConstraint {

    implicit def reads
    : Reads[OTIUMLIntervalConstraint]
    = Json.reads[OTIUMLIntervalConstraint]

    implicit def writes
    : Writes[OTIUMLIntervalConstraint]
    = Json.writes[OTIUMLIntervalConstraint]

    implicit def formats
    : Format[OTIUMLIntervalConstraint]
    = Json.format[OTIUMLIntervalConstraint]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLJoinNode
    * @param isCombineDuplicate Defined in JoinNode
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLJoinNode
  ( override val otiMOFElementLocation: ElementLocation,
    isCombineDuplicate: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLJoinNode
  {}

  object OTIUMLJoinNode {

    implicit def reads
    : Reads[OTIUMLJoinNode]
    = Json.reads[OTIUMLJoinNode]

    implicit def writes
    : Writes[OTIUMLJoinNode]
    = Json.writes[OTIUMLJoinNode]

    implicit def formats
    : Format[OTIUMLJoinNode]
    = Json.format[OTIUMLJoinNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLLifeline
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLLifeline
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLLifeline
  {}

  object OTIUMLLifeline {

    implicit def reads
    : Reads[OTIUMLLifeline]
    = Json.reads[OTIUMLLifeline]

    implicit def writes
    : Writes[OTIUMLLifeline]
    = Json.writes[OTIUMLLifeline]

    implicit def formats
    : Format[OTIUMLLifeline]
    = Json.format[OTIUMLLifeline]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLLinkEndCreationData
    * @param isReplaceAll Defined in LinkEndCreationData
    */
  case class OTIUMLLinkEndCreationData
  ( override val otiMOFElementLocation: ElementLocation,
    isReplaceAll: Boolean)
  extends OTIMOFElement
  with UMLLinkEndCreationData
  {}

  object OTIUMLLinkEndCreationData {

    implicit def reads
    : Reads[OTIUMLLinkEndCreationData]
    = Json.reads[OTIUMLLinkEndCreationData]

    implicit def writes
    : Writes[OTIUMLLinkEndCreationData]
    = Json.writes[OTIUMLLinkEndCreationData]

    implicit def formats
    : Format[OTIUMLLinkEndCreationData]
    = Json.format[OTIUMLLinkEndCreationData]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLLinkEndData
    */
  case class OTIUMLLinkEndData
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLLinkEndData
  {}

  object OTIUMLLinkEndData {

    implicit def reads
    : Reads[OTIUMLLinkEndData]
    = Json.reads[OTIUMLLinkEndData]

    implicit def writes
    : Writes[OTIUMLLinkEndData]
    = Json.writes[OTIUMLLinkEndData]

    implicit def formats
    : Format[OTIUMLLinkEndData]
    = Json.format[OTIUMLLinkEndData]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLLinkEndDestructionData
    * @param isDestroyDuplicates Defined in LinkEndDestructionData
    */
  case class OTIUMLLinkEndDestructionData
  ( override val otiMOFElementLocation: ElementLocation,
    isDestroyDuplicates: Boolean)
  extends OTIMOFElement
  with UMLLinkEndDestructionData
  {}

  object OTIUMLLinkEndDestructionData {

    implicit def reads
    : Reads[OTIUMLLinkEndDestructionData]
    = Json.reads[OTIUMLLinkEndDestructionData]

    implicit def writes
    : Writes[OTIUMLLinkEndDestructionData]
    = Json.writes[OTIUMLLinkEndDestructionData]

    implicit def formats
    : Format[OTIUMLLinkEndDestructionData]
    = Json.format[OTIUMLLinkEndDestructionData]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLLiteralBoolean
    * @param name Defined in NamedElement
    * @param value Defined in LiteralBoolean
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLLiteralBoolean
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    value: Boolean,
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLLiteralBoolean
  {}

  object OTIUMLLiteralBoolean {

    implicit def reads
    : Reads[OTIUMLLiteralBoolean]
    = Json.reads[OTIUMLLiteralBoolean]

    implicit def writes
    : Writes[OTIUMLLiteralBoolean]
    = Json.writes[OTIUMLLiteralBoolean]

    implicit def formats
    : Format[OTIUMLLiteralBoolean]
    = Json.format[OTIUMLLiteralBoolean]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLLiteralInteger
    * @param name Defined in NamedElement
    * @param value Defined in LiteralInteger
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLLiteralInteger
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    value: Int,
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLLiteralInteger
  {}

  object OTIUMLLiteralInteger {

    implicit def reads
    : Reads[OTIUMLLiteralInteger]
    = Json.reads[OTIUMLLiteralInteger]

    implicit def writes
    : Writes[OTIUMLLiteralInteger]
    = Json.writes[OTIUMLLiteralInteger]

    implicit def formats
    : Format[OTIUMLLiteralInteger]
    = Json.format[OTIUMLLiteralInteger]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLLiteralNull
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLLiteralNull
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLLiteralNull
  {}

  object OTIUMLLiteralNull {

    implicit def reads
    : Reads[OTIUMLLiteralNull]
    = Json.reads[OTIUMLLiteralNull]

    implicit def writes
    : Writes[OTIUMLLiteralNull]
    = Json.writes[OTIUMLLiteralNull]

    implicit def formats
    : Format[OTIUMLLiteralNull]
    = Json.format[OTIUMLLiteralNull]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLLiteralReal
    * @param name Defined in NamedElement
    * @param value Defined in LiteralReal
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLLiteralReal
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    value: Double,
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLLiteralReal
  {}

  object OTIUMLLiteralReal {

    implicit def reads
    : Reads[OTIUMLLiteralReal]
    = Json.reads[OTIUMLLiteralReal]

    implicit def writes
    : Writes[OTIUMLLiteralReal]
    = Json.writes[OTIUMLLiteralReal]

    implicit def formats
    : Format[OTIUMLLiteralReal]
    = Json.format[OTIUMLLiteralReal]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLLiteralString
    * @param name Defined in NamedElement
    * @param value Defined in LiteralString
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLLiteralString
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    value: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLLiteralString
  {}

  object OTIUMLLiteralString {

    implicit def reads
    : Reads[OTIUMLLiteralString]
    = Json.reads[OTIUMLLiteralString]

    implicit def writes
    : Writes[OTIUMLLiteralString]
    = Json.writes[OTIUMLLiteralString]

    implicit def formats
    : Format[OTIUMLLiteralString]
    = Json.format[OTIUMLLiteralString]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLLiteralUnlimitedNatural
    * @param name Defined in NamedElement
    * @param value Defined in LiteralUnlimitedNatural
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLLiteralUnlimitedNatural
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    value: Int,
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLLiteralUnlimitedNatural
  {}

  object OTIUMLLiteralUnlimitedNatural {

    implicit def reads
    : Reads[OTIUMLLiteralUnlimitedNatural]
    = Json.reads[OTIUMLLiteralUnlimitedNatural]

    implicit def writes
    : Writes[OTIUMLLiteralUnlimitedNatural]
    = Json.writes[OTIUMLLiteralUnlimitedNatural]

    implicit def formats
    : Format[OTIUMLLiteralUnlimitedNatural]
    = Json.format[OTIUMLLiteralUnlimitedNatural]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLLoopNode
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isTestedFirst Defined in LoopNode
    * @param mustIsolate Defined in StructuredActivityNode
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLLoopNode
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isTestedFirst: Boolean,
    mustIsolate: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLLoopNode
  {}

  object OTIUMLLoopNode {

    implicit def reads
    : Reads[OTIUMLLoopNode]
    = Json.reads[OTIUMLLoopNode]

    implicit def writes
    : Writes[OTIUMLLoopNode]
    = Json.writes[OTIUMLLoopNode]

    implicit def formats
    : Format[OTIUMLLoopNode]
    = Json.format[OTIUMLLoopNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLManifestation
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLManifestation
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLManifestation
  {}

  object OTIUMLManifestation {

    implicit def reads
    : Reads[OTIUMLManifestation]
    = Json.reads[OTIUMLManifestation]

    implicit def writes
    : Writes[OTIUMLManifestation]
    = Json.writes[OTIUMLManifestation]

    implicit def formats
    : Format[OTIUMLManifestation]
    = Json.format[OTIUMLManifestation]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLMergeNode
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLMergeNode
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLMergeNode
  {}

  object OTIUMLMergeNode {

    implicit def reads
    : Reads[OTIUMLMergeNode]
    = Json.reads[OTIUMLMergeNode]

    implicit def writes
    : Writes[OTIUMLMergeNode]
    = Json.writes[OTIUMLMergeNode]

    implicit def formats
    : Format[OTIUMLMergeNode]
    = Json.format[OTIUMLMergeNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLMessage
    * @param messageSort Defined in Message
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLMessage
  ( override val otiMOFElementLocation: ElementLocation,
    messageSort: Option[UMLMessageSort],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLMessage
  {}

  object OTIUMLMessage {

    implicit def reads
    : Reads[OTIUMLMessage]
    = Json.reads[OTIUMLMessage]

    implicit def writes
    : Writes[OTIUMLMessage]
    = Json.writes[OTIUMLMessage]

    implicit def formats
    : Format[OTIUMLMessage]
    = Json.format[OTIUMLMessage]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLMessageOccurrenceSpecification
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLMessageOccurrenceSpecification
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLMessageOccurrenceSpecification
  {}

  object OTIUMLMessageOccurrenceSpecification {

    implicit def reads
    : Reads[OTIUMLMessageOccurrenceSpecification]
    = Json.reads[OTIUMLMessageOccurrenceSpecification]

    implicit def writes
    : Writes[OTIUMLMessageOccurrenceSpecification]
    = Json.writes[OTIUMLMessageOccurrenceSpecification]

    implicit def formats
    : Format[OTIUMLMessageOccurrenceSpecification]
    = Json.format[OTIUMLMessageOccurrenceSpecification]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLModel
    * @param URI Defined in Package
    * @param name Defined in NamedElement
    * @param viewpoint Defined in Model
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLModel
  ( override val otiMOFElementLocation: ElementLocation,
    URI: Option[String],
    name: Option[String],
    viewpoint: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLModel
  {}

  object OTIUMLModel {

    implicit def reads
    : Reads[OTIUMLModel]
    = Json.reads[OTIUMLModel]

    implicit def writes
    : Writes[OTIUMLModel]
    = Json.writes[OTIUMLModel]

    implicit def formats
    : Format[OTIUMLModel]
    = Json.format[OTIUMLModel]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLNode
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLNode
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLNode
  {}

  object OTIUMLNode {

    implicit def reads
    : Reads[OTIUMLNode]
    = Json.reads[OTIUMLNode]

    implicit def writes
    : Writes[OTIUMLNode]
    = Json.writes[OTIUMLNode]

    implicit def formats
    : Format[OTIUMLNode]
    = Json.format[OTIUMLNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLObjectFlow
    * @param isLeaf Defined in RedefinableElement
    * @param isMulticast Defined in ObjectFlow
    * @param isMultireceive Defined in ObjectFlow
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLObjectFlow
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isMulticast: Boolean,
    isMultireceive: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLObjectFlow
  {}

  object OTIUMLObjectFlow {

    implicit def reads
    : Reads[OTIUMLObjectFlow]
    = Json.reads[OTIUMLObjectFlow]

    implicit def writes
    : Writes[OTIUMLObjectFlow]
    = Json.writes[OTIUMLObjectFlow]

    implicit def formats
    : Format[OTIUMLObjectFlow]
    = Json.format[OTIUMLObjectFlow]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLOccurrenceSpecification
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLOccurrenceSpecification
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLOccurrenceSpecification
  {}

  object OTIUMLOccurrenceSpecification {

    implicit def reads
    : Reads[OTIUMLOccurrenceSpecification]
    = Json.reads[OTIUMLOccurrenceSpecification]

    implicit def writes
    : Writes[OTIUMLOccurrenceSpecification]
    = Json.writes[OTIUMLOccurrenceSpecification]

    implicit def formats
    : Format[OTIUMLOccurrenceSpecification]
    = Json.format[OTIUMLOccurrenceSpecification]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLOpaqueAction
    * @param body Defined in OpaqueAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param language Defined in OpaqueAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLOpaqueAction
  ( override val otiMOFElementLocation: ElementLocation,
    body: Seq[String],
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    language: Seq[String],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLOpaqueAction
  {}

  object OTIUMLOpaqueAction {

    implicit def reads
    : Reads[OTIUMLOpaqueAction]
    = Json.reads[OTIUMLOpaqueAction]

    implicit def writes
    : Writes[OTIUMLOpaqueAction]
    = Json.writes[OTIUMLOpaqueAction]

    implicit def formats
    : Format[OTIUMLOpaqueAction]
    = Json.format[OTIUMLOpaqueAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLOpaqueBehavior
    * @param body Defined in OpaqueBehavior
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param isReentrant Defined in Behavior
    * @param language Defined in OpaqueBehavior
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLOpaqueBehavior
  ( override val otiMOFElementLocation: ElementLocation,
    body: Seq[String],
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    isReentrant: Boolean,
    language: Seq[String],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLOpaqueBehavior
  {}

  object OTIUMLOpaqueBehavior {

    implicit def reads
    : Reads[OTIUMLOpaqueBehavior]
    = Json.reads[OTIUMLOpaqueBehavior]

    implicit def writes
    : Writes[OTIUMLOpaqueBehavior]
    = Json.writes[OTIUMLOpaqueBehavior]

    implicit def formats
    : Format[OTIUMLOpaqueBehavior]
    = Json.format[OTIUMLOpaqueBehavior]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLOpaqueExpression
    * @param body Defined in OpaqueExpression
    * @param language Defined in OpaqueExpression
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLOpaqueExpression
  ( override val otiMOFElementLocation: ElementLocation,
    body: Seq[String],
    language: Seq[String],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLOpaqueExpression
  {}

  object OTIUMLOpaqueExpression {

    implicit def reads
    : Reads[OTIUMLOpaqueExpression]
    = Json.reads[OTIUMLOpaqueExpression]

    implicit def writes
    : Writes[OTIUMLOpaqueExpression]
    = Json.writes[OTIUMLOpaqueExpression]

    implicit def formats
    : Format[OTIUMLOpaqueExpression]
    = Json.format[OTIUMLOpaqueExpression]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLOperation
    * @param concurrency Defined in BehavioralFeature
    * @param isAbstract Defined in BehavioralFeature
    * @param isLeaf Defined in RedefinableElement
    * @param isQuery Defined in Operation
    * @param isStatic Defined in Feature
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLOperation
  ( override val otiMOFElementLocation: ElementLocation,
    concurrency: Option[UMLCallConcurrencyKind],
    isAbstract: Boolean,
    isLeaf: Boolean,
    isQuery: Boolean,
    isStatic: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLOperation
  {}

  object OTIUMLOperation {

    implicit def reads
    : Reads[OTIUMLOperation]
    = Json.reads[OTIUMLOperation]

    implicit def writes
    : Writes[OTIUMLOperation]
    = Json.writes[OTIUMLOperation]

    implicit def formats
    : Format[OTIUMLOperation]
    = Json.format[OTIUMLOperation]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLOperationTemplateParameter
    */
  case class OTIUMLOperationTemplateParameter
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLOperationTemplateParameter
  {}

  object OTIUMLOperationTemplateParameter {

    implicit def reads
    : Reads[OTIUMLOperationTemplateParameter]
    = Json.reads[OTIUMLOperationTemplateParameter]

    implicit def writes
    : Writes[OTIUMLOperationTemplateParameter]
    = Json.writes[OTIUMLOperationTemplateParameter]

    implicit def formats
    : Format[OTIUMLOperationTemplateParameter]
    = Json.format[OTIUMLOperationTemplateParameter]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLOutputPin
    * @param isControl Defined in Pin
    * @param isControlType Defined in ObjectNode
    * @param isLeaf Defined in RedefinableElement
    * @param isOrdered Defined in MultiplicityElement
    * @param isUnique Defined in MultiplicityElement
    * @param name Defined in NamedElement
    * @param ordering Defined in ObjectNode
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLOutputPin
  ( override val otiMOFElementLocation: ElementLocation,
    isControl: Boolean,
    isControlType: Boolean,
    isLeaf: Boolean,
    isOrdered: Boolean,
    isUnique: Boolean,
    name: Option[String],
    ordering: Option[UMLObjectNodeOrderingKind],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLOutputPin
  {}

  object OTIUMLOutputPin {

    implicit def reads
    : Reads[OTIUMLOutputPin]
    = Json.reads[OTIUMLOutputPin]

    implicit def writes
    : Writes[OTIUMLOutputPin]
    = Json.writes[OTIUMLOutputPin]

    implicit def formats
    : Format[OTIUMLOutputPin]
    = Json.format[OTIUMLOutputPin]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLPackage
    * @param URI Defined in Package
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLPackage
  ( override val otiMOFElementLocation: ElementLocation,
    URI: Option[String],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLPackage
  {}

  object OTIUMLPackage {

    implicit def reads
    : Reads[OTIUMLPackage]
    = Json.reads[OTIUMLPackage]

    implicit def writes
    : Writes[OTIUMLPackage]
    = Json.writes[OTIUMLPackage]

    implicit def formats
    : Format[OTIUMLPackage]
    = Json.format[OTIUMLPackage]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLPackageImport
    * @param visibility Defined in PackageImport
    */
  case class OTIUMLPackageImport
  ( override val otiMOFElementLocation: ElementLocation,
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLPackageImport
  {}

  object OTIUMLPackageImport {

    implicit def reads
    : Reads[OTIUMLPackageImport]
    = Json.reads[OTIUMLPackageImport]

    implicit def writes
    : Writes[OTIUMLPackageImport]
    = Json.writes[OTIUMLPackageImport]

    implicit def formats
    : Format[OTIUMLPackageImport]
    = Json.format[OTIUMLPackageImport]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLPackageMerge
    */
  case class OTIUMLPackageMerge
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLPackageMerge
  {}

  object OTIUMLPackageMerge {

    implicit def reads
    : Reads[OTIUMLPackageMerge]
    = Json.reads[OTIUMLPackageMerge]

    implicit def writes
    : Writes[OTIUMLPackageMerge]
    = Json.writes[OTIUMLPackageMerge]

    implicit def formats
    : Format[OTIUMLPackageMerge]
    = Json.format[OTIUMLPackageMerge]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLParameter
    * @param direction Defined in Parameter
    * @param effect Defined in Parameter
    * @param isException Defined in Parameter
    * @param isOrdered Defined in MultiplicityElement
    * @param isStream Defined in Parameter
    * @param isUnique Defined in MultiplicityElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLParameter
  ( override val otiMOFElementLocation: ElementLocation,
    direction: Option[UMLParameterDirectionKind],
    effect: Option[UMLParameterEffectKind],
    isException: Boolean,
    isOrdered: Boolean,
    isStream: Boolean,
    isUnique: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLParameter
  {}

  object OTIUMLParameter {

    implicit def reads
    : Reads[OTIUMLParameter]
    = Json.reads[OTIUMLParameter]

    implicit def writes
    : Writes[OTIUMLParameter]
    = Json.writes[OTIUMLParameter]

    implicit def formats
    : Format[OTIUMLParameter]
    = Json.format[OTIUMLParameter]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLParameterSet
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLParameterSet
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLParameterSet
  {}

  object OTIUMLParameterSet {

    implicit def reads
    : Reads[OTIUMLParameterSet]
    = Json.reads[OTIUMLParameterSet]

    implicit def writes
    : Writes[OTIUMLParameterSet]
    = Json.writes[OTIUMLParameterSet]

    implicit def formats
    : Format[OTIUMLParameterSet]
    = Json.format[OTIUMLParameterSet]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLPartDecomposition
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLPartDecomposition
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLPartDecomposition
  {}

  object OTIUMLPartDecomposition {

    implicit def reads
    : Reads[OTIUMLPartDecomposition]
    = Json.reads[OTIUMLPartDecomposition]

    implicit def writes
    : Writes[OTIUMLPartDecomposition]
    = Json.writes[OTIUMLPartDecomposition]

    implicit def formats
    : Format[OTIUMLPartDecomposition]
    = Json.format[OTIUMLPartDecomposition]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLPort
    * @param aggregation Defined in Property
    * @param isBehavior Defined in Port
    * @param isConjugated Defined in Port
    * @param isDerived Defined in Property
    * @param isDerivedUnion Defined in Property
    * @param isID Defined in Property
    * @param isLeaf Defined in RedefinableElement
    * @param isOrdered Defined in MultiplicityElement
    * @param isReadOnly Defined in StructuralFeature
    * @param isService Defined in Port
    * @param isStatic Defined in Feature
    * @param isUnique Defined in MultiplicityElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLPort
  ( override val otiMOFElementLocation: ElementLocation,
    aggregation: Option[UMLAggregationKind],
    isBehavior: Boolean,
    isConjugated: Boolean,
    isDerived: Boolean,
    isDerivedUnion: Boolean,
    isID: Boolean,
    isLeaf: Boolean,
    isOrdered: Boolean,
    isReadOnly: Boolean,
    isService: Boolean,
    isStatic: Boolean,
    isUnique: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLPort
  {}

  object OTIUMLPort {

    implicit def reads
    : Reads[OTIUMLPort]
    = Json.reads[OTIUMLPort]

    implicit def writes
    : Writes[OTIUMLPort]
    = Json.writes[OTIUMLPort]

    implicit def formats
    : Format[OTIUMLPort]
    = Json.format[OTIUMLPort]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLPrimitiveType
    * @param isAbstract Defined in Classifier
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLPrimitiveType
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLPrimitiveType
  {}

  object OTIUMLPrimitiveType {

    implicit def reads
    : Reads[OTIUMLPrimitiveType]
    = Json.reads[OTIUMLPrimitiveType]

    implicit def writes
    : Writes[OTIUMLPrimitiveType]
    = Json.writes[OTIUMLPrimitiveType]

    implicit def formats
    : Format[OTIUMLPrimitiveType]
    = Json.format[OTIUMLPrimitiveType]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLProfile
    * @param URI Defined in Package
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLProfile
  ( override val otiMOFElementLocation: ElementLocation,
    URI: Option[String],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLProfile
  {}

  object OTIUMLProfile {

    implicit def reads
    : Reads[OTIUMLProfile]
    = Json.reads[OTIUMLProfile]

    implicit def writes
    : Writes[OTIUMLProfile]
    = Json.writes[OTIUMLProfile]

    implicit def formats
    : Format[OTIUMLProfile]
    = Json.format[OTIUMLProfile]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLProfileApplication
    * @param isStrict Defined in ProfileApplication
    */
  case class OTIUMLProfileApplication
  ( override val otiMOFElementLocation: ElementLocation,
    isStrict: Boolean)
  extends OTIMOFElement
  with UMLProfileApplication
  {}

  object OTIUMLProfileApplication {

    implicit def reads
    : Reads[OTIUMLProfileApplication]
    = Json.reads[OTIUMLProfileApplication]

    implicit def writes
    : Writes[OTIUMLProfileApplication]
    = Json.writes[OTIUMLProfileApplication]

    implicit def formats
    : Format[OTIUMLProfileApplication]
    = Json.format[OTIUMLProfileApplication]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLProperty
    * @param aggregation Defined in Property
    * @param isDerived Defined in Property
    * @param isDerivedUnion Defined in Property
    * @param isID Defined in Property
    * @param isLeaf Defined in RedefinableElement
    * @param isOrdered Defined in MultiplicityElement
    * @param isReadOnly Defined in StructuralFeature
    * @param isStatic Defined in Feature
    * @param isUnique Defined in MultiplicityElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLProperty
  ( override val otiMOFElementLocation: ElementLocation,
    aggregation: Option[UMLAggregationKind],
    isDerived: Boolean,
    isDerivedUnion: Boolean,
    isID: Boolean,
    isLeaf: Boolean,
    isOrdered: Boolean,
    isReadOnly: Boolean,
    isStatic: Boolean,
    isUnique: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLProperty
  {}

  object OTIUMLProperty {

    implicit def reads
    : Reads[OTIUMLProperty]
    = Json.reads[OTIUMLProperty]

    implicit def writes
    : Writes[OTIUMLProperty]
    = Json.writes[OTIUMLProperty]

    implicit def formats
    : Format[OTIUMLProperty]
    = Json.format[OTIUMLProperty]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLProtocolConformance
    */
  case class OTIUMLProtocolConformance
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLProtocolConformance
  {}

  object OTIUMLProtocolConformance {

    implicit def reads
    : Reads[OTIUMLProtocolConformance]
    = Json.reads[OTIUMLProtocolConformance]

    implicit def writes
    : Writes[OTIUMLProtocolConformance]
    = Json.writes[OTIUMLProtocolConformance]

    implicit def formats
    : Format[OTIUMLProtocolConformance]
    = Json.format[OTIUMLProtocolConformance]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLProtocolStateMachine
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param isReentrant Defined in Behavior
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLProtocolStateMachine
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    isReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLProtocolStateMachine
  {}

  object OTIUMLProtocolStateMachine {

    implicit def reads
    : Reads[OTIUMLProtocolStateMachine]
    = Json.reads[OTIUMLProtocolStateMachine]

    implicit def writes
    : Writes[OTIUMLProtocolStateMachine]
    = Json.writes[OTIUMLProtocolStateMachine]

    implicit def formats
    : Format[OTIUMLProtocolStateMachine]
    = Json.format[OTIUMLProtocolStateMachine]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLProtocolTransition
    * @param isLeaf Defined in RedefinableElement
    * @param kind Defined in Transition
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLProtocolTransition
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    kind: Option[UMLTransitionKind],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLProtocolTransition
  {}

  object OTIUMLProtocolTransition {

    implicit def reads
    : Reads[OTIUMLProtocolTransition]
    = Json.reads[OTIUMLProtocolTransition]

    implicit def writes
    : Writes[OTIUMLProtocolTransition]
    = Json.writes[OTIUMLProtocolTransition]

    implicit def formats
    : Format[OTIUMLProtocolTransition]
    = Json.format[OTIUMLProtocolTransition]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLPseudostate
    * @param kind Defined in Pseudostate
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLPseudostate
  ( override val otiMOFElementLocation: ElementLocation,
    kind: Option[UMLPseudostateKind],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLPseudostate
  {}

  object OTIUMLPseudostate {

    implicit def reads
    : Reads[OTIUMLPseudostate]
    = Json.reads[OTIUMLPseudostate]

    implicit def writes
    : Writes[OTIUMLPseudostate]
    = Json.writes[OTIUMLPseudostate]

    implicit def formats
    : Format[OTIUMLPseudostate]
    = Json.format[OTIUMLPseudostate]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLQualifierValue
    */
  case class OTIUMLQualifierValue
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLQualifierValue
  {}

  object OTIUMLQualifierValue {

    implicit def reads
    : Reads[OTIUMLQualifierValue]
    = Json.reads[OTIUMLQualifierValue]

    implicit def writes
    : Writes[OTIUMLQualifierValue]
    = Json.writes[OTIUMLQualifierValue]

    implicit def formats
    : Format[OTIUMLQualifierValue]
    = Json.format[OTIUMLQualifierValue]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLRaiseExceptionAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLRaiseExceptionAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLRaiseExceptionAction
  {}

  object OTIUMLRaiseExceptionAction {

    implicit def reads
    : Reads[OTIUMLRaiseExceptionAction]
    = Json.reads[OTIUMLRaiseExceptionAction]

    implicit def writes
    : Writes[OTIUMLRaiseExceptionAction]
    = Json.writes[OTIUMLRaiseExceptionAction]

    implicit def formats
    : Format[OTIUMLRaiseExceptionAction]
    = Json.format[OTIUMLRaiseExceptionAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReadExtentAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReadExtentAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReadExtentAction
  {}

  object OTIUMLReadExtentAction {

    implicit def reads
    : Reads[OTIUMLReadExtentAction]
    = Json.reads[OTIUMLReadExtentAction]

    implicit def writes
    : Writes[OTIUMLReadExtentAction]
    = Json.writes[OTIUMLReadExtentAction]

    implicit def formats
    : Format[OTIUMLReadExtentAction]
    = Json.format[OTIUMLReadExtentAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReadIsClassifiedObjectAction
    * @param isDirect Defined in ReadIsClassifiedObjectAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReadIsClassifiedObjectAction
  ( override val otiMOFElementLocation: ElementLocation,
    isDirect: Boolean,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReadIsClassifiedObjectAction
  {}

  object OTIUMLReadIsClassifiedObjectAction {

    implicit def reads
    : Reads[OTIUMLReadIsClassifiedObjectAction]
    = Json.reads[OTIUMLReadIsClassifiedObjectAction]

    implicit def writes
    : Writes[OTIUMLReadIsClassifiedObjectAction]
    = Json.writes[OTIUMLReadIsClassifiedObjectAction]

    implicit def formats
    : Format[OTIUMLReadIsClassifiedObjectAction]
    = Json.format[OTIUMLReadIsClassifiedObjectAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReadLinkAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReadLinkAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReadLinkAction
  {}

  object OTIUMLReadLinkAction {

    implicit def reads
    : Reads[OTIUMLReadLinkAction]
    = Json.reads[OTIUMLReadLinkAction]

    implicit def writes
    : Writes[OTIUMLReadLinkAction]
    = Json.writes[OTIUMLReadLinkAction]

    implicit def formats
    : Format[OTIUMLReadLinkAction]
    = Json.format[OTIUMLReadLinkAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReadLinkObjectEndAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReadLinkObjectEndAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReadLinkObjectEndAction
  {}

  object OTIUMLReadLinkObjectEndAction {

    implicit def reads
    : Reads[OTIUMLReadLinkObjectEndAction]
    = Json.reads[OTIUMLReadLinkObjectEndAction]

    implicit def writes
    : Writes[OTIUMLReadLinkObjectEndAction]
    = Json.writes[OTIUMLReadLinkObjectEndAction]

    implicit def formats
    : Format[OTIUMLReadLinkObjectEndAction]
    = Json.format[OTIUMLReadLinkObjectEndAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReadLinkObjectEndQualifierAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReadLinkObjectEndQualifierAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReadLinkObjectEndQualifierAction
  {}

  object OTIUMLReadLinkObjectEndQualifierAction {

    implicit def reads
    : Reads[OTIUMLReadLinkObjectEndQualifierAction]
    = Json.reads[OTIUMLReadLinkObjectEndQualifierAction]

    implicit def writes
    : Writes[OTIUMLReadLinkObjectEndQualifierAction]
    = Json.writes[OTIUMLReadLinkObjectEndQualifierAction]

    implicit def formats
    : Format[OTIUMLReadLinkObjectEndQualifierAction]
    = Json.format[OTIUMLReadLinkObjectEndQualifierAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReadSelfAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReadSelfAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReadSelfAction
  {}

  object OTIUMLReadSelfAction {

    implicit def reads
    : Reads[OTIUMLReadSelfAction]
    = Json.reads[OTIUMLReadSelfAction]

    implicit def writes
    : Writes[OTIUMLReadSelfAction]
    = Json.writes[OTIUMLReadSelfAction]

    implicit def formats
    : Format[OTIUMLReadSelfAction]
    = Json.format[OTIUMLReadSelfAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReadStructuralFeatureAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReadStructuralFeatureAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReadStructuralFeatureAction
  {}

  object OTIUMLReadStructuralFeatureAction {

    implicit def reads
    : Reads[OTIUMLReadStructuralFeatureAction]
    = Json.reads[OTIUMLReadStructuralFeatureAction]

    implicit def writes
    : Writes[OTIUMLReadStructuralFeatureAction]
    = Json.writes[OTIUMLReadStructuralFeatureAction]

    implicit def formats
    : Format[OTIUMLReadStructuralFeatureAction]
    = Json.format[OTIUMLReadStructuralFeatureAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReadVariableAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReadVariableAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReadVariableAction
  {}

  object OTIUMLReadVariableAction {

    implicit def reads
    : Reads[OTIUMLReadVariableAction]
    = Json.reads[OTIUMLReadVariableAction]

    implicit def writes
    : Writes[OTIUMLReadVariableAction]
    = Json.writes[OTIUMLReadVariableAction]

    implicit def formats
    : Format[OTIUMLReadVariableAction]
    = Json.format[OTIUMLReadVariableAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLRealization
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLRealization
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLRealization
  {}

  object OTIUMLRealization {

    implicit def reads
    : Reads[OTIUMLRealization]
    = Json.reads[OTIUMLRealization]

    implicit def writes
    : Writes[OTIUMLRealization]
    = Json.writes[OTIUMLRealization]

    implicit def formats
    : Format[OTIUMLRealization]
    = Json.format[OTIUMLRealization]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReception
    * @param concurrency Defined in BehavioralFeature
    * @param isAbstract Defined in BehavioralFeature
    * @param isLeaf Defined in RedefinableElement
    * @param isStatic Defined in Feature
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReception
  ( override val otiMOFElementLocation: ElementLocation,
    concurrency: Option[UMLCallConcurrencyKind],
    isAbstract: Boolean,
    isLeaf: Boolean,
    isStatic: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReception
  {}

  object OTIUMLReception {

    implicit def reads
    : Reads[OTIUMLReception]
    = Json.reads[OTIUMLReception]

    implicit def writes
    : Writes[OTIUMLReception]
    = Json.writes[OTIUMLReception]

    implicit def formats
    : Format[OTIUMLReception]
    = Json.format[OTIUMLReception]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReclassifyObjectAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isReplaceAll Defined in ReclassifyObjectAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReclassifyObjectAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isReplaceAll: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReclassifyObjectAction
  {}

  object OTIUMLReclassifyObjectAction {

    implicit def reads
    : Reads[OTIUMLReclassifyObjectAction]
    = Json.reads[OTIUMLReclassifyObjectAction]

    implicit def writes
    : Writes[OTIUMLReclassifyObjectAction]
    = Json.writes[OTIUMLReclassifyObjectAction]

    implicit def formats
    : Format[OTIUMLReclassifyObjectAction]
    = Json.format[OTIUMLReclassifyObjectAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLRedefinableTemplateSignature
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLRedefinableTemplateSignature
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLRedefinableTemplateSignature
  {}

  object OTIUMLRedefinableTemplateSignature {

    implicit def reads
    : Reads[OTIUMLRedefinableTemplateSignature]
    = Json.reads[OTIUMLRedefinableTemplateSignature]

    implicit def writes
    : Writes[OTIUMLRedefinableTemplateSignature]
    = Json.writes[OTIUMLRedefinableTemplateSignature]

    implicit def formats
    : Format[OTIUMLRedefinableTemplateSignature]
    = Json.format[OTIUMLRedefinableTemplateSignature]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReduceAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isOrdered Defined in ReduceAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReduceAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isOrdered: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReduceAction
  {}

  object OTIUMLReduceAction {

    implicit def reads
    : Reads[OTIUMLReduceAction]
    = Json.reads[OTIUMLReduceAction]

    implicit def writes
    : Writes[OTIUMLReduceAction]
    = Json.writes[OTIUMLReduceAction]

    implicit def formats
    : Format[OTIUMLReduceAction]
    = Json.format[OTIUMLReduceAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLRegion
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLRegion
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLRegion
  {}

  object OTIUMLRegion {

    implicit def reads
    : Reads[OTIUMLRegion]
    = Json.reads[OTIUMLRegion]

    implicit def writes
    : Writes[OTIUMLRegion]
    = Json.writes[OTIUMLRegion]

    implicit def formats
    : Format[OTIUMLRegion]
    = Json.format[OTIUMLRegion]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLRemoveStructuralFeatureValueAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isRemoveDuplicates Defined in RemoveStructuralFeatureValueAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLRemoveStructuralFeatureValueAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isRemoveDuplicates: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLRemoveStructuralFeatureValueAction
  {}

  object OTIUMLRemoveStructuralFeatureValueAction {

    implicit def reads
    : Reads[OTIUMLRemoveStructuralFeatureValueAction]
    = Json.reads[OTIUMLRemoveStructuralFeatureValueAction]

    implicit def writes
    : Writes[OTIUMLRemoveStructuralFeatureValueAction]
    = Json.writes[OTIUMLRemoveStructuralFeatureValueAction]

    implicit def formats
    : Format[OTIUMLRemoveStructuralFeatureValueAction]
    = Json.format[OTIUMLRemoveStructuralFeatureValueAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLRemoveVariableValueAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isRemoveDuplicates Defined in RemoveVariableValueAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLRemoveVariableValueAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isRemoveDuplicates: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLRemoveVariableValueAction
  {}

  object OTIUMLRemoveVariableValueAction {

    implicit def reads
    : Reads[OTIUMLRemoveVariableValueAction]
    = Json.reads[OTIUMLRemoveVariableValueAction]

    implicit def writes
    : Writes[OTIUMLRemoveVariableValueAction]
    = Json.writes[OTIUMLRemoveVariableValueAction]

    implicit def formats
    : Format[OTIUMLRemoveVariableValueAction]
    = Json.format[OTIUMLRemoveVariableValueAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLReplyAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLReplyAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLReplyAction
  {}

  object OTIUMLReplyAction {

    implicit def reads
    : Reads[OTIUMLReplyAction]
    = Json.reads[OTIUMLReplyAction]

    implicit def writes
    : Writes[OTIUMLReplyAction]
    = Json.writes[OTIUMLReplyAction]

    implicit def formats
    : Format[OTIUMLReplyAction]
    = Json.format[OTIUMLReplyAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLSendObjectAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLSendObjectAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLSendObjectAction
  {}

  object OTIUMLSendObjectAction {

    implicit def reads
    : Reads[OTIUMLSendObjectAction]
    = Json.reads[OTIUMLSendObjectAction]

    implicit def writes
    : Writes[OTIUMLSendObjectAction]
    = Json.writes[OTIUMLSendObjectAction]

    implicit def formats
    : Format[OTIUMLSendObjectAction]
    = Json.format[OTIUMLSendObjectAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLSendSignalAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLSendSignalAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLSendSignalAction
  {}

  object OTIUMLSendSignalAction {

    implicit def reads
    : Reads[OTIUMLSendSignalAction]
    = Json.reads[OTIUMLSendSignalAction]

    implicit def writes
    : Writes[OTIUMLSendSignalAction]
    = Json.writes[OTIUMLSendSignalAction]

    implicit def formats
    : Format[OTIUMLSendSignalAction]
    = Json.format[OTIUMLSendSignalAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLSequenceNode
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param mustIsolate Defined in StructuredActivityNode
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLSequenceNode
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    mustIsolate: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLSequenceNode
  {}

  object OTIUMLSequenceNode {

    implicit def reads
    : Reads[OTIUMLSequenceNode]
    = Json.reads[OTIUMLSequenceNode]

    implicit def writes
    : Writes[OTIUMLSequenceNode]
    = Json.writes[OTIUMLSequenceNode]

    implicit def formats
    : Format[OTIUMLSequenceNode]
    = Json.format[OTIUMLSequenceNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLSignal
    * @param isAbstract Defined in Classifier
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLSignal
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLSignal
  {}

  object OTIUMLSignal {

    implicit def reads
    : Reads[OTIUMLSignal]
    = Json.reads[OTIUMLSignal]

    implicit def writes
    : Writes[OTIUMLSignal]
    = Json.writes[OTIUMLSignal]

    implicit def formats
    : Format[OTIUMLSignal]
    = Json.format[OTIUMLSignal]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLSignalEvent
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLSignalEvent
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLSignalEvent
  {}

  object OTIUMLSignalEvent {

    implicit def reads
    : Reads[OTIUMLSignalEvent]
    = Json.reads[OTIUMLSignalEvent]

    implicit def writes
    : Writes[OTIUMLSignalEvent]
    = Json.writes[OTIUMLSignalEvent]

    implicit def formats
    : Format[OTIUMLSignalEvent]
    = Json.format[OTIUMLSignalEvent]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLSlot
    */
  case class OTIUMLSlot
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLSlot
  {}

  object OTIUMLSlot {

    implicit def reads
    : Reads[OTIUMLSlot]
    = Json.reads[OTIUMLSlot]

    implicit def writes
    : Writes[OTIUMLSlot]
    = Json.writes[OTIUMLSlot]

    implicit def formats
    : Format[OTIUMLSlot]
    = Json.format[OTIUMLSlot]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLStartClassifierBehaviorAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLStartClassifierBehaviorAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLStartClassifierBehaviorAction
  {}

  object OTIUMLStartClassifierBehaviorAction {

    implicit def reads
    : Reads[OTIUMLStartClassifierBehaviorAction]
    = Json.reads[OTIUMLStartClassifierBehaviorAction]

    implicit def writes
    : Writes[OTIUMLStartClassifierBehaviorAction]
    = Json.writes[OTIUMLStartClassifierBehaviorAction]

    implicit def formats
    : Format[OTIUMLStartClassifierBehaviorAction]
    = Json.format[OTIUMLStartClassifierBehaviorAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLStartObjectBehaviorAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param isSynchronous Defined in CallAction
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLStartObjectBehaviorAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    isSynchronous: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLStartObjectBehaviorAction
  {}

  object OTIUMLStartObjectBehaviorAction {

    implicit def reads
    : Reads[OTIUMLStartObjectBehaviorAction]
    = Json.reads[OTIUMLStartObjectBehaviorAction]

    implicit def writes
    : Writes[OTIUMLStartObjectBehaviorAction]
    = Json.writes[OTIUMLStartObjectBehaviorAction]

    implicit def formats
    : Format[OTIUMLStartObjectBehaviorAction]
    = Json.format[OTIUMLStartObjectBehaviorAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLState
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLState
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLState
  {}

  object OTIUMLState {

    implicit def reads
    : Reads[OTIUMLState]
    = Json.reads[OTIUMLState]

    implicit def writes
    : Writes[OTIUMLState]
    = Json.writes[OTIUMLState]

    implicit def formats
    : Format[OTIUMLState]
    = Json.format[OTIUMLState]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLStateInvariant
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLStateInvariant
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLStateInvariant
  {}

  object OTIUMLStateInvariant {

    implicit def reads
    : Reads[OTIUMLStateInvariant]
    = Json.reads[OTIUMLStateInvariant]

    implicit def writes
    : Writes[OTIUMLStateInvariant]
    = Json.writes[OTIUMLStateInvariant]

    implicit def formats
    : Format[OTIUMLStateInvariant]
    = Json.format[OTIUMLStateInvariant]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLStateMachine
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param isReentrant Defined in Behavior
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLStateMachine
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    isReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLStateMachine
  {}

  object OTIUMLStateMachine {

    implicit def reads
    : Reads[OTIUMLStateMachine]
    = Json.reads[OTIUMLStateMachine]

    implicit def writes
    : Writes[OTIUMLStateMachine]
    = Json.writes[OTIUMLStateMachine]

    implicit def formats
    : Format[OTIUMLStateMachine]
    = Json.format[OTIUMLStateMachine]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLStereotype
    * @param isAbstract Defined in Class
    * @param isActive Defined in Class
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLStereotype
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isActive: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLStereotype
  {}

  object OTIUMLStereotype {

    implicit def reads
    : Reads[OTIUMLStereotype]
    = Json.reads[OTIUMLStereotype]

    implicit def writes
    : Writes[OTIUMLStereotype]
    = Json.writes[OTIUMLStereotype]

    implicit def formats
    : Format[OTIUMLStereotype]
    = Json.format[OTIUMLStereotype]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLStringExpression
    * @param name Defined in NamedElement
    * @param symbol Defined in Expression
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLStringExpression
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    symbol: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLStringExpression
  {}

  object OTIUMLStringExpression {

    implicit def reads
    : Reads[OTIUMLStringExpression]
    = Json.reads[OTIUMLStringExpression]

    implicit def writes
    : Writes[OTIUMLStringExpression]
    = Json.writes[OTIUMLStringExpression]

    implicit def formats
    : Format[OTIUMLStringExpression]
    = Json.format[OTIUMLStringExpression]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLStructuredActivityNode
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param mustIsolate Defined in StructuredActivityNode
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLStructuredActivityNode
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    mustIsolate: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLStructuredActivityNode
  {}

  object OTIUMLStructuredActivityNode {

    implicit def reads
    : Reads[OTIUMLStructuredActivityNode]
    = Json.reads[OTIUMLStructuredActivityNode]

    implicit def writes
    : Writes[OTIUMLStructuredActivityNode]
    = Json.writes[OTIUMLStructuredActivityNode]

    implicit def formats
    : Format[OTIUMLStructuredActivityNode]
    = Json.format[OTIUMLStructuredActivityNode]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLSubstitution
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLSubstitution
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLSubstitution
  {}

  object OTIUMLSubstitution {

    implicit def reads
    : Reads[OTIUMLSubstitution]
    = Json.reads[OTIUMLSubstitution]

    implicit def writes
    : Writes[OTIUMLSubstitution]
    = Json.writes[OTIUMLSubstitution]

    implicit def formats
    : Format[OTIUMLSubstitution]
    = Json.format[OTIUMLSubstitution]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTemplateBinding
    */
  case class OTIUMLTemplateBinding
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLTemplateBinding
  {}

  object OTIUMLTemplateBinding {

    implicit def reads
    : Reads[OTIUMLTemplateBinding]
    = Json.reads[OTIUMLTemplateBinding]

    implicit def writes
    : Writes[OTIUMLTemplateBinding]
    = Json.writes[OTIUMLTemplateBinding]

    implicit def formats
    : Format[OTIUMLTemplateBinding]
    = Json.format[OTIUMLTemplateBinding]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTemplateParameter
    */
  case class OTIUMLTemplateParameter
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLTemplateParameter
  {}

  object OTIUMLTemplateParameter {

    implicit def reads
    : Reads[OTIUMLTemplateParameter]
    = Json.reads[OTIUMLTemplateParameter]

    implicit def writes
    : Writes[OTIUMLTemplateParameter]
    = Json.writes[OTIUMLTemplateParameter]

    implicit def formats
    : Format[OTIUMLTemplateParameter]
    = Json.format[OTIUMLTemplateParameter]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTemplateParameterSubstitution
    */
  case class OTIUMLTemplateParameterSubstitution
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLTemplateParameterSubstitution
  {}

  object OTIUMLTemplateParameterSubstitution {

    implicit def reads
    : Reads[OTIUMLTemplateParameterSubstitution]
    = Json.reads[OTIUMLTemplateParameterSubstitution]

    implicit def writes
    : Writes[OTIUMLTemplateParameterSubstitution]
    = Json.writes[OTIUMLTemplateParameterSubstitution]

    implicit def formats
    : Format[OTIUMLTemplateParameterSubstitution]
    = Json.format[OTIUMLTemplateParameterSubstitution]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTemplateSignature
    */
  case class OTIUMLTemplateSignature
  ( override val otiMOFElementLocation: ElementLocation)
  extends OTIMOFElement
  with UMLTemplateSignature
  {}

  object OTIUMLTemplateSignature {

    implicit def reads
    : Reads[OTIUMLTemplateSignature]
    = Json.reads[OTIUMLTemplateSignature]

    implicit def writes
    : Writes[OTIUMLTemplateSignature]
    = Json.writes[OTIUMLTemplateSignature]

    implicit def formats
    : Format[OTIUMLTemplateSignature]
    = Json.format[OTIUMLTemplateSignature]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTestIdentityAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLTestIdentityAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLTestIdentityAction
  {}

  object OTIUMLTestIdentityAction {

    implicit def reads
    : Reads[OTIUMLTestIdentityAction]
    = Json.reads[OTIUMLTestIdentityAction]

    implicit def writes
    : Writes[OTIUMLTestIdentityAction]
    = Json.writes[OTIUMLTestIdentityAction]

    implicit def formats
    : Format[OTIUMLTestIdentityAction]
    = Json.format[OTIUMLTestIdentityAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTimeConstraint
    * @param firstEvent Defined in TimeConstraint
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLTimeConstraint
  ( override val otiMOFElementLocation: ElementLocation,
    firstEvent: Option[Boolean],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLTimeConstraint
  {}

  object OTIUMLTimeConstraint {

    implicit def reads
    : Reads[OTIUMLTimeConstraint]
    = Json.reads[OTIUMLTimeConstraint]

    implicit def writes
    : Writes[OTIUMLTimeConstraint]
    = Json.writes[OTIUMLTimeConstraint]

    implicit def formats
    : Format[OTIUMLTimeConstraint]
    = Json.format[OTIUMLTimeConstraint]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTimeEvent
    * @param isRelative Defined in TimeEvent
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLTimeEvent
  ( override val otiMOFElementLocation: ElementLocation,
    isRelative: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLTimeEvent
  {}

  object OTIUMLTimeEvent {

    implicit def reads
    : Reads[OTIUMLTimeEvent]
    = Json.reads[OTIUMLTimeEvent]

    implicit def writes
    : Writes[OTIUMLTimeEvent]
    = Json.writes[OTIUMLTimeEvent]

    implicit def formats
    : Format[OTIUMLTimeEvent]
    = Json.format[OTIUMLTimeEvent]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTimeExpression
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLTimeExpression
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLTimeExpression
  {}

  object OTIUMLTimeExpression {

    implicit def reads
    : Reads[OTIUMLTimeExpression]
    = Json.reads[OTIUMLTimeExpression]

    implicit def writes
    : Writes[OTIUMLTimeExpression]
    = Json.writes[OTIUMLTimeExpression]

    implicit def formats
    : Format[OTIUMLTimeExpression]
    = Json.format[OTIUMLTimeExpression]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTimeInterval
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLTimeInterval
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLTimeInterval
  {}

  object OTIUMLTimeInterval {

    implicit def reads
    : Reads[OTIUMLTimeInterval]
    = Json.reads[OTIUMLTimeInterval]

    implicit def writes
    : Writes[OTIUMLTimeInterval]
    = Json.writes[OTIUMLTimeInterval]

    implicit def formats
    : Format[OTIUMLTimeInterval]
    = Json.format[OTIUMLTimeInterval]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTimeObservation
    * @param firstEvent Defined in TimeObservation
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLTimeObservation
  ( override val otiMOFElementLocation: ElementLocation,
    firstEvent: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLTimeObservation
  {}

  object OTIUMLTimeObservation {

    implicit def reads
    : Reads[OTIUMLTimeObservation]
    = Json.reads[OTIUMLTimeObservation]

    implicit def writes
    : Writes[OTIUMLTimeObservation]
    = Json.writes[OTIUMLTimeObservation]

    implicit def formats
    : Format[OTIUMLTimeObservation]
    = Json.format[OTIUMLTimeObservation]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTransition
    * @param isLeaf Defined in RedefinableElement
    * @param kind Defined in Transition
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLTransition
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    kind: Option[UMLTransitionKind],
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLTransition
  {}

  object OTIUMLTransition {

    implicit def reads
    : Reads[OTIUMLTransition]
    = Json.reads[OTIUMLTransition]

    implicit def writes
    : Writes[OTIUMLTransition]
    = Json.writes[OTIUMLTransition]

    implicit def formats
    : Format[OTIUMLTransition]
    = Json.format[OTIUMLTransition]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLTrigger
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLTrigger
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLTrigger
  {}

  object OTIUMLTrigger {

    implicit def reads
    : Reads[OTIUMLTrigger]
    = Json.reads[OTIUMLTrigger]

    implicit def writes
    : Writes[OTIUMLTrigger]
    = Json.writes[OTIUMLTrigger]

    implicit def formats
    : Format[OTIUMLTrigger]
    = Json.format[OTIUMLTrigger]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLUnmarshallAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLUnmarshallAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLUnmarshallAction
  {}

  object OTIUMLUnmarshallAction {

    implicit def reads
    : Reads[OTIUMLUnmarshallAction]
    = Json.reads[OTIUMLUnmarshallAction]

    implicit def writes
    : Writes[OTIUMLUnmarshallAction]
    = Json.writes[OTIUMLUnmarshallAction]

    implicit def formats
    : Format[OTIUMLUnmarshallAction]
    = Json.format[OTIUMLUnmarshallAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLUsage
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLUsage
  ( override val otiMOFElementLocation: ElementLocation,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLUsage
  {}

  object OTIUMLUsage {

    implicit def reads
    : Reads[OTIUMLUsage]
    = Json.reads[OTIUMLUsage]

    implicit def writes
    : Writes[OTIUMLUsage]
    = Json.writes[OTIUMLUsage]

    implicit def formats
    : Format[OTIUMLUsage]
    = Json.format[OTIUMLUsage]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLUseCase
    * @param isAbstract Defined in Classifier
    * @param isFinalSpecialization Defined in Classifier
    * @param isLeaf Defined in RedefinableElement
    * @param name Defined in NamedElement
    * @param visibility Defined in PackageableElement
    */
  case class OTIUMLUseCase
  ( override val otiMOFElementLocation: ElementLocation,
    isAbstract: Boolean,
    isFinalSpecialization: Boolean,
    isLeaf: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLUseCase
  {}

  object OTIUMLUseCase {

    implicit def reads
    : Reads[OTIUMLUseCase]
    = Json.reads[OTIUMLUseCase]

    implicit def writes
    : Writes[OTIUMLUseCase]
    = Json.writes[OTIUMLUseCase]

    implicit def formats
    : Format[OTIUMLUseCase]
    = Json.format[OTIUMLUseCase]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLValuePin
    * @param isControl Defined in Pin
    * @param isControlType Defined in ObjectNode
    * @param isLeaf Defined in RedefinableElement
    * @param isOrdered Defined in MultiplicityElement
    * @param isUnique Defined in MultiplicityElement
    * @param name Defined in NamedElement
    * @param ordering Defined in ObjectNode
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLValuePin
  ( override val otiMOFElementLocation: ElementLocation,
    isControl: Boolean,
    isControlType: Boolean,
    isLeaf: Boolean,
    isOrdered: Boolean,
    isUnique: Boolean,
    name: Option[String],
    ordering: Option[UMLObjectNodeOrderingKind],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLValuePin
  {}

  object OTIUMLValuePin {

    implicit def reads
    : Reads[OTIUMLValuePin]
    = Json.reads[OTIUMLValuePin]

    implicit def writes
    : Writes[OTIUMLValuePin]
    = Json.writes[OTIUMLValuePin]

    implicit def formats
    : Format[OTIUMLValuePin]
    = Json.format[OTIUMLValuePin]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLValueSpecificationAction
    * @param isLeaf Defined in RedefinableElement
    * @param isLocallyReentrant Defined in Action
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLValueSpecificationAction
  ( override val otiMOFElementLocation: ElementLocation,
    isLeaf: Boolean,
    isLocallyReentrant: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLValueSpecificationAction
  {}

  object OTIUMLValueSpecificationAction {

    implicit def reads
    : Reads[OTIUMLValueSpecificationAction]
    = Json.reads[OTIUMLValueSpecificationAction]

    implicit def writes
    : Writes[OTIUMLValueSpecificationAction]
    = Json.writes[OTIUMLValueSpecificationAction]

    implicit def formats
    : Format[OTIUMLValueSpecificationAction]
    = Json.format[OTIUMLValueSpecificationAction]

  }

  /**
    * @param otiMOFElementLocation The element location of an OTIUMLVariable
    * @param isOrdered Defined in MultiplicityElement
    * @param isUnique Defined in MultiplicityElement
    * @param name Defined in NamedElement
    * @param visibility Defined in NamedElement
    */
  case class OTIUMLVariable
  ( override val otiMOFElementLocation: ElementLocation,
    isOrdered: Boolean,
    isUnique: Boolean,
    name: Option[String],
    visibility: Option[UMLVisibilityKind])
  extends OTIMOFElement
  with UMLVariable
  {}

  object OTIUMLVariable {

    implicit def reads
    : Reads[OTIUMLVariable]
    = Json.reads[OTIUMLVariable]

    implicit def writes
    : Writes[OTIUMLVariable]
    = Json.writes[OTIUMLVariable]

    implicit def formats
    : Format[OTIUMLVariable]
    = Json.format[OTIUMLVariable]

  }

  // <!-- Start of user code OTI MOF Element companion -->
  
  implicit val orderingOTIMOFElement
  : Ordering[OTIMOFElement]
  = new Ordering[OTIMOFElement] {

    def compare(x: OTIMOFElement, y: OTIMOFElement)
    : Int
    = ElementLocation.ordering.compare(x.otiMOFElementLocation, y.otiMOFElementLocation)

  }

  implicit val writesOTIMOFElement
  : Writes[OTIMOFElement]
  = Variants.writes[OTIMOFElement]((__ \ "type").format[String])

  implicit val readsOTIMOFElement
  : Reads[OTIMOFElement]
  = Variants.reads[OTIMOFElement]((__ \ "type").format[String])
  
  implicit val formatsOTIMOFElement
  : Format[OTIMOFElement]
  = Variants.format[OTIMOFElement]((__ \ "type").format[String])

  // <!-- End of user code OTI MOF Element companion -->

}
