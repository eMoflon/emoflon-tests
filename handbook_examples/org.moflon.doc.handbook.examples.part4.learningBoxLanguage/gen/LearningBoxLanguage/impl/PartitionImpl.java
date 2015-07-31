/**
 */
package LearningBoxLanguage.impl;

import LearningBoxLanguage.Box;
import LearningBoxLanguage.Card;
import LearningBoxLanguage.FastCard;
import LearningBoxLanguage.LearningBoxLanguagePackage;
import LearningBoxLanguage.Partition;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link LearningBoxLanguage.impl.PartitionImpl#getCard <em>Card</em>}</li>
 *   <li>{@link LearningBoxLanguage.impl.PartitionImpl#getBox <em>Box</em>}</li>
 *   <li>{@link LearningBoxLanguage.impl.PartitionImpl#getPrevious <em>Previous</em>}</li>
 *   <li>{@link LearningBoxLanguage.impl.PartitionImpl#getNext <em>Next</em>}</li>
 *   <li>{@link LearningBoxLanguage.impl.PartitionImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link LearningBoxLanguage.impl.PartitionImpl#getPartitionSize <em>Partition Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartitionImpl extends EObjectImpl implements Partition {
	/**
	 * The cached value of the '{@link #getCard() <em>Card</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCard()
	 * @generated
	 * @ordered
	 */
	protected EList<Card> card;

	/**
	 * The cached value of the '{@link #getPrevious() <em>Previous</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrevious()
	 * @generated
	 * @ordered
	 */
	protected Partition previous;

	/**
	 * The cached value of the '{@link #getNext() <em>Next</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNext()
	 * @generated
	 * @ordered
	 */
	protected Partition next;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartitionSize() <em>Partition Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionSize()
	 * @generated
	 * @ordered
	 */
	protected static final int PARTITION_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPartitionSize() <em>Partition Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionSize()
	 * @generated
	 * @ordered
	 */
	protected int partitionSize = PARTITION_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LearningBoxLanguagePackage.Literals.PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Card> getCard() {
		if (card == null) {
			card = new EObjectContainmentWithInverseEList<Card>(Card.class, this,
					LearningBoxLanguagePackage.PARTITION__CARD, LearningBoxLanguagePackage.CARD__CARD_CONTAINER);
		}
		return card;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Box getBox() {
		if (eContainerFeatureID() != LearningBoxLanguagePackage.PARTITION__BOX)
			return null;
		return (Box) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBox(Box newBox, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newBox, LearningBoxLanguagePackage.PARTITION__BOX, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBox(Box newBox) {
		if (newBox != eInternalContainer()
				|| (eContainerFeatureID() != LearningBoxLanguagePackage.PARTITION__BOX && newBox != null)) {
			if (EcoreUtil.isAncestor(this, newBox))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBox != null)
				msgs = ((InternalEObject) newBox).eInverseAdd(this, LearningBoxLanguagePackage.BOX__CONTAINED_PARTITION,
						Box.class, msgs);
			msgs = basicSetBox(newBox, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LearningBoxLanguagePackage.PARTITION__BOX, newBox,
					newBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partition getPrevious() {
		if (previous != null && previous.eIsProxy()) {
			InternalEObject oldPrevious = (InternalEObject) previous;
			previous = (Partition) eResolveProxy(oldPrevious);
			if (previous != oldPrevious) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							LearningBoxLanguagePackage.PARTITION__PREVIOUS, oldPrevious, previous));
			}
		}
		return previous;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partition basicGetPrevious() {
		return previous;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrevious(Partition newPrevious) {
		Partition oldPrevious = previous;
		previous = newPrevious;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LearningBoxLanguagePackage.PARTITION__PREVIOUS,
					oldPrevious, previous));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partition getNext() {
		if (next != null && next.eIsProxy()) {
			InternalEObject oldNext = (InternalEObject) next;
			next = (Partition) eResolveProxy(oldNext);
			if (next != oldNext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							LearningBoxLanguagePackage.PARTITION__NEXT, oldNext, next));
			}
		}
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partition basicGetNext() {
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNext(Partition newNext) {
		Partition oldNext = next;
		next = newNext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LearningBoxLanguagePackage.PARTITION__NEXT, oldNext,
					next));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LearningBoxLanguagePackage.PARTITION__INDEX, oldIndex,
					index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPartitionSize() {
		return partitionSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartitionSize(int newPartitionSize) {
		int oldPartitionSize = partitionSize;
		partitionSize = newPartitionSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LearningBoxLanguagePackage.PARTITION__PARTITION_SIZE,
					oldPartitionSize, partitionSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean check(Card card, String guess) {// checkCard
		Object[] result1_black = PartitionImpl.pattern_Partition_0_1_blackB(card);
		if (result1_black != null) {
			// isFastCard
			Object[] result2_bindingAndBlack = PartitionImpl.pattern_Partition_0_2_bindingAndBlackFB(card);
			if (result2_bindingAndBlack != null) {
				FastCard fastcard = (FastCard) result2_bindingAndBlack[0];

				// promoteFastCard
				Object[] result3_black = PartitionImpl.pattern_Partition_0_3_blackBBFF(fastcard, this);
				if (result3_black == null) {
					throw new RuntimeException("Pattern matching in node [promoteFastCard] failed." + " Variables: "
							+ "[fastcard] = " + fastcard + ", " + "[this] = " + this + ".");
				}
				Partition lastPartition = (Partition) result3_black[2];
				// Box box = (Box) result3_black[3];
				PartitionImpl.pattern_Partition_0_3_redBB(fastcard, this);

				PartitionImpl.pattern_Partition_0_3_greenBB(fastcard, lastPartition);

				return PartitionImpl.pattern_Partition_0_4_expressionF();
			} else {

				// promoteCard
				Object[] result5_black = PartitionImpl.pattern_Partition_0_5_blackBBF(card, this);
				if (result5_black == null) {
					throw new RuntimeException("Pattern matching in node [promoteCard] failed." + " Variables: "
							+ "[card] = " + card + ", " + "[this] = " + this + ".");
				}
				Partition nextPartition = (Partition) result5_black[2];
				PartitionImpl.pattern_Partition_0_5_redBB(card, this);

				PartitionImpl.pattern_Partition_0_5_greenBB(card, nextPartition);

				return PartitionImpl.pattern_Partition_0_6_expressionF();
			}

		} else {

			// penalizeCard
			Object[] result7_black = PartitionImpl.pattern_Partition_0_7_blackBBF(card, this);
			if (result7_black == null) {
				throw new RuntimeException("Pattern matching in node [penalizeCard] failed." + " Variables: "
						+ "[card] = " + card + ", " + "[this] = " + this + ".");
			}
			Partition previousPartition = (Partition) result7_black[2];
			PartitionImpl.pattern_Partition_0_7_redBB(card, this);

			PartitionImpl.pattern_Partition_0_7_greenBB(card, previousPartition);

			return PartitionImpl.pattern_Partition_0_8_expressionF();
		}

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void empty() {// ForEach deleteCardsInPartition
		for (Object[] result1_black : PartitionImpl.pattern_Partition_1_1_blackBF(this)) {
			Card card = (Card) result1_black[1];
			PartitionImpl.pattern_Partition_1_1_redBB(this, card);

			EcoreUtil.delete(card);
			card = null;
			;

		}
		return;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Card removeCard(Card card) {
		// removeCardFromPartition
		Object[] result1_black = PartitionImpl.pattern_Partition_2_1_blackBB(this, card);
		if (result1_black == null) {
			throw new RuntimeException("Pattern matching in node [removeCardFromPartition] failed." + " Variables: "
					+ "[this] = " + this + ", " + "[card] = " + card + ".");
		}
		PartitionImpl.pattern_Partition_2_1_redBB(this, card);

		return PartitionImpl.pattern_Partition_2_2_expressionFB(card);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case LearningBoxLanguagePackage.PARTITION__CARD:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getCard()).basicAdd(otherEnd, msgs);
		case LearningBoxLanguagePackage.PARTITION__BOX:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetBox((Box) otherEnd, msgs);
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
		case LearningBoxLanguagePackage.PARTITION__CARD:
			return ((InternalEList<?>) getCard()).basicRemove(otherEnd, msgs);
		case LearningBoxLanguagePackage.PARTITION__BOX:
			return basicSetBox(null, msgs);
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
		case LearningBoxLanguagePackage.PARTITION__BOX:
			return eInternalContainer().eInverseRemove(this, LearningBoxLanguagePackage.BOX__CONTAINED_PARTITION,
					Box.class, msgs);
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
		case LearningBoxLanguagePackage.PARTITION__CARD:
			return getCard();
		case LearningBoxLanguagePackage.PARTITION__BOX:
			return getBox();
		case LearningBoxLanguagePackage.PARTITION__PREVIOUS:
			if (resolve)
				return getPrevious();
			return basicGetPrevious();
		case LearningBoxLanguagePackage.PARTITION__NEXT:
			if (resolve)
				return getNext();
			return basicGetNext();
		case LearningBoxLanguagePackage.PARTITION__INDEX:
			return getIndex();
		case LearningBoxLanguagePackage.PARTITION__PARTITION_SIZE:
			return getPartitionSize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case LearningBoxLanguagePackage.PARTITION__CARD:
			getCard().clear();
			getCard().addAll((Collection<? extends Card>) newValue);
			return;
		case LearningBoxLanguagePackage.PARTITION__BOX:
			setBox((Box) newValue);
			return;
		case LearningBoxLanguagePackage.PARTITION__PREVIOUS:
			setPrevious((Partition) newValue);
			return;
		case LearningBoxLanguagePackage.PARTITION__NEXT:
			setNext((Partition) newValue);
			return;
		case LearningBoxLanguagePackage.PARTITION__INDEX:
			setIndex((Integer) newValue);
			return;
		case LearningBoxLanguagePackage.PARTITION__PARTITION_SIZE:
			setPartitionSize((Integer) newValue);
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
		case LearningBoxLanguagePackage.PARTITION__CARD:
			getCard().clear();
			return;
		case LearningBoxLanguagePackage.PARTITION__BOX:
			setBox((Box) null);
			return;
		case LearningBoxLanguagePackage.PARTITION__PREVIOUS:
			setPrevious((Partition) null);
			return;
		case LearningBoxLanguagePackage.PARTITION__NEXT:
			setNext((Partition) null);
			return;
		case LearningBoxLanguagePackage.PARTITION__INDEX:
			setIndex(INDEX_EDEFAULT);
			return;
		case LearningBoxLanguagePackage.PARTITION__PARTITION_SIZE:
			setPartitionSize(PARTITION_SIZE_EDEFAULT);
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
		case LearningBoxLanguagePackage.PARTITION__CARD:
			return card != null && !card.isEmpty();
		case LearningBoxLanguagePackage.PARTITION__BOX:
			return getBox() != null;
		case LearningBoxLanguagePackage.PARTITION__PREVIOUS:
			return previous != null;
		case LearningBoxLanguagePackage.PARTITION__NEXT:
			return next != null;
		case LearningBoxLanguagePackage.PARTITION__INDEX:
			return index != INDEX_EDEFAULT;
		case LearningBoxLanguagePackage.PARTITION__PARTITION_SIZE:
			return partitionSize != PARTITION_SIZE_EDEFAULT;
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
		case LearningBoxLanguagePackage.PARTITION___CHECK__CARD_STRING:
			return check((Card) arguments.get(0), (String) arguments.get(1));
		case LearningBoxLanguagePackage.PARTITION___EMPTY:
			empty();
			return null;
		case LearningBoxLanguagePackage.PARTITION___REMOVE_CARD__CARD:
			return removeCard((Card) arguments.get(0));
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
		result.append(" (index: ");
		result.append(index);
		result.append(", partitionSize: ");
		result.append(partitionSize);
		result.append(')');
		return result.toString();
	}

	public static final Object[] pattern_Partition_0_1_blackB(Card card) {
		String cardface = card.getFace();
		if (cardface.equals(card)) {
			return new Object[] { card };
		}

		return null;
	}

	public static final Object[] pattern_Partition_0_2_bindingFB(Card card) {
		Card tmpFastcard = card;
		if (tmpFastcard instanceof FastCard) {
			FastCard fastcard = (FastCard) tmpFastcard;
			return new Object[] { fastcard, card };
		}
		return null;
	}

	public static final Object[] pattern_Partition_0_2_blackB(FastCard fastcard) {
		return new Object[] { fastcard };
	}

	public static final Object[] pattern_Partition_0_2_bindingAndBlackFB(Card card) {
		Object[] result_pattern_Partition_0_2_binding = pattern_Partition_0_2_bindingFB(card);
		if (result_pattern_Partition_0_2_binding != null) {
			FastCard fastcard = (FastCard) result_pattern_Partition_0_2_binding[0];

			Object[] result_pattern_Partition_0_2_black = pattern_Partition_0_2_blackB(fastcard);
			if (result_pattern_Partition_0_2_black != null) {

				return new Object[] { fastcard, card };
			}
		}
		return null;
	}

	public static final Object[] pattern_Partition_0_3_black_nac_0BB(Partition lastPartition, Partition _this) {
		if (!lastPartition.equals(_this)) {
			Partition next = lastPartition.getNext();
			if (next != null) {
				if (!lastPartition.equals(next)) {
					if (!_this.equals(next)) {
						return new Object[] { lastPartition, _this };
					}
				}
			}

		}
		return null;
	}

	public static final Object[] pattern_Partition_0_3_blackBBFF(FastCard fastcard, Partition _this) {
		if (_this.getCard().contains(fastcard)) {
			Box box = _this.getBox();
			if (box != null) {
				for (Partition lastPartition : box.getContainedPartition()) {
					if (!lastPartition.equals(_this)) {
						if (pattern_Partition_0_3_black_nac_0BB(lastPartition, _this) == null) {
							return new Object[] { fastcard, _this, lastPartition, box };
						}
					}
				}
			}

		}
		return null;
	}

	public static final Object[] pattern_Partition_0_3_redBB(FastCard fastcard, Partition _this) {
		_this.getCard().remove(fastcard);
		return new Object[] { fastcard, _this };
	}

	public static final Object[] pattern_Partition_0_3_greenBB(FastCard fastcard, Partition lastPartition) {
		lastPartition.getCard().add(fastcard);
		return new Object[] { fastcard, lastPartition };
	}

	public static final boolean pattern_Partition_0_4_expressionF() {
		boolean _result = Boolean.valueOf(true);
		return _result;
	}

	public static final Object[] pattern_Partition_0_5_blackBBF(Card card, Partition _this) {
		if (_this.getCard().contains(card)) {
			Partition nextPartition = _this.getNext();
			if (nextPartition != null) {
				if (!nextPartition.equals(_this)) {
					return new Object[] { card, _this, nextPartition };
				}
			}

		}
		return null;
	}

	public static final Object[] pattern_Partition_0_5_redBB(Card card, Partition _this) {
		_this.getCard().remove(card);
		return new Object[] { card, _this };
	}

	public static final Object[] pattern_Partition_0_5_greenBB(Card card, Partition nextPartition) {
		nextPartition.getCard().add(card);
		return new Object[] { card, nextPartition };
	}

	public static final boolean pattern_Partition_0_6_expressionF() {
		boolean _result = Boolean.valueOf(true);
		return _result;
	}

	public static final Object[] pattern_Partition_0_7_blackBBF(Card card, Partition _this) {
		if (_this.getCard().contains(card)) {
			Partition previousPartition = _this.getPrevious();
			if (previousPartition != null) {
				if (!previousPartition.equals(_this)) {
					return new Object[] { card, _this, previousPartition };
				}
			}

		}
		return null;
	}

	public static final Object[] pattern_Partition_0_7_redBB(Card card, Partition _this) {
		_this.getCard().remove(card);
		return new Object[] { card, _this };
	}

	public static final Object[] pattern_Partition_0_7_greenBB(Card card, Partition previousPartition) {
		previousPartition.getCard().add(card);
		return new Object[] { card, previousPartition };
	}

	public static final boolean pattern_Partition_0_8_expressionF() {
		boolean _result = false;
		return _result;
	}

	public static final Iterable<Object[]> pattern_Partition_1_1_blackBF(Partition _this) {
		LinkedList<Object[]> _result = new LinkedList<Object[]>();
		for (Card card : _this.getCard()) {
			_result.add(new Object[] { _this, card });
		}
		return _result;
	}

	public static final Object[] pattern_Partition_1_1_redBB(Partition _this, Card card) {
		_this.getCard().remove(card);
		return new Object[] { _this, card };
	}

	public static final Object[] pattern_Partition_2_1_blackBB(Partition _this, Card card) {
		if (_this.getCard().contains(card)) {
			return new Object[] { _this, card };
		}
		return null;
	}

	public static final Object[] pattern_Partition_2_1_redBB(Partition _this, Card card) {
		_this.getCard().remove(card);
		return new Object[] { _this, card };
	}

	public static final Card pattern_Partition_2_2_expressionFB(Card card) {
		Card _result = card;
		return _result;
	}

	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} //PartitionImpl
