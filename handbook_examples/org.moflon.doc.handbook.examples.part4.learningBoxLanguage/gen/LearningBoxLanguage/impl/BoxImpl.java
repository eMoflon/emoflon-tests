/**
 */
package LearningBoxLanguage.impl;

import LearningBoxLanguage.Box;
import LearningBoxLanguage.Card;
import LearningBoxLanguage.LearningBoxLanguageFactory;
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
import org.eclipse.emf.ecore.util.InternalEList;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link LearningBoxLanguage.impl.BoxImpl#getContainedPartition <em>Contained Partition</em>}</li>
 *   <li>{@link LearningBoxLanguage.impl.BoxImpl#getName <em>Name</em>}</li>
 *   <li>{@link LearningBoxLanguage.impl.BoxImpl#getStringRep <em>String Rep</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoxImpl extends EObjectImpl implements Box {
	/**
	 * The cached value of the '{@link #getContainedPartition() <em>Contained Partition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedPartition()
	 * @generated
	 * @ordered
	 */
	protected EList<Partition> containedPartition;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStringRep() <em>String Rep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringRep()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_REP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStringRep() <em>String Rep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringRep()
	 * @generated
	 * @ordered
	 */
	protected String stringRep = STRING_REP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LearningBoxLanguagePackage.Literals.BOX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Partition> getContainedPartition() {
		if (containedPartition == null) {
			containedPartition = new EObjectContainmentWithInverseEList<Partition>(Partition.class, this,
					LearningBoxLanguagePackage.BOX__CONTAINED_PARTITION, LearningBoxLanguagePackage.PARTITION__BOX);
		}
		return containedPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LearningBoxLanguagePackage.BOX__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStringRep() {
		return stringRep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringRep(String newStringRep) {
		String oldStringRep = stringRep;
		stringRep = newStringRep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LearningBoxLanguagePackage.BOX__STRING_REP,
					oldStringRep, stringRep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addToStringRep(Card card) {
		// [user code injected with eMoflon]

		// TODO: implement this method here but do not remove the injection marker 
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int determineNextSize() {
		// [user code injected with eMoflon]

		// TODO: implement this method here but do not remove the injection marker 
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean grow() {// addNewPartitionBox
		Object[] result1_black = BoxImpl.pattern_Box_2_1_blackBFF(this);
		if (result1_black != null) {
			Partition firstPartitionInBox = (Partition) result1_black[1];
			Partition lastPartitionInBox = (Partition) result1_black[2];
			BoxImpl.pattern_Box_2_1_greenBBBF(this, firstPartitionInBox, lastPartitionInBox);
			// Partition newPartition = (Partition) result1_green[3];

			return BoxImpl.pattern_Box_2_2_expressionF();
		} else {
			// initialize
			if (BoxImpl.pattern_Box_2_3_expressionFB(this)) {
				return BoxImpl.pattern_Box_2_4_expressionF();
			} else {
				return BoxImpl.pattern_Box_2_5_expressionF();
			}

		}

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {// ForEach ForAllPartitions
		for (Object[] result1_black : BoxImpl.pattern_Box_3_1_blackBF(this)) {
			Partition partition = (Partition) result1_black[1];
			// ForEach ForAllCards
			for (Object[] result2_black : BoxImpl.pattern_Box_3_2_blackBF(partition)) {
				Card card = (Card) result2_black[1];
				// addToStringRep
				BoxImpl.pattern_Box_3_3_expressionBB(this, card);

			}

		}
		return BoxImpl.pattern_Box_3_4_expressionFB(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean initializeBox() {// buildPartitions
		Object[] result1_black = BoxImpl.pattern_Box_4_1_blackB(this);
		if (result1_black != null) {
			BoxImpl.pattern_Box_4_1_greenBFF(this);
			// Partition firstPartition = (Partition) result1_green[1];
			// Partition lastPartition = (Partition) result1_green[2];

			return BoxImpl.pattern_Box_4_2_expressionF();
		} else {
			return BoxImpl.pattern_Box_4_3_expressionF();
		}

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
		case LearningBoxLanguagePackage.BOX__CONTAINED_PARTITION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getContainedPartition()).basicAdd(otherEnd,
					msgs);
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
		case LearningBoxLanguagePackage.BOX__CONTAINED_PARTITION:
			return ((InternalEList<?>) getContainedPartition()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case LearningBoxLanguagePackage.BOX__CONTAINED_PARTITION:
			return getContainedPartition();
		case LearningBoxLanguagePackage.BOX__NAME:
			return getName();
		case LearningBoxLanguagePackage.BOX__STRING_REP:
			return getStringRep();
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
		case LearningBoxLanguagePackage.BOX__CONTAINED_PARTITION:
			getContainedPartition().clear();
			getContainedPartition().addAll((Collection<? extends Partition>) newValue);
			return;
		case LearningBoxLanguagePackage.BOX__NAME:
			setName((String) newValue);
			return;
		case LearningBoxLanguagePackage.BOX__STRING_REP:
			setStringRep((String) newValue);
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
		case LearningBoxLanguagePackage.BOX__CONTAINED_PARTITION:
			getContainedPartition().clear();
			return;
		case LearningBoxLanguagePackage.BOX__NAME:
			setName(NAME_EDEFAULT);
			return;
		case LearningBoxLanguagePackage.BOX__STRING_REP:
			setStringRep(STRING_REP_EDEFAULT);
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
		case LearningBoxLanguagePackage.BOX__CONTAINED_PARTITION:
			return containedPartition != null && !containedPartition.isEmpty();
		case LearningBoxLanguagePackage.BOX__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case LearningBoxLanguagePackage.BOX__STRING_REP:
			return STRING_REP_EDEFAULT == null ? stringRep != null : !STRING_REP_EDEFAULT.equals(stringRep);
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
		case LearningBoxLanguagePackage.BOX___ADD_TO_STRING_REP__CARD:
			addToStringRep((Card) arguments.get(0));
			return null;
		case LearningBoxLanguagePackage.BOX___DETERMINE_NEXT_SIZE:
			return determineNextSize();
		case LearningBoxLanguagePackage.BOX___GROW:
			return grow();
		case LearningBoxLanguagePackage.BOX___TO_STRING:
			return toString();
		case LearningBoxLanguagePackage.BOX___INITIALIZE_BOX:
			return initializeBox();
		}
		return super.eInvoke(operationID, arguments);
	}

	public static final Object[] pattern_Box_2_1_black_nac_0BB(Partition lastPartitionInBox,
			Partition firstPartitionInBox) {
		if (!firstPartitionInBox.equals(lastPartitionInBox)) {
			Partition nextPartition = lastPartitionInBox.getNext();
			if (nextPartition != null) {
				if (!lastPartitionInBox.equals(nextPartition)) {
					if (!firstPartitionInBox.equals(nextPartition)) {
						return new Object[] { lastPartitionInBox, firstPartitionInBox };
					}
				}
			}

		}
		return null;
	}

	public static final Object[] pattern_Box_2_1_black_nac_1BB(Partition firstPartitionInBox,
			Partition lastPartitionInBox) {
		if (!firstPartitionInBox.equals(lastPartitionInBox)) {
			Partition previousPartition = firstPartitionInBox.getPrevious();
			if (previousPartition != null) {
				if (!firstPartitionInBox.equals(previousPartition)) {
					if (!lastPartitionInBox.equals(previousPartition)) {
						return new Object[] { firstPartitionInBox, lastPartitionInBox };
					}
				}
			}

		}
		return null;
	}

	public static final Object[] pattern_Box_2_1_blackBFF(Box _this) {
		for (Partition firstPartitionInBox : _this.getContainedPartition()) {
			for (Partition lastPartitionInBox : _this.getContainedPartition()) {
				if (!firstPartitionInBox.equals(lastPartitionInBox)) {
					if (pattern_Box_2_1_black_nac_0BB(lastPartitionInBox, firstPartitionInBox) == null) {
						if (pattern_Box_2_1_black_nac_1BB(firstPartitionInBox, lastPartitionInBox) == null) {
							return new Object[] { _this, firstPartitionInBox, lastPartitionInBox };
						}
					}
				}
			}
		}
		return null;
	}

	public static final Object[] pattern_Box_2_1_greenBBBF(Box _this, Partition firstPartitionInBox,
			Partition lastPartitionInBox) {
		Partition newPartition = LearningBoxLanguageFactory.eINSTANCE.createPartition();
		int _localVariable_0 = _this.determineNextSize();
		lastPartitionInBox.setNext(newPartition);
		newPartition.setPrevious(firstPartitionInBox);
		newPartition.setBox(_this);
		int newPartition_partitionSize_prime = Integer.valueOf(_localVariable_0);
		newPartition.setPartitionSize(Integer.valueOf(newPartition_partitionSize_prime));
		return new Object[] { _this, firstPartitionInBox, lastPartitionInBox, newPartition };
	}

	public static final boolean pattern_Box_2_2_expressionF() {
		boolean _result = Boolean.valueOf(true);
		return _result;
	}

	public static final boolean pattern_Box_2_3_expressionFB(Box _this) {
		boolean _localVariable_0 = _this.initializeBox();
		boolean _result = Boolean.valueOf(_localVariable_0);
		return _result;
	}

	public static final boolean pattern_Box_2_4_expressionF() {
		boolean _result = Boolean.valueOf(true);
		return _result;
	}

	public static final boolean pattern_Box_2_5_expressionF() {
		boolean _result = false;
		return _result;
	}

	public static final Iterable<Object[]> pattern_Box_3_1_blackBF(Box _this) {
		LinkedList<Object[]> _result = new LinkedList<Object[]>();
		for (Partition partition : _this.getContainedPartition()) {
			_result.add(new Object[] { _this, partition });
		}
		return _result;
	}

	public static final Iterable<Object[]> pattern_Box_3_2_blackBF(Partition partition) {
		LinkedList<Object[]> _result = new LinkedList<Object[]>();
		for (Card card : partition.getCard()) {
			_result.add(new Object[] { partition, card });
		}
		return _result;
	}

	public static final void pattern_Box_3_3_expressionBB(Box _this, Card card) {
		_this.addToStringRep(card);

	}

	public static final String pattern_Box_3_4_expressionFB(Box _this) {
		String thisstringRep = _this.getStringRep();
		String _result = thisstringRep;
		return _result;

	}

	public static final Object[] pattern_Box_4_1_black_nac_0B(Box _this) {
		for (Partition onePartition : _this.getContainedPartition()) {
			return new Object[] { _this };
		}
		return null;
	}

	public static final Object[] pattern_Box_4_1_blackB(Box _this) {
		if (pattern_Box_4_1_black_nac_0B(_this) == null) {
			return new Object[] { _this };
		}
		return null;
	}

	public static final Object[] pattern_Box_4_1_greenBFF(Box _this) {
		Partition firstPartition = LearningBoxLanguageFactory.eINSTANCE.createPartition();
		Partition lastPartition = LearningBoxLanguageFactory.eINSTANCE.createPartition();
		firstPartition.setBox(_this);
		firstPartition.setNext(lastPartition);
		lastPartition.setBox(_this);
		lastPartition.setPrevious(firstPartition);
		return new Object[] { _this, firstPartition, lastPartition };
	}

	public static final boolean pattern_Box_4_2_expressionF() {
		boolean _result = Boolean.valueOf(true);
		return _result;
	}

	public static final boolean pattern_Box_4_3_expressionF() {
		boolean _result = false;
		return _result;
	}

	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} //BoxImpl
