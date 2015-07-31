/**
 */
package LearningBoxLanguage.impl;

import LearningBoxLanguage.Card;
import LearningBoxLanguage.LearningBoxLanguageFactory;
import LearningBoxLanguage.LearningBoxLanguagePackage;
import LearningBoxLanguage.Partition;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Card</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link LearningBoxLanguage.impl.CardImpl#getCardContainer <em>Card Container</em>}</li>
 *   <li>{@link LearningBoxLanguage.impl.CardImpl#getBack <em>Back</em>}</li>
 *   <li>{@link LearningBoxLanguage.impl.CardImpl#getFace <em>Face</em>}</li>
 *   <li>{@link LearningBoxLanguage.impl.CardImpl#getPartitionHistory <em>Partition History</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CardImpl extends EObjectImpl implements Card {
	/**
	 * The default value of the '{@link #getBack() <em>Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBack()
	 * @generated
	 * @ordered
	 */
	protected static final String BACK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBack() <em>Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBack()
	 * @generated
	 * @ordered
	 */
	protected String back = BACK_EDEFAULT;

	/**
	 * The default value of the '{@link #getFace() <em>Face</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFace()
	 * @generated
	 * @ordered
	 */
	protected static final String FACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFace() <em>Face</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFace()
	 * @generated
	 * @ordered
	 */
	protected String face = FACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartitionHistory() <em>Partition History</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionHistory()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTITION_HISTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartitionHistory() <em>Partition History</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionHistory()
	 * @generated
	 * @ordered
	 */
	protected String partitionHistory = PARTITION_HISTORY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LearningBoxLanguagePackage.Literals.CARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partition getCardContainer() {
		if (eContainerFeatureID() != LearningBoxLanguagePackage.CARD__CARD_CONTAINER)
			return null;
		return (Partition) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCardContainer(Partition newCardContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newCardContainer, LearningBoxLanguagePackage.CARD__CARD_CONTAINER,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCardContainer(Partition newCardContainer) {
		if (newCardContainer != eInternalContainer()
				|| (eContainerFeatureID() != LearningBoxLanguagePackage.CARD__CARD_CONTAINER
						&& newCardContainer != null)) {
			if (EcoreUtil.isAncestor(this, newCardContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCardContainer != null)
				msgs = ((InternalEObject) newCardContainer).eInverseAdd(this,
						LearningBoxLanguagePackage.PARTITION__CARD, Partition.class, msgs);
			msgs = basicSetCardContainer(newCardContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LearningBoxLanguagePackage.CARD__CARD_CONTAINER,
					newCardContainer, newCardContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBack() {
		return back;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBack(String newBack) {
		String oldBack = back;
		back = newBack;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LearningBoxLanguagePackage.CARD__BACK, oldBack,
					back));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFace() {
		return face;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFace(String newFace) {
		String oldFace = face;
		face = newFace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LearningBoxLanguagePackage.CARD__FACE, oldFace,
					face));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartitionHistory() {
		return partitionHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartitionHistory(String newPartitionHistory) {
		String oldPartitionHistory = partitionHistory;
		partitionHistory = newPartitionHistory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LearningBoxLanguagePackage.CARD__PARTITION_HISTORY,
					oldPartitionHistory, partitionHistory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void invert() {
		// initializeTemp
		Object[] result1_black = CardImpl.pattern_Card_0_1_blackB(this);
		if (result1_black == null) {
			throw new RuntimeException(
					"Pattern matching in node [initializeTemp] failed." + " Variables: " + "[this] = " + this + ".");
		}
		Object[] result1_green = CardImpl.pattern_Card_0_1_greenFB(this);
		Card temp = (Card) result1_green[0];

		// swapVariables
		Object[] result2_black = CardImpl.pattern_Card_0_2_blackBB(this, temp);
		if (result2_black == null) {
			throw new RuntimeException("Pattern matching in node [swapVariables] failed." + " Variables: " + "[this] = "
					+ this + ", " + "[temp] = " + temp + ".");
		}
		CardImpl.pattern_Card_0_2_greenBB(this, temp);

		return;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void printCard() {
		// [user code injected with eMoflon]

		// TODO: implement this method here but do not remove the injection marker 
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case LearningBoxLanguagePackage.CARD__CARD_CONTAINER:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetCardContainer((Partition) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case LearningBoxLanguagePackage.CARD__CARD_CONTAINER:
			return basicSetCardContainer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case LearningBoxLanguagePackage.CARD__CARD_CONTAINER:
			return eInternalContainer().eInverseRemove(this, LearningBoxLanguagePackage.PARTITION__CARD,
					Partition.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case LearningBoxLanguagePackage.CARD__CARD_CONTAINER:
			return getCardContainer();
		case LearningBoxLanguagePackage.CARD__BACK:
			return getBack();
		case LearningBoxLanguagePackage.CARD__FACE:
			return getFace();
		case LearningBoxLanguagePackage.CARD__PARTITION_HISTORY:
			return getPartitionHistory();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case LearningBoxLanguagePackage.CARD__CARD_CONTAINER:
			setCardContainer((Partition) newValue);
			return;
		case LearningBoxLanguagePackage.CARD__BACK:
			setBack((String) newValue);
			return;
		case LearningBoxLanguagePackage.CARD__FACE:
			setFace((String) newValue);
			return;
		case LearningBoxLanguagePackage.CARD__PARTITION_HISTORY:
			setPartitionHistory((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case LearningBoxLanguagePackage.CARD__CARD_CONTAINER:
			setCardContainer((Partition) null);
			return;
		case LearningBoxLanguagePackage.CARD__BACK:
			setBack(BACK_EDEFAULT);
			return;
		case LearningBoxLanguagePackage.CARD__FACE:
			setFace(FACE_EDEFAULT);
			return;
		case LearningBoxLanguagePackage.CARD__PARTITION_HISTORY:
			setPartitionHistory(PARTITION_HISTORY_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case LearningBoxLanguagePackage.CARD__CARD_CONTAINER:
			return getCardContainer() != null;
		case LearningBoxLanguagePackage.CARD__BACK:
			return BACK_EDEFAULT == null ? back != null : !BACK_EDEFAULT.equals(back);
		case LearningBoxLanguagePackage.CARD__FACE:
			return FACE_EDEFAULT == null ? face != null : !FACE_EDEFAULT.equals(face);
		case LearningBoxLanguagePackage.CARD__PARTITION_HISTORY:
			return PARTITION_HISTORY_EDEFAULT == null ? partitionHistory != null
					: !PARTITION_HISTORY_EDEFAULT.equals(partitionHistory);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case LearningBoxLanguagePackage.CARD___INVERT:
			invert();
			return null;
		case LearningBoxLanguagePackage.CARD___PRINT_CARD:
			printCard();
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (back: ");
		result.append(back);
		result.append(", face: ");
		result.append(face);
		result.append(", partitionHistory: ");
		result.append(partitionHistory);
		result.append(')');
		return result.toString();
	}

	public static final Object[] pattern_Card_0_1_blackB(Card _this) {
		return new Object[] { _this };
	}

	public static final Object[] pattern_Card_0_1_greenFB(Card _this) {
		Card temp = LearningBoxLanguageFactory.eINSTANCE.createCard();
		String thisface = _this.getFace();
		String temp_back_prime = thisface;
		temp.setBack(temp_back_prime);
		String thisback = _this.getBack();
		String temp_face_prime = thisback;
		temp.setFace(temp_face_prime);
		return new Object[] { temp, _this };

	}

	public static final Object[] pattern_Card_0_2_blackBB(Card _this, Card temp) {
		if (!temp.equals(_this)) {
			return new Object[] { _this, temp };
		}
		return null;
	}

	public static final Object[] pattern_Card_0_2_greenBB(Card _this, Card temp) {
		String tempback = temp.getBack();
		String this_back_prime = tempback;
		_this.setBack(this_back_prime);
		String tempface = temp.getFace();
		String this_face_prime = tempface;
		_this.setFace(this_face_prime);
		return new Object[] { _this, temp };

	}

	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} //CardImpl
