/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.ordre.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.example.ordre.OrdrePackage;
import org.example.ordre.ReponsePossibleType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reponse Possible Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.ordre.impl.ReponsePossibleTypeImpl#getReponse <em>Reponse</em>}</li>
 *   <li>{@link org.example.ordre.impl.ReponsePossibleTypeImpl#getOrdreSuivant <em>Ordre Suivant</em>}</li>
 *   <li>{@link org.example.ordre.impl.ReponsePossibleTypeImpl#getIdReponse <em>Id Reponse</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReponsePossibleTypeImpl extends EObjectImpl implements ReponsePossibleType {
	/**
	 * The default value of the '{@link #getReponse() <em>Reponse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReponse()
	 * @generated
	 * @ordered
	 */
	protected static final String REPONSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReponse() <em>Reponse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReponse()
	 * @generated
	 * @ordered
	 */
	protected String reponse = REPONSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrdreSuivant() <em>Ordre Suivant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrdreSuivant()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDRE_SUIVANT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrdreSuivant() <em>Ordre Suivant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrdreSuivant()
	 * @generated
	 * @ordered
	 */
	protected int ordreSuivant = ORDRE_SUIVANT_EDEFAULT;

	/**
	 * This is true if the Ordre Suivant attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean ordreSuivantESet;

	/**
	 * The default value of the '{@link #getIdReponse() <em>Id Reponse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdReponse()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_REPONSE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdReponse() <em>Id Reponse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdReponse()
	 * @generated
	 * @ordered
	 */
	protected int idReponse = ID_REPONSE_EDEFAULT;

	/**
	 * This is true if the Id Reponse attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean idReponseESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReponsePossibleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrdrePackage.Literals.REPONSE_POSSIBLE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReponse() {
		return reponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReponse(String newReponse) {
		String oldReponse = reponse;
		reponse = newReponse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.REPONSE_POSSIBLE_TYPE__REPONSE, oldReponse, reponse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrdreSuivant() {
		return ordreSuivant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrdreSuivant(int newOrdreSuivant) {
		int oldOrdreSuivant = ordreSuivant;
		ordreSuivant = newOrdreSuivant;
		boolean oldOrdreSuivantESet = ordreSuivantESet;
		ordreSuivantESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.REPONSE_POSSIBLE_TYPE__ORDRE_SUIVANT, oldOrdreSuivant, ordreSuivant, !oldOrdreSuivantESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOrdreSuivant() {
		int oldOrdreSuivant = ordreSuivant;
		boolean oldOrdreSuivantESet = ordreSuivantESet;
		ordreSuivant = ORDRE_SUIVANT_EDEFAULT;
		ordreSuivantESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OrdrePackage.REPONSE_POSSIBLE_TYPE__ORDRE_SUIVANT, oldOrdreSuivant, ORDRE_SUIVANT_EDEFAULT, oldOrdreSuivantESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOrdreSuivant() {
		return ordreSuivantESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIdReponse() {
		return idReponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdReponse(int newIdReponse) {
		int oldIdReponse = idReponse;
		idReponse = newIdReponse;
		boolean oldIdReponseESet = idReponseESet;
		idReponseESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.REPONSE_POSSIBLE_TYPE__ID_REPONSE, oldIdReponse, idReponse, !oldIdReponseESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIdReponse() {
		int oldIdReponse = idReponse;
		boolean oldIdReponseESet = idReponseESet;
		idReponse = ID_REPONSE_EDEFAULT;
		idReponseESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OrdrePackage.REPONSE_POSSIBLE_TYPE__ID_REPONSE, oldIdReponse, ID_REPONSE_EDEFAULT, oldIdReponseESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIdReponse() {
		return idReponseESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__REPONSE:
				return getReponse();
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__ORDRE_SUIVANT:
				return getOrdreSuivant();
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__ID_REPONSE:
				return getIdReponse();
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
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__REPONSE:
				setReponse((String)newValue);
				return;
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__ORDRE_SUIVANT:
				setOrdreSuivant((Integer)newValue);
				return;
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__ID_REPONSE:
				setIdReponse((Integer)newValue);
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
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__REPONSE:
				setReponse(REPONSE_EDEFAULT);
				return;
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__ORDRE_SUIVANT:
				unsetOrdreSuivant();
				return;
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__ID_REPONSE:
				unsetIdReponse();
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
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__REPONSE:
				return REPONSE_EDEFAULT == null ? reponse != null : !REPONSE_EDEFAULT.equals(reponse);
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__ORDRE_SUIVANT:
				return isSetOrdreSuivant();
			case OrdrePackage.REPONSE_POSSIBLE_TYPE__ID_REPONSE:
				return isSetIdReponse();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (reponse: ");
		result.append(reponse);
		result.append(", ordreSuivant: ");
		if (ordreSuivantESet) result.append(ordreSuivant); else result.append("<unset>");
		result.append(", idReponse: ");
		if (idReponseESet) result.append(idReponse); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ReponsePossibleTypeImpl
