/**
 */
package LearningBoxLanguage.impl;

import LearningBoxLanguage.Box;
import LearningBoxLanguage.Card;
import LearningBoxLanguage.FastCard;
import LearningBoxLanguage.LearningBoxLanguageFactory;
import LearningBoxLanguage.LearningBoxLanguagePackage;
import LearningBoxLanguage.Partition;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningBoxLanguagePackageImpl extends EPackageImpl implements LearningBoxLanguagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fastCardEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LearningBoxLanguagePackageImpl() {
		super(eNS_URI, LearningBoxLanguageFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link LearningBoxLanguagePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LearningBoxLanguagePackage init() {
		if (isInited)
			return (LearningBoxLanguagePackage) EPackage.Registry.INSTANCE
					.getEPackage(LearningBoxLanguagePackage.eNS_URI);

		// Obtain or create and register package
		LearningBoxLanguagePackageImpl theLearningBoxLanguagePackage = (LearningBoxLanguagePackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof LearningBoxLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new LearningBoxLanguagePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theLearningBoxLanguagePackage.createPackageContents();

		// Initialize created meta-data
		theLearningBoxLanguagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLearningBoxLanguagePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LearningBoxLanguagePackage.eNS_URI, theLearningBoxLanguagePackage);
		return theLearningBoxLanguagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBox() {
		return boxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBox_ContainedPartition() {
		return (EReference) boxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBox_Name() {
		return (EAttribute) boxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBox_StringRep() {
		return (EAttribute) boxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBox__AddToStringRep__Card() {
		return boxEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBox__DetermineNextSize() {
		return boxEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBox__Grow() {
		return boxEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBox__ToString() {
		return boxEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBox__InitializeBox() {
		return boxEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartition() {
		return partitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_Card() {
		return (EReference) partitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_Box() {
		return (EReference) partitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_Previous() {
		return (EReference) partitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_Next() {
		return (EReference) partitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartition_Index() {
		return (EAttribute) partitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartition_PartitionSize() {
		return (EAttribute) partitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPartition__Check__Card_String() {
		return partitionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPartition__Empty() {
		return partitionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPartition__RemoveCard__Card() {
		return partitionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCard() {
		return cardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCard_CardContainer() {
		return (EReference) cardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCard_Back() {
		return (EAttribute) cardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCard_Face() {
		return (EAttribute) cardEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCard_PartitionHistory() {
		return (EAttribute) cardEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCard__Invert() {
		return cardEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCard__PrintCard() {
		return cardEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFastCard() {
		return fastCardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LearningBoxLanguageFactory getLearningBoxLanguageFactory() {
		return (LearningBoxLanguageFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		boxEClass = createEClass(BOX);
		createEReference(boxEClass, BOX__CONTAINED_PARTITION);
		createEAttribute(boxEClass, BOX__NAME);
		createEAttribute(boxEClass, BOX__STRING_REP);
		createEOperation(boxEClass, BOX___ADD_TO_STRING_REP__CARD);
		createEOperation(boxEClass, BOX___DETERMINE_NEXT_SIZE);
		createEOperation(boxEClass, BOX___GROW);
		createEOperation(boxEClass, BOX___TO_STRING);
		createEOperation(boxEClass, BOX___INITIALIZE_BOX);

		partitionEClass = createEClass(PARTITION);
		createEReference(partitionEClass, PARTITION__CARD);
		createEReference(partitionEClass, PARTITION__BOX);
		createEReference(partitionEClass, PARTITION__PREVIOUS);
		createEReference(partitionEClass, PARTITION__NEXT);
		createEAttribute(partitionEClass, PARTITION__INDEX);
		createEAttribute(partitionEClass, PARTITION__PARTITION_SIZE);
		createEOperation(partitionEClass, PARTITION___CHECK__CARD_STRING);
		createEOperation(partitionEClass, PARTITION___EMPTY);
		createEOperation(partitionEClass, PARTITION___REMOVE_CARD__CARD);

		cardEClass = createEClass(CARD);
		createEReference(cardEClass, CARD__CARD_CONTAINER);
		createEAttribute(cardEClass, CARD__BACK);
		createEAttribute(cardEClass, CARD__FACE);
		createEAttribute(cardEClass, CARD__PARTITION_HISTORY);
		createEOperation(cardEClass, CARD___INVERT);
		createEOperation(cardEClass, CARD___PRINT_CARD);

		fastCardEClass = createEClass(FAST_CARD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		fastCardEClass.getESuperTypes().add(this.getCard());

		// Initialize classes, features, and operations; add parameters
		initEClass(boxEClass, Box.class, "Box", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBox_ContainedPartition(), this.getPartition(), this.getPartition_Box(), "containedPartition",
				null, 0, -1, Box.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBox_Name(), ecorePackage.getEString(), "name", null, 0, 1, Box.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBox_StringRep(), ecorePackage.getEString(), "stringRep", null, 1, 1, Box.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = initEOperation(getBox__AddToStringRep__Card(), null, "addToStringRep", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, this.getCard(), "card", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getBox__DetermineNextSize(), ecorePackage.getEInt(), "determineNextSize", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getBox__Grow(), ecorePackage.getEBoolean(), "grow", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getBox__ToString(), ecorePackage.getEString(), "toString", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getBox__InitializeBox(), ecorePackage.getEBoolean(), "initializeBox", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(partitionEClass, Partition.class, "Partition", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartition_Card(), this.getCard(), this.getCard_CardContainer(), "card", null, 0, -1,
				Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_Box(), this.getBox(), this.getBox_ContainedPartition(), "box", null, 0, 1,
				Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_Previous(), this.getPartition(), null, "previous", null, 0, 1, Partition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_Next(), this.getPartition(), null, "next", null, 0, 1, Partition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPartition_Index(), ecorePackage.getEInt(), "index", null, 0, 1, Partition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getPartition_PartitionSize(), ecorePackage.getEInt(), "partitionSize", null, 1, 1,
				Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getPartition__Check__Card_String(), ecorePackage.getEBoolean(), "check", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, this.getCard(), "card", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "guess", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPartition__Empty(), null, "empty", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPartition__RemoveCard__Card(), this.getCard(), "removeCard", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, this.getCard(), "card", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(cardEClass, Card.class, "Card", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCard_CardContainer(), this.getPartition(), this.getPartition_Card(), "cardContainer", null, 0,
				1, Card.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCard_Back(), ecorePackage.getEString(), "back", null, 0, 1, Card.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCard_Face(), ecorePackage.getEString(), "face", null, 1, 1, Card.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCard_PartitionHistory(), ecorePackage.getEString(), "partitionHistory", null, 1, 1,
				Card.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);

		initEOperation(getCard__Invert(), null, "invert", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getCard__PrintCard(), null, "printCard", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fastCardEClass, FastCard.class, "FastCard", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //LearningBoxLanguagePackageImpl
