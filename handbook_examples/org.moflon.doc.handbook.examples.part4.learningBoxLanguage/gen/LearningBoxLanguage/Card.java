/**
 */
package LearningBoxLanguage;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Card</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LearningBoxLanguage.Card#getCardContainer <em>Card Container</em>}</li>
 *   <li>{@link LearningBoxLanguage.Card#getBack <em>Back</em>}</li>
 *   <li>{@link LearningBoxLanguage.Card#getFace <em>Face</em>}</li>
 *   <li>{@link LearningBoxLanguage.Card#getPartitionHistory <em>Partition History</em>}</li>
 * </ul>
 * </p>
 *
 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getCard()
 * @model
 * @generated
 */
public interface Card extends EObject {
	/**
	 * Returns the value of the '<em><b>Card Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link LearningBoxLanguage.Partition#getCard <em>Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Card Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Card Container</em>' container reference.
	 * @see #setCardContainer(Partition)
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getCard_CardContainer()
	 * @see LearningBoxLanguage.Partition#getCard
	 * @model opposite="card" transient="false"
	 * @generated
	 */
	Partition getCardContainer();

	/**
	 * Sets the value of the '{@link LearningBoxLanguage.Card#getCardContainer <em>Card Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Card Container</em>' container reference.
	 * @see #getCardContainer()
	 * @generated
	 */
	void setCardContainer(Partition value);

	/**
	 * Returns the value of the '<em><b>Back</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Back</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Back</em>' attribute.
	 * @see #setBack(String)
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getCard_Back()
	 * @model ordered="false"
	 * @generated
	 */
	String getBack();

	/**
	 * Sets the value of the '{@link LearningBoxLanguage.Card#getBack <em>Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Back</em>' attribute.
	 * @see #getBack()
	 * @generated
	 */
	void setBack(String value);

	/**
	 * Returns the value of the '<em><b>Face</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Face</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Face</em>' attribute.
	 * @see #setFace(String)
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getCard_Face()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getFace();

	/**
	 * Sets the value of the '{@link LearningBoxLanguage.Card#getFace <em>Face</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Face</em>' attribute.
	 * @see #getFace()
	 * @generated
	 */
	void setFace(String value);

	/**
	 * Returns the value of the '<em><b>Partition History</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partition History</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partition History</em>' attribute.
	 * @see #setPartitionHistory(String)
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getCard_PartitionHistory()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getPartitionHistory();

	/**
	 * Sets the value of the '{@link LearningBoxLanguage.Card#getPartitionHistory <em>Partition History</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partition History</em>' attribute.
	 * @see #getPartitionHistory()
	 * @generated
	 */
	void setPartitionHistory(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void invert();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void printCard();
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // Card
