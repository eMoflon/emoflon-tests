/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ProcessDefinition.facade.impl;

import ProcessDefinition.SystemModule;
import ProcessDefinition.Task;
import ProcessDefinition.facade.FacadePackage;
import ProcessDefinition.facade.Helper;

import de.upb.tools.fca.*;
import java.lang.reflect.InvocationTargetException;

import java.util.*;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Helper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ProcessDefinition.facade.impl.HelperImpl#getSystemModule <em>System Module</em>}</li>
 *   <li>{@link ProcessDefinition.facade.impl.HelperImpl#getTasks <em>Tasks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HelperImpl extends EObjectImpl implements Helper {
	/**
	 * The cached value of the '{@link #getSystemModule() <em>System Module</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemModule()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemModule> systemModule;
	/**
	 * The cached value of the '{@link #getTasks() <em>Tasks</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> tasks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HelperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FacadePackage.Literals.HELPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemModule> getSystemModule() {
		if (systemModule == null) {
			systemModule = new EObjectResolvingEList<SystemModule>(
					SystemModule.class, this,
					FacadePackage.HELPER__SYSTEM_MODULE);
		}
		return systemModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getTasks() {
		if (tasks == null) {
			tasks = new EObjectResolvingEList<Task>(Task.class, this,
					FacadePackage.HELPER__TASKS);
		}
		return tasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outputCycle(Task currentTask) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void print(String message) {
		System.out.println(message);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FacadePackage.HELPER__SYSTEM_MODULE:
			return getSystemModule();
		case FacadePackage.HELPER__TASKS:
			return getTasks();
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
		case FacadePackage.HELPER__SYSTEM_MODULE:
			getSystemModule().clear();
			getSystemModule().addAll(
					(Collection<? extends SystemModule>) newValue);
			return;
		case FacadePackage.HELPER__TASKS:
			getTasks().clear();
			getTasks().addAll((Collection<? extends Task>) newValue);
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
		case FacadePackage.HELPER__SYSTEM_MODULE:
			getSystemModule().clear();
			return;
		case FacadePackage.HELPER__TASKS:
			getTasks().clear();
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
		case FacadePackage.HELPER__SYSTEM_MODULE:
			return systemModule != null && !systemModule.isEmpty();
		case FacadePackage.HELPER__TASKS:
			return tasks != null && !tasks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
		case FacadePackage.HELPER___OUTPUT_CYCLE__TASK:
			outputCycle((Task) arguments.get(0));
			return null;
		case FacadePackage.HELPER___PRINT__STRING:
			print((String) arguments.get(0));
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //HelperImpl
