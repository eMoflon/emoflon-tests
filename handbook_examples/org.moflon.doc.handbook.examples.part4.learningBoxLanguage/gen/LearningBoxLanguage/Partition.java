/**
 */
package LearningBoxLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LearningBoxLanguage.Partition#getCard <em>Card</em>}</li>
 *   <li>{@link LearningBoxLanguage.Partition#getBox <em>Box</em>}</li>
 *   <li>{@link LearningBoxLanguage.Partition#getPrevious <em>Previous</em>}</li>
 *   <li>{@link LearningBoxLanguage.Partition#getNext <em>Next</em>}</li>
 *   <li>{@link LearningBoxLanguage.Partition#getIndex <em>Index</em>}</li>
 *   <li>{@link LearningBoxLanguage.Partition#getPartitionSize <em>Partition Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getPartition()
 * @model
 * @generated
 */
public interface Partition extends EObject {
	/**
	 * Returns the value of the '<em><b>Card</b></em>' containment reference list.
	 * The list contents are of type {@link LearningBoxLanguage.Card}.
	 * It is bidirectional and its opposite is '{@link LearningBoxLanguage.Card#getCardContainer <em>Card Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Card</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Card</em>' containment reference list.
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getPartition_Card()
	 * @see LearningBoxLanguage.Card#getCardContainer
	 * @model opposite="cardContainer" containment="true"
	 * @generated
	 */
	EList<Card> getCard();

	/**
	 * Returns the value of the '<em><b>Box</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link LearningBoxLanguage.Box#getContainedPartition <em>Contained Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box</em>' container reference.
	 * @see #setBox(Box)
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getPartition_Box()
	 * @see LearningBoxLanguage.Box#getContainedPartition
	 * @model opposite="containedPartition" transient="false"
	 * @generated
	 */
	Box getBox();

	/**
	 * Sets the value of the '{@link LearningBoxLanguage.Partition#getBox <em>Box</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box</em>' container reference.
	 * @see #getBox()
	 * @generated
	 */
	void setBox(Box value);

	/**
	 * Returns the value of the '<em><b>Previous</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Previous</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous</em>' reference.
	 * @see #setPrevious(Partition)
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getPartition_Previous()
	 * @model
	 * @generated
	 */
	Partition getPrevious();

	/**
	 * Sets the value of the '{@link LearningBoxLanguage.Partition#getPrevious <em>Previous</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous</em>' reference.
	 * @see #getPrevious()
	 * @generated
	 */
	void setPrevious(Partition value);

	/**
	 * Returns the value of the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next</em>' reference.
	 * @see #setNext(Partition)
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getPartition_Next()
	 * @model
	 * @generated
	 */
	Partition getNext();

	/**
	 * Sets the value of the '{@link LearningBoxLanguage.Partition#getNext <em>Next</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(Partition value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getPartition_Index()
	 * @model ordered="false"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link LearningBoxLanguage.Partition#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Partition Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partition Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partition Size</em>' attribute.
	 * @see #setPartitionSize(int)
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getPartition_PartitionSize()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getPartitionSize();

	/**
	 * Sets the value of the '{@link LearningBoxLanguage.Partition#getPartitionSize <em>Partition Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partition Size</em>' attribute.
	 * @see #getPartitionSize()
	 * @generated
	 */
	void setPartitionSize(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean check(Card card, String guess);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void empty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Card removeCard(Card card);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // Partition
