/**
 */
package LearningBoxLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see LearningBoxLanguage.LearningBoxLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface LearningBoxLanguagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "LearningBoxLanguage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/plugin/LearningBoxLanguage/model/LearningBoxLanguage.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "LearningBoxLanguage";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LearningBoxLanguagePackage eINSTANCE = LearningBoxLanguage.impl.LearningBoxLanguagePackageImpl.init();

	/**
	 * The meta object id for the '{@link LearningBoxLanguage.impl.BoxImpl <em>Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see LearningBoxLanguage.impl.BoxImpl
	 * @see LearningBoxLanguage.impl.LearningBoxLanguagePackageImpl#getBox()
	 * @generated
	 */
	int BOX = 0;

	/**
	 * The feature id for the '<em><b>Contained Partition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__CONTAINED_PARTITION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__NAME = 1;

	/**
	 * The feature id for the '<em><b>String Rep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__STRING_REP = 2;

	/**
	 * The number of structural features of the '<em>Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Add To String Rep</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX___ADD_TO_STRING_REP__CARD = 0;

	/**
	 * The operation id for the '<em>Determine Next Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX___DETERMINE_NEXT_SIZE = 1;

	/**
	 * The operation id for the '<em>Grow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX___GROW = 2;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX___TO_STRING = 3;

	/**
	 * The operation id for the '<em>Initialize Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX___INITIALIZE_BOX = 4;

	/**
	 * The number of operations of the '<em>Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX_OPERATION_COUNT = 5;

	/**
	 * The meta object id for the '{@link LearningBoxLanguage.impl.PartitionImpl <em>Partition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see LearningBoxLanguage.impl.PartitionImpl
	 * @see LearningBoxLanguage.impl.LearningBoxLanguagePackageImpl#getPartition()
	 * @generated
	 */
	int PARTITION = 1;

	/**
	 * The feature id for the '<em><b>Card</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION__CARD = 0;

	/**
	 * The feature id for the '<em><b>Box</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION__BOX = 1;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION__PREVIOUS = 2;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION__NEXT = 3;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION__INDEX = 4;

	/**
	 * The feature id for the '<em><b>Partition Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION__PARTITION_SIZE = 5;

	/**
	 * The number of structural features of the '<em>Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Check</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION___CHECK__CARD_STRING = 0;

	/**
	 * The operation id for the '<em>Empty</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION___EMPTY = 1;

	/**
	 * The operation id for the '<em>Remove Card</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION___REMOVE_CARD__CARD = 2;

	/**
	 * The number of operations of the '<em>Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link LearningBoxLanguage.impl.CardImpl <em>Card</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see LearningBoxLanguage.impl.CardImpl
	 * @see LearningBoxLanguage.impl.LearningBoxLanguagePackageImpl#getCard()
	 * @generated
	 */
	int CARD = 2;

	/**
	 * The feature id for the '<em><b>Card Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD__CARD_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Back</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD__BACK = 1;

	/**
	 * The feature id for the '<em><b>Face</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD__FACE = 2;

	/**
	 * The feature id for the '<em><b>Partition History</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD__PARTITION_HISTORY = 3;

	/**
	 * The number of structural features of the '<em>Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Invert</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD___INVERT = 0;

	/**
	 * The operation id for the '<em>Print Card</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD___PRINT_CARD = 1;

	/**
	 * The number of operations of the '<em>Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link LearningBoxLanguage.impl.FastCardImpl <em>Fast Card</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see LearningBoxLanguage.impl.FastCardImpl
	 * @see LearningBoxLanguage.impl.LearningBoxLanguagePackageImpl#getFastCard()
	 * @generated
	 */
	int FAST_CARD = 3;

	/**
	 * The feature id for the '<em><b>Card Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_CARD__CARD_CONTAINER = CARD__CARD_CONTAINER;

	/**
	 * The feature id for the '<em><b>Back</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_CARD__BACK = CARD__BACK;

	/**
	 * The feature id for the '<em><b>Face</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_CARD__FACE = CARD__FACE;

	/**
	 * The feature id for the '<em><b>Partition History</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_CARD__PARTITION_HISTORY = CARD__PARTITION_HISTORY;

	/**
	 * The number of structural features of the '<em>Fast Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_CARD_FEATURE_COUNT = CARD_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Invert</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_CARD___INVERT = CARD___INVERT;

	/**
	 * The operation id for the '<em>Print Card</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_CARD___PRINT_CARD = CARD___PRINT_CARD;

	/**
	 * The number of operations of the '<em>Fast Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_CARD_OPERATION_COUNT = CARD_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link LearningBoxLanguage.Box <em>Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Box</em>'.
	 * @see LearningBoxLanguage.Box
	 * @generated
	 */
	EClass getBox();

	/**
	 * Returns the meta object for the containment reference list '{@link LearningBoxLanguage.Box#getContainedPartition <em>Contained Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Partition</em>'.
	 * @see LearningBoxLanguage.Box#getContainedPartition()
	 * @see #getBox()
	 * @generated
	 */
	EReference getBox_ContainedPartition();

	/**
	 * Returns the meta object for the attribute '{@link LearningBoxLanguage.Box#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see LearningBoxLanguage.Box#getName()
	 * @see #getBox()
	 * @generated
	 */
	EAttribute getBox_Name();

	/**
	 * Returns the meta object for the attribute '{@link LearningBoxLanguage.Box#getStringRep <em>String Rep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Rep</em>'.
	 * @see LearningBoxLanguage.Box#getStringRep()
	 * @see #getBox()
	 * @generated
	 */
	EAttribute getBox_StringRep();

	/**
	 * Returns the meta object for the '{@link LearningBoxLanguage.Box#addToStringRep(LearningBoxLanguage.Card) <em>Add To String Rep</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add To String Rep</em>' operation.
	 * @see LearningBoxLanguage.Box#addToStringRep(LearningBoxLanguage.Card)
	 * @generated
	 */
	EOperation getBox__AddToStringRep__Card();

	/**
	 * Returns the meta object for the '{@link LearningBoxLanguage.Box#determineNextSize() <em>Determine Next Size</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Determine Next Size</em>' operation.
	 * @see LearningBoxLanguage.Box#determineNextSize()
	 * @generated
	 */
	EOperation getBox__DetermineNextSize();

	/**
	 * Returns the meta object for the '{@link LearningBoxLanguage.Box#grow() <em>Grow</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Grow</em>' operation.
	 * @see LearningBoxLanguage.Box#grow()
	 * @generated
	 */
	EOperation getBox__Grow();

	/**
	 * Returns the meta object for the '{@link LearningBoxLanguage.Box#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see LearningBoxLanguage.Box#toString()
	 * @generated
	 */
	EOperation getBox__ToString();

	/**
	 * Returns the meta object for the '{@link LearningBoxLanguage.Box#initializeBox() <em>Initialize Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Initialize Box</em>' operation.
	 * @see LearningBoxLanguage.Box#initializeBox()
	 * @generated
	 */
	EOperation getBox__InitializeBox();

	/**
	 * Returns the meta object for class '{@link LearningBoxLanguage.Partition <em>Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partition</em>'.
	 * @see LearningBoxLanguage.Partition
	 * @generated
	 */
	EClass getPartition();

	/**
	 * Returns the meta object for the containment reference list '{@link LearningBoxLanguage.Partition#getCard <em>Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Card</em>'.
	 * @see LearningBoxLanguage.Partition#getCard()
	 * @see #getPartition()
	 * @generated
	 */
	EReference getPartition_Card();

	/**
	 * Returns the meta object for the container reference '{@link LearningBoxLanguage.Partition#getBox <em>Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Box</em>'.
	 * @see LearningBoxLanguage.Partition#getBox()
	 * @see #getPartition()
	 * @generated
	 */
	EReference getPartition_Box();

	/**
	 * Returns the meta object for the reference '{@link LearningBoxLanguage.Partition#getPrevious <em>Previous</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous</em>'.
	 * @see LearningBoxLanguage.Partition#getPrevious()
	 * @see #getPartition()
	 * @generated
	 */
	EReference getPartition_Previous();

	/**
	 * Returns the meta object for the reference '{@link LearningBoxLanguage.Partition#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next</em>'.
	 * @see LearningBoxLanguage.Partition#getNext()
	 * @see #getPartition()
	 * @generated
	 */
	EReference getPartition_Next();

	/**
	 * Returns the meta object for the attribute '{@link LearningBoxLanguage.Partition#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see LearningBoxLanguage.Partition#getIndex()
	 * @see #getPartition()
	 * @generated
	 */
	EAttribute getPartition_Index();

	/**
	 * Returns the meta object for the attribute '{@link LearningBoxLanguage.Partition#getPartitionSize <em>Partition Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partition Size</em>'.
	 * @see LearningBoxLanguage.Partition#getPartitionSize()
	 * @see #getPartition()
	 * @generated
	 */
	EAttribute getPartition_PartitionSize();

	/**
	 * Returns the meta object for the '{@link LearningBoxLanguage.Partition#check(LearningBoxLanguage.Card, java.lang.String) <em>Check</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check</em>' operation.
	 * @see LearningBoxLanguage.Partition#check(LearningBoxLanguage.Card, java.lang.String)
	 * @generated
	 */
	EOperation getPartition__Check__Card_String();

	/**
	 * Returns the meta object for the '{@link LearningBoxLanguage.Partition#empty() <em>Empty</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Empty</em>' operation.
	 * @see LearningBoxLanguage.Partition#empty()
	 * @generated
	 */
	EOperation getPartition__Empty();

	/**
	 * Returns the meta object for the '{@link LearningBoxLanguage.Partition#removeCard(LearningBoxLanguage.Card) <em>Remove Card</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Card</em>' operation.
	 * @see LearningBoxLanguage.Partition#removeCard(LearningBoxLanguage.Card)
	 * @generated
	 */
	EOperation getPartition__RemoveCard__Card();

	/**
	 * Returns the meta object for class '{@link LearningBoxLanguage.Card <em>Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Card</em>'.
	 * @see LearningBoxLanguage.Card
	 * @generated
	 */
	EClass getCard();

	/**
	 * Returns the meta object for the container reference '{@link LearningBoxLanguage.Card#getCardContainer <em>Card Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Card Container</em>'.
	 * @see LearningBoxLanguage.Card#getCardContainer()
	 * @see #getCard()
	 * @generated
	 */
	EReference getCard_CardContainer();

	/**
	 * Returns the meta object for the attribute '{@link LearningBoxLanguage.Card#getBack <em>Back</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Back</em>'.
	 * @see LearningBoxLanguage.Card#getBack()
	 * @see #getCard()
	 * @generated
	 */
	EAttribute getCard_Back();

	/**
	 * Returns the meta object for the attribute '{@link LearningBoxLanguage.Card#getFace <em>Face</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Face</em>'.
	 * @see LearningBoxLanguage.Card#getFace()
	 * @see #getCard()
	 * @generated
	 */
	EAttribute getCard_Face();

	/**
	 * Returns the meta object for the attribute '{@link LearningBoxLanguage.Card#getPartitionHistory <em>Partition History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partition History</em>'.
	 * @see LearningBoxLanguage.Card#getPartitionHistory()
	 * @see #getCard()
	 * @generated
	 */
	EAttribute getCard_PartitionHistory();

	/**
	 * Returns the meta object for the '{@link LearningBoxLanguage.Card#invert() <em>Invert</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Invert</em>' operation.
	 * @see LearningBoxLanguage.Card#invert()
	 * @generated
	 */
	EOperation getCard__Invert();

	/**
	 * Returns the meta object for the '{@link LearningBoxLanguage.Card#printCard() <em>Print Card</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Print Card</em>' operation.
	 * @see LearningBoxLanguage.Card#printCard()
	 * @generated
	 */
	EOperation getCard__PrintCard();

	/**
	 * Returns the meta object for class '{@link LearningBoxLanguage.FastCard <em>Fast Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fast Card</em>'.
	 * @see LearningBoxLanguage.FastCard
	 * @generated
	 */
	EClass getFastCard();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LearningBoxLanguageFactory getLearningBoxLanguageFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link LearningBoxLanguage.impl.BoxImpl <em>Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see LearningBoxLanguage.impl.BoxImpl
		 * @see LearningBoxLanguage.impl.LearningBoxLanguagePackageImpl#getBox()
		 * @generated
		 */
		EClass BOX = eINSTANCE.getBox();

		/**
		 * The meta object literal for the '<em><b>Contained Partition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOX__CONTAINED_PARTITION = eINSTANCE.getBox_ContainedPartition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX__NAME = eINSTANCE.getBox_Name();

		/**
		 * The meta object literal for the '<em><b>String Rep</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX__STRING_REP = eINSTANCE.getBox_StringRep();

		/**
		 * The meta object literal for the '<em><b>Add To String Rep</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOX___ADD_TO_STRING_REP__CARD = eINSTANCE.getBox__AddToStringRep__Card();

		/**
		 * The meta object literal for the '<em><b>Determine Next Size</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOX___DETERMINE_NEXT_SIZE = eINSTANCE.getBox__DetermineNextSize();

		/**
		 * The meta object literal for the '<em><b>Grow</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOX___GROW = eINSTANCE.getBox__Grow();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOX___TO_STRING = eINSTANCE.getBox__ToString();

		/**
		 * The meta object literal for the '<em><b>Initialize Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOX___INITIALIZE_BOX = eINSTANCE.getBox__InitializeBox();

		/**
		 * The meta object literal for the '{@link LearningBoxLanguage.impl.PartitionImpl <em>Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see LearningBoxLanguage.impl.PartitionImpl
		 * @see LearningBoxLanguage.impl.LearningBoxLanguagePackageImpl#getPartition()
		 * @generated
		 */
		EClass PARTITION = eINSTANCE.getPartition();

		/**
		 * The meta object literal for the '<em><b>Card</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTITION__CARD = eINSTANCE.getPartition_Card();

		/**
		 * The meta object literal for the '<em><b>Box</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTITION__BOX = eINSTANCE.getPartition_Box();

		/**
		 * The meta object literal for the '<em><b>Previous</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTITION__PREVIOUS = eINSTANCE.getPartition_Previous();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTITION__NEXT = eINSTANCE.getPartition_Next();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTITION__INDEX = eINSTANCE.getPartition_Index();

		/**
		 * The meta object literal for the '<em><b>Partition Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTITION__PARTITION_SIZE = eINSTANCE.getPartition_PartitionSize();

		/**
		 * The meta object literal for the '<em><b>Check</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARTITION___CHECK__CARD_STRING = eINSTANCE.getPartition__Check__Card_String();

		/**
		 * The meta object literal for the '<em><b>Empty</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARTITION___EMPTY = eINSTANCE.getPartition__Empty();

		/**
		 * The meta object literal for the '<em><b>Remove Card</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARTITION___REMOVE_CARD__CARD = eINSTANCE.getPartition__RemoveCard__Card();

		/**
		 * The meta object literal for the '{@link LearningBoxLanguage.impl.CardImpl <em>Card</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see LearningBoxLanguage.impl.CardImpl
		 * @see LearningBoxLanguage.impl.LearningBoxLanguagePackageImpl#getCard()
		 * @generated
		 */
		EClass CARD = eINSTANCE.getCard();

		/**
		 * The meta object literal for the '<em><b>Card Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARD__CARD_CONTAINER = eINSTANCE.getCard_CardContainer();

		/**
		 * The meta object literal for the '<em><b>Back</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARD__BACK = eINSTANCE.getCard_Back();

		/**
		 * The meta object literal for the '<em><b>Face</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARD__FACE = eINSTANCE.getCard_Face();

		/**
		 * The meta object literal for the '<em><b>Partition History</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARD__PARTITION_HISTORY = eINSTANCE.getCard_PartitionHistory();

		/**
		 * The meta object literal for the '<em><b>Invert</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARD___INVERT = eINSTANCE.getCard__Invert();

		/**
		 * The meta object literal for the '<em><b>Print Card</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CARD___PRINT_CARD = eINSTANCE.getCard__PrintCard();

		/**
		 * The meta object literal for the '{@link LearningBoxLanguage.impl.FastCardImpl <em>Fast Card</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see LearningBoxLanguage.impl.FastCardImpl
		 * @see LearningBoxLanguage.impl.LearningBoxLanguagePackageImpl#getFastCard()
		 * @generated
		 */
		EClass FAST_CARD = eINSTANCE.getFastCard();

	}

} //LearningBoxLanguagePackage
