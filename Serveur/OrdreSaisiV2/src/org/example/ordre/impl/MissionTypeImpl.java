/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.ordre.impl;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.example.ordre.EtatType1;
import org.example.ordre.MissionType;
import org.example.ordre.OrdrePackage;
import org.example.ordre.OrdreType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mission Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.ordre.impl.MissionTypeImpl#getEtat <em>Etat</em>}</li>
 *   <li>{@link org.example.ordre.impl.MissionTypeImpl#getIdOrdreCoutant <em>Id Ordre Coutant</em>}</li>
 *   <li>{@link org.example.ordre.impl.MissionTypeImpl#getDestinataire <em>Destinataire</em>}</li>
 *   <li>{@link org.example.ordre.impl.MissionTypeImpl#isPublie <em>Publie</em>}</li>
 *   <li>{@link org.example.ordre.impl.MissionTypeImpl#getOrdre <em>Ordre</em>}</li>
 *   <li>{@link org.example.ordre.impl.MissionTypeImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.example.ordre.impl.MissionTypeImpl#getIdMission <em>Id Mission</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MissionTypeImpl extends EObjectImpl implements MissionType {
	/**
	 * The default value of the '{@link #getEtat() <em>Etat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtat()
	 * @generated
	 * @ordered
	 */
	protected static final EtatType1 ETAT_EDEFAULT = EtatType1.EN_COURS;

	/**
	 * The cached value of the '{@link #getEtat() <em>Etat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtat()
	 * @generated
	 * @ordered
	 */
	protected EtatType1 etat = ETAT_EDEFAULT;

	/**
	 * This is true if the Etat attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean etatESet;

	/**
	 * The default value of the '{@link #getIdOrdreCoutant() <em>Id Ordre Coutant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdOrdreCoutant()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_ORDRE_COUTANT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdOrdreCoutant() <em>Id Ordre Coutant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdOrdreCoutant()
	 * @generated
	 * @ordered
	 */
	protected int idOrdreCoutant = ID_ORDRE_COUTANT_EDEFAULT;

	/**
	 * This is true if the Id Ordre Coutant attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean idOrdreCoutantESet;

	/**
	 * The default value of the '{@link #getDestinataire() <em>Destinataire</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinataire()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTINATAIRE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestinataire() <em>Destinataire</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinataire()
	 * @generated
	 * @ordered
	 */
	protected String destinataire = DESTINATAIRE_EDEFAULT;

	/**
	 * The default value of the '{@link #isPublie() <em>Publie</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPublie()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PUBLIE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPublie() <em>Publie</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPublie()
	 * @generated
	 * @ordered
	 */
	protected boolean publie = PUBLIE_EDEFAULT;

	/**
	 * This is true if the Publie attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean publieESet;

	/**
	 * The cached value of the '{@link #getOrdre() <em>Ordre</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrdre()
	 * @generated
	 * @ordered
	 */
	protected EList<OrdreType> ordre;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdMission() <em>Id Mission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdMission()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_MISSION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdMission() <em>Id Mission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdMission()
	 * @generated
	 * @ordered
	 */
	protected int idMission = ID_MISSION_EDEFAULT;

	/**
	 * This is true if the Id Mission attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean idMissionESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MissionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrdrePackage.Literals.MISSION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatType1 getEtat() {
		return etat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEtat(EtatType1 newEtat) {
		EtatType1 oldEtat = etat;
		etat = newEtat == null ? ETAT_EDEFAULT : newEtat;
		boolean oldEtatESet = etatESet;
		etatESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.MISSION_TYPE__ETAT, oldEtat, etat, !oldEtatESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEtat() {
		EtatType1 oldEtat = etat;
		boolean oldEtatESet = etatESet;
		etat = ETAT_EDEFAULT;
		etatESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OrdrePackage.MISSION_TYPE__ETAT, oldEtat, ETAT_EDEFAULT, oldEtatESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEtat() {
		return etatESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIdOrdreCoutant() {
		return idOrdreCoutant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdOrdreCoutant(int newIdOrdreCoutant) {
		int oldIdOrdreCoutant = idOrdreCoutant;
		idOrdreCoutant = newIdOrdreCoutant;
		boolean oldIdOrdreCoutantESet = idOrdreCoutantESet;
		idOrdreCoutantESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.MISSION_TYPE__ID_ORDRE_COUTANT, oldIdOrdreCoutant, idOrdreCoutant, !oldIdOrdreCoutantESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIdOrdreCoutant() {
		int oldIdOrdreCoutant = idOrdreCoutant;
		boolean oldIdOrdreCoutantESet = idOrdreCoutantESet;
		idOrdreCoutant = ID_ORDRE_COUTANT_EDEFAULT;
		idOrdreCoutantESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OrdrePackage.MISSION_TYPE__ID_ORDRE_COUTANT, oldIdOrdreCoutant, ID_ORDRE_COUTANT_EDEFAULT, oldIdOrdreCoutantESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIdOrdreCoutant() {
		return idOrdreCoutantESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDestinataire() {
		return destinataire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestinataire(String newDestinataire) {
		String oldDestinataire = destinataire;
		destinataire = newDestinataire;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.MISSION_TYPE__DESTINATAIRE, oldDestinataire, destinataire));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPublie() {
		return publie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublie(boolean newPublie) {
		boolean oldPublie = publie;
		publie = newPublie;
		boolean oldPublieESet = publieESet;
		publieESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.MISSION_TYPE__PUBLIE, oldPublie, publie, !oldPublieESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPublie() {
		boolean oldPublie = publie;
		boolean oldPublieESet = publieESet;
		publie = PUBLIE_EDEFAULT;
		publieESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OrdrePackage.MISSION_TYPE__PUBLIE, oldPublie, PUBLIE_EDEFAULT, oldPublieESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPublie() {
		return publieESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrdreType> getOrdre() {
		if (ordre == null) {
			ordre = new EObjectContainmentEList<OrdreType>(OrdreType.class, this, OrdrePackage.MISSION_TYPE__ORDRE);
		}
		return ordre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(XMLGregorianCalendar newDate) {
		XMLGregorianCalendar oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.MISSION_TYPE__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIdMission() {
		return idMission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdMission(int newIdMission) {
		int oldIdMission = idMission;
		idMission = newIdMission;
		boolean oldIdMissionESet = idMissionESet;
		idMissionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.MISSION_TYPE__ID_MISSION, oldIdMission, idMission, !oldIdMissionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIdMission() {
		int oldIdMission = idMission;
		boolean oldIdMissionESet = idMissionESet;
		idMission = ID_MISSION_EDEFAULT;
		idMissionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OrdrePackage.MISSION_TYPE__ID_MISSION, oldIdMission, ID_MISSION_EDEFAULT, oldIdMissionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIdMission() {
		return idMissionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OrdrePackage.MISSION_TYPE__ORDRE:
				return ((InternalEList<?>)getOrdre()).basicRemove(otherEnd, msgs);
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
			case OrdrePackage.MISSION_TYPE__ETAT:
				return getEtat();
			case OrdrePackage.MISSION_TYPE__ID_ORDRE_COUTANT:
				return getIdOrdreCoutant();
			case OrdrePackage.MISSION_TYPE__DESTINATAIRE:
				return getDestinataire();
			case OrdrePackage.MISSION_TYPE__PUBLIE:
				return isPublie();
			case OrdrePackage.MISSION_TYPE__ORDRE:
				return getOrdre();
			case OrdrePackage.MISSION_TYPE__DATE:
				return getDate();
			case OrdrePackage.MISSION_TYPE__ID_MISSION:
				return getIdMission();
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
			case OrdrePackage.MISSION_TYPE__ETAT:
				setEtat((EtatType1)newValue);
				return;
			case OrdrePackage.MISSION_TYPE__ID_ORDRE_COUTANT:
				setIdOrdreCoutant((Integer)newValue);
				return;
			case OrdrePackage.MISSION_TYPE__DESTINATAIRE:
				setDestinataire((String)newValue);
				return;
			case OrdrePackage.MISSION_TYPE__PUBLIE:
				setPublie((Boolean)newValue);
				return;
			case OrdrePackage.MISSION_TYPE__ORDRE:
				getOrdre().clear();
				getOrdre().addAll((Collection<? extends OrdreType>)newValue);
				return;
			case OrdrePackage.MISSION_TYPE__DATE:
				setDate((XMLGregorianCalendar)newValue);
				return;
			case OrdrePackage.MISSION_TYPE__ID_MISSION:
				setIdMission((Integer)newValue);
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
			case OrdrePackage.MISSION_TYPE__ETAT:
				unsetEtat();
				return;
			case OrdrePackage.MISSION_TYPE__ID_ORDRE_COUTANT:
				unsetIdOrdreCoutant();
				return;
			case OrdrePackage.MISSION_TYPE__DESTINATAIRE:
				setDestinataire(DESTINATAIRE_EDEFAULT);
				return;
			case OrdrePackage.MISSION_TYPE__PUBLIE:
				unsetPublie();
				return;
			case OrdrePackage.MISSION_TYPE__ORDRE:
				getOrdre().clear();
				return;
			case OrdrePackage.MISSION_TYPE__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case OrdrePackage.MISSION_TYPE__ID_MISSION:
				unsetIdMission();
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
			case OrdrePackage.MISSION_TYPE__ETAT:
				return isSetEtat();
			case OrdrePackage.MISSION_TYPE__ID_ORDRE_COUTANT:
				return isSetIdOrdreCoutant();
			case OrdrePackage.MISSION_TYPE__DESTINATAIRE:
				return DESTINATAIRE_EDEFAULT == null ? destinataire != null : !DESTINATAIRE_EDEFAULT.equals(destinataire);
			case OrdrePackage.MISSION_TYPE__PUBLIE:
				return isSetPublie();
			case OrdrePackage.MISSION_TYPE__ORDRE:
				return ordre != null && !ordre.isEmpty();
			case OrdrePackage.MISSION_TYPE__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case OrdrePackage.MISSION_TYPE__ID_MISSION:
				return isSetIdMission();
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
		result.append(" (etat: ");
		if (etatESet) result.append(etat); else result.append("<unset>");
		result.append(", idOrdreCoutant: ");
		if (idOrdreCoutantESet) result.append(idOrdreCoutant); else result.append("<unset>");
		result.append(", destinataire: ");
		result.append(destinataire);
		result.append(", publie: ");
		if (publieESet) result.append(publie); else result.append("<unset>");
		result.append(", date: ");
		result.append(date);
		result.append(", idMission: ");
		if (idMissionESet) result.append(idMission); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MissionTypeImpl
