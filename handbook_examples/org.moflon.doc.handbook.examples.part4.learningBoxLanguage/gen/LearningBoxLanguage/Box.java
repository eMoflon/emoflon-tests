/**
 */
package LearningBoxLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LearningBoxLanguage.Box#getContainedPartition <em>Contained Partition</em>}</li>
 *   <li>{@link LearningBoxLanguage.Box#getName <em>Name</em>}</li>
 *   <li>{@link LearningBoxLanguage.Box#getStringRep <em>String Rep</em>}</li>
 * </ul>
 * </p>
 *
 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getBox()
 * @model
 * @generated
 */
public interface Box extends EObject {
	/**
	 * Returns the value of the '<em><b>Contained Partition</b></em>' containment reference list.
	 * The list contents are of type {@link LearningBoxLanguage.Partition}.
	 * It is bidirectional and its opposite is '{@link LearningBoxLanguage.Partition#getBox <em>Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Partition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Partition</em>' containment reference list.
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getBox_ContainedPartition()
	 * @see LearningBoxLanguage.Partition#getBox
	 * @model opposite="box" containment="true"
	 * @generated
	 */
	EList<Partition> getContainedPartition();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getBox_Name()
	 * @model ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link LearningBoxLanguage.Box#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>String Rep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Rep</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Rep</em>' attribute.
	 * @see #setStringRep(String)
	 * @see LearningBoxLanguage.LearningBoxLanguagePackage#getBox_StringRep()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getStringRep();

	/**
	 * Sets the value of the '{@link LearningBoxLanguage.Box#getStringRep <em>String Rep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Rep</em>' attribute.
	 * @see #getStringRep()
	 * @generated
	 */
	void setStringRep(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addToStringRep(Card card);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int determineNextSize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean grow();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean initializeBox();
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // Box
