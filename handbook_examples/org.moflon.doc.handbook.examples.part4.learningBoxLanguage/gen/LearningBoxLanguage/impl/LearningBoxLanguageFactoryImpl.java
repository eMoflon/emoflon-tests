/**
 */
package LearningBoxLanguage.impl;

import LearningBoxLanguage.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningBoxLanguageFactoryImpl extends EFactoryImpl implements LearningBoxLanguageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LearningBoxLanguageFactory init() {
		try {
			LearningBoxLanguageFactory theLearningBoxLanguageFactory = (LearningBoxLanguageFactory) EPackage.Registry.INSTANCE
					.getEFactory(LearningBoxLanguagePackage.eNS_URI);
			if (theLearningBoxLanguageFactory != null) {
				return theLearningBoxLanguageFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LearningBoxLanguageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LearningBoxLanguageFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case LearningBoxLanguagePackage.BOX:
			return createBox();
		case LearningBoxLanguagePackage.PARTITION:
			return createPartition();
		case LearningBoxLanguagePackage.CARD:
			return createCard();
		case LearningBoxLanguagePackage.FAST_CARD:
			return createFastCard();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Box createBox() {
		BoxImpl box = new BoxImpl();
		return box;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partition createPartition() {
		PartitionImpl partition = new PartitionImpl();
		return partition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Card createCard() {
		CardImpl card = new CardImpl();
		return card;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FastCard createFastCard() {
		FastCardImpl fastCard = new FastCardImpl();
		return fastCard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LearningBoxLanguagePackage getLearningBoxLanguagePackage() {
		return (LearningBoxLanguagePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LearningBoxLanguagePackage getPackage() {
		return LearningBoxLanguagePackage.eINSTANCE;
	}

} //LearningBoxLanguageFactoryImpl
