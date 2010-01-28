/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Ordre.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import Ordre.ordre.*;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.ordre.impl.OrdreTypeImpl#getContenu <em>Contenu</em>}</li>
 *   <li>{@link org.example.ordre.impl.OrdreTypeImpl#getEtat <em>Etat</em>}</li>
 *   <li>{@link org.example.ordre.impl.OrdreTypeImpl#getReponsePossible <em>Reponse Possible</em>}</li>
 *   <li>{@link org.example.ordre.impl.OrdreTypeImpl#isOrdrefinal <em>Ordrefinal</em>}</li>
 *   <li>{@link org.example.ordre.impl.OrdreTypeImpl#getFichierAudio <em>Fichier Audio</em>}</li>
 *   <li>{@link org.example.ordre.impl.OrdreTypeImpl#getIdOrdre <em>Id Ordre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrdreTypeImpl extends EObjectImpl implements OrdreType {
	/**
	 * The default value of the '{@link #getContenu() <em>Contenu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContenu()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENU_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContenu() <em>Contenu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContenu()
	 * @generated
	 * @ordered
	 */
	protected String contenu = CONTENU_EDEFAULT;

	/**
	 * The default value of the '{@link #getEtat() <em>Etat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtat()
	 * @generated
	 * @ordered
	 */
	protected static final EtatType ETAT_EDEFAULT = EtatType.NON_ATTEINT;

	/**
	 * The cached value of the '{@link #getEtat() <em>Etat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtat()
	 * @generated
	 * @ordered
	 */
	protected EtatType etat = ETAT_EDEFAULT;

	/**
	 * This is true if the Etat attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean etatESet;

	/**
	 * The cached value of the '{@link #getReponsePossible() <em>Reponse Possible</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReponsePossible()
	 * @generated
	 * @ordered
	 */
	protected EList<ReponsePossibleType> reponsePossible;

	/**
	 * The default value of the '{@link #isOrdrefinal() <em>Ordrefinal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdrefinal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ORDREFINAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOrdrefinal() <em>Ordrefinal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdrefinal()
	 * @generated
	 * @ordered
	 */
	protected boolean ordrefinal = ORDREFINAL_EDEFAULT;

	/**
	 * This is true if the Ordrefinal attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean ordrefinalESet;

	/**
	 * The default value of the '{@link #getFichierAudio() <em>Fichier Audio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFichierAudio()
	 * @generated
	 * @ordered
	 */
	protected static final String FICHIER_AUDIO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFichierAudio() <em>Fichier Audio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFichierAudio()
	 * @generated
	 * @ordered
	 */
	protected String fichierAudio = FICHIER_AUDIO_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdOrdre() <em>Id Ordre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdOrdre()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_ORDRE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdOrdre() <em>Id Ordre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdOrdre()
	 * @generated
	 * @ordered
	 */
	protected int idOrdre = ID_ORDRE_EDEFAULT;

	/**
	 * This is true if the Id Ordre attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean idOrdreESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrdreTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrdrePackage.Literals.ORDRE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContenu(String newContenu) {
		String oldContenu = contenu;
		contenu = newContenu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.ORDRE_TYPE__CONTENU, oldContenu, contenu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatType getEtat() {
		return etat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEtat(EtatType newEtat) {
		EtatType oldEtat = etat;
		etat = newEtat == null ? ETAT_EDEFAULT : newEtat;
		boolean oldEtatESet = etatESet;
		etatESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.ORDRE_TYPE__ETAT, oldEtat, etat, !oldEtatESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEtat() {
		EtatType oldEtat = etat;
		boolean oldEtatESet = etatESet;
		etat = ETAT_EDEFAULT;
		etatESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OrdrePackage.ORDRE_TYPE__ETAT, oldEtat, ETAT_EDEFAULT, oldEtatESet));
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
	public EList<ReponsePossibleType> getReponsePossible() {
		if (reponsePossible == null) {
			reponsePossible = new EObjectContainmentEList<ReponsePossibleType>(ReponsePossibleType.class, this, OrdrePackage.ORDRE_TYPE__REPONSE_POSSIBLE);
		}
		return reponsePossible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdrefinal() {
		return ordrefinal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrdrefinal(boolean newOrdrefinal) {
		boolean oldOrdrefinal = ordrefinal;
		ordrefinal = newOrdrefinal;
		boolean oldOrdrefinalESet = ordrefinalESet;
		ordrefinalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.ORDRE_TYPE__ORDREFINAL, oldOrdrefinal, ordrefinal, !oldOrdrefinalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOrdrefinal() {
		boolean oldOrdrefinal = ordrefinal;
		boolean oldOrdrefinalESet = ordrefinalESet;
		ordrefinal = ORDREFINAL_EDEFAULT;
		ordrefinalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OrdrePackage.ORDRE_TYPE__ORDREFINAL, oldOrdrefinal, ORDREFINAL_EDEFAULT, oldOrdrefinalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOrdrefinal() {
		return ordrefinalESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFichierAudio() {
		return fichierAudio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFichierAudio(String newFichierAudio) {
		String oldFichierAudio = fichierAudio;
		fichierAudio = newFichierAudio;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.ORDRE_TYPE__FICHIER_AUDIO, oldFichierAudio, fichierAudio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIdOrdre() {
		return idOrdre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdOrdre(int newIdOrdre) {
		int oldIdOrdre = idOrdre;
		idOrdre = newIdOrdre;
		boolean oldIdOrdreESet = idOrdreESet;
		idOrdreESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrdrePackage.ORDRE_TYPE__ID_ORDRE, oldIdOrdre, idOrdre, !oldIdOrdreESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIdOrdre() {
		int oldIdOrdre = idOrdre;
		boolean oldIdOrdreESet = idOrdreESet;
		idOrdre = ID_ORDRE_EDEFAULT;
		idOrdreESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OrdrePackage.ORDRE_TYPE__ID_ORDRE, oldIdOrdre, ID_ORDRE_EDEFAULT, oldIdOrdreESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIdOrdre() {
		return idOrdreESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OrdrePackage.ORDRE_TYPE__REPONSE_POSSIBLE:
				return ((InternalEList<?>)getReponsePossible()).basicRemove(otherEnd, msgs);
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
			case OrdrePackage.ORDRE_TYPE__CONTENU:
				return getContenu();
			case OrdrePackage.ORDRE_TYPE__ETAT:
				return getEtat();
			case OrdrePackage.ORDRE_TYPE__REPONSE_POSSIBLE:
				return getReponsePossible();
			case OrdrePackage.ORDRE_TYPE__ORDREFINAL:
				return isOrdrefinal();
			case OrdrePackage.ORDRE_TYPE__FICHIER_AUDIO:
				return getFichierAudio();
			case OrdrePackage.ORDRE_TYPE__ID_ORDRE:
				return getIdOrdre();
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
			case OrdrePackage.ORDRE_TYPE__CONTENU:
				setContenu((String)newValue);
				return;
			case OrdrePackage.ORDRE_TYPE__ETAT:
				setEtat((EtatType)newValue);
				return;
			case OrdrePackage.ORDRE_TYPE__REPONSE_POSSIBLE:
				getReponsePossible().clear();
				getReponsePossible().addAll((Collection<? extends ReponsePossibleType>)newValue);
				return;
			case OrdrePackage.ORDRE_TYPE__ORDREFINAL:
				setOrdrefinal((Boolean)newValue);
				return;
			case OrdrePackage.ORDRE_TYPE__FICHIER_AUDIO:
				setFichierAudio((String)newValue);
				return;
			case OrdrePackage.ORDRE_TYPE__ID_ORDRE:
				setIdOrdre((Integer)newValue);
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
			case OrdrePackage.ORDRE_TYPE__CONTENU:
				setContenu(CONTENU_EDEFAULT);
				return;
			case OrdrePackage.ORDRE_TYPE__ETAT:
				unsetEtat();
				return;
			case OrdrePackage.ORDRE_TYPE__REPONSE_POSSIBLE:
				getReponsePossible().clear();
				return;
			case OrdrePackage.ORDRE_TYPE__ORDREFINAL:
				unsetOrdrefinal();
				return;
			case OrdrePackage.ORDRE_TYPE__FICHIER_AUDIO:
				setFichierAudio(FICHIER_AUDIO_EDEFAULT);
				return;
			case OrdrePackage.ORDRE_TYPE__ID_ORDRE:
				unsetIdOrdre();
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
			case OrdrePackage.ORDRE_TYPE__CONTENU:
				return CONTENU_EDEFAULT == null ? contenu != null : !CONTENU_EDEFAULT.equals(contenu);
			case OrdrePackage.ORDRE_TYPE__ETAT:
				return isSetEtat();
			case OrdrePackage.ORDRE_TYPE__REPONSE_POSSIBLE:
				return reponsePossible != null && !reponsePossible.isEmpty();
			case OrdrePackage.ORDRE_TYPE__ORDREFINAL:
				return isSetOrdrefinal();
			case OrdrePackage.ORDRE_TYPE__FICHIER_AUDIO:
				return FICHIER_AUDIO_EDEFAULT == null ? fichierAudio != null : !FICHIER_AUDIO_EDEFAULT.equals(fichierAudio);
			case OrdrePackage.ORDRE_TYPE__ID_ORDRE:
				return isSetIdOrdre();
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
		result.append(" (contenu: ");
		result.append(contenu);
		result.append(", etat: ");
		if (etatESet) result.append(etat); else result.append("<unset>");
		result.append(", ordrefinal: ");
		if (ordrefinalESet) result.append(ordrefinal); else result.append("<unset>");
		result.append(", fichierAudio: ");
		result.append(fichierAudio);
		result.append(", idOrdre: ");
		if (idOrdreESet) result.append(idOrdre); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //OrdreTypeImpl
