/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.ordre;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mission Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.ordre.MissionType#getEtat <em>Etat</em>}</li>
 *   <li>{@link org.example.ordre.MissionType#getIdOrdreCoutant <em>Id Ordre Coutant</em>}</li>
 *   <li>{@link org.example.ordre.MissionType#getDestinataire <em>Destinataire</em>}</li>
 *   <li>{@link org.example.ordre.MissionType#isPublie <em>Publie</em>}</li>
 *   <li>{@link org.example.ordre.MissionType#getOrdre <em>Ordre</em>}</li>
 *   <li>{@link org.example.ordre.MissionType#getDate <em>Date</em>}</li>
 *   <li>{@link org.example.ordre.MissionType#getIdMission <em>Id Mission</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.ordre.OrdrePackage#getMissionType()
 * @model extendedMetaData="name='MissionType' kind='elementOnly'"
 * @generated
 */
public interface MissionType extends EObject {
	/**
	 * Returns the value of the '<em><b>Etat</b></em>' attribute.
	 * The literals are from the enumeration {@link org.example.ordre.EtatType1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Etat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Etat</em>' attribute.
	 * @see org.example.ordre.EtatType1
	 * @see #isSetEtat()
	 * @see #unsetEtat()
	 * @see #setEtat(EtatType1)
	 * @see org.example.ordre.OrdrePackage#getMissionType_Etat()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='element' name='Etat' namespace='##targetNamespace'"
	 * @generated
	 */
	EtatType1 getEtat();

	/**
	 * Sets the value of the '{@link org.example.ordre.MissionType#getEtat <em>Etat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Etat</em>' attribute.
	 * @see org.example.ordre.EtatType1
	 * @see #isSetEtat()
	 * @see #unsetEtat()
	 * @see #getEtat()
	 * @generated
	 */
	void setEtat(EtatType1 value);

	/**
	 * Unsets the value of the '{@link org.example.ordre.MissionType#getEtat <em>Etat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEtat()
	 * @see #getEtat()
	 * @see #setEtat(EtatType1)
	 * @generated
	 */
	void unsetEtat();

	/**
	 * Returns whether the value of the '{@link org.example.ordre.MissionType#getEtat <em>Etat</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Etat</em>' attribute is set.
	 * @see #unsetEtat()
	 * @see #getEtat()
	 * @see #setEtat(EtatType1)
	 * @generated
	 */
	boolean isSetEtat();

	/**
	 * Returns the value of the '<em><b>Id Ordre Coutant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 						Sera l'id de l'ordre courant -1 signifira que
	 * 						l'ordre n'a pas encore commencé
	 *     	 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id Ordre Coutant</em>' attribute.
	 * @see #isSetIdOrdreCoutant()
	 * @see #unsetIdOrdreCoutant()
	 * @see #setIdOrdreCoutant(int)
	 * @see org.example.ordre.OrdrePackage#getMissionType_IdOrdreCoutant()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='element' name='IdOrdreCoutant' namespace='##targetNamespace'"
	 * @generated
	 */
	int getIdOrdreCoutant();

	/**
	 * Sets the value of the '{@link org.example.ordre.MissionType#getIdOrdreCoutant <em>Id Ordre Coutant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Ordre Coutant</em>' attribute.
	 * @see #isSetIdOrdreCoutant()
	 * @see #unsetIdOrdreCoutant()
	 * @see #getIdOrdreCoutant()
	 * @generated
	 */
	void setIdOrdreCoutant(int value);

	/**
	 * Unsets the value of the '{@link org.example.ordre.MissionType#getIdOrdreCoutant <em>Id Ordre Coutant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIdOrdreCoutant()
	 * @see #getIdOrdreCoutant()
	 * @see #setIdOrdreCoutant(int)
	 * @generated
	 */
	void unsetIdOrdreCoutant();

	/**
	 * Returns whether the value of the '{@link org.example.ordre.MissionType#getIdOrdreCoutant <em>Id Ordre Coutant</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Id Ordre Coutant</em>' attribute is set.
	 * @see #unsetIdOrdreCoutant()
	 * @see #getIdOrdreCoutant()
	 * @see #setIdOrdreCoutant(int)
	 * @generated
	 */
	boolean isSetIdOrdreCoutant();

	/**
	 * Returns the value of the '<em><b>Destinataire</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destinataire</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destinataire</em>' attribute.
	 * @see #setDestinataire(String)
	 * @see org.example.ordre.OrdrePackage#getMissionType_Destinataire()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='Destinataire' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDestinataire();

	/**
	 * Sets the value of the '{@link org.example.ordre.MissionType#getDestinataire <em>Destinataire</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destinataire</em>' attribute.
	 * @see #getDestinataire()
	 * @generated
	 */
	void setDestinataire(String value);

	/**
	 * Returns the value of the '<em><b>Publie</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publie</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publie</em>' attribute.
	 * @see #isSetPublie()
	 * @see #unsetPublie()
	 * @see #setPublie(boolean)
	 * @see org.example.ordre.OrdrePackage#getMissionType_Publie()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 *        extendedMetaData="kind='element' name='Publie' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isPublie();

	/**
	 * Sets the value of the '{@link org.example.ordre.MissionType#isPublie <em>Publie</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publie</em>' attribute.
	 * @see #isSetPublie()
	 * @see #unsetPublie()
	 * @see #isPublie()
	 * @generated
	 */
	void setPublie(boolean value);

	/**
	 * Unsets the value of the '{@link org.example.ordre.MissionType#isPublie <em>Publie</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPublie()
	 * @see #isPublie()
	 * @see #setPublie(boolean)
	 * @generated
	 */
	void unsetPublie();

	/**
	 * Returns whether the value of the '{@link org.example.ordre.MissionType#isPublie <em>Publie</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Publie</em>' attribute is set.
	 * @see #unsetPublie()
	 * @see #isPublie()
	 * @see #setPublie(boolean)
	 * @generated
	 */
	boolean isSetPublie();

	/**
	 * Returns the value of the '<em><b>Ordre</b></em>' containment reference list.
	 * The list contents are of type {@link org.example.ordre.OrdreType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordre</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordre</em>' containment reference list.
	 * @see org.example.ordre.OrdrePackage#getMissionType_Ordre()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Ordre' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<OrdreType> getOrdre();

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(XMLGregorianCalendar)
	 * @see org.example.ordre.OrdrePackage#getMissionType_Date()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime" required="true"
	 *        extendedMetaData="kind='element' name='Date' namespace='##targetNamespace'"
	 * @generated
	 */
	XMLGregorianCalendar getDate();

	/**
	 * Sets the value of the '{@link org.example.ordre.MissionType#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Id Mission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Mission</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Mission</em>' attribute.
	 * @see #isSetIdMission()
	 * @see #unsetIdMission()
	 * @see #setIdMission(int)
	 * @see org.example.ordre.OrdrePackage#getMissionType_IdMission()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='IdMission'"
	 * @generated
	 */
	int getIdMission();

	/**
	 * Sets the value of the '{@link org.example.ordre.MissionType#getIdMission <em>Id Mission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Mission</em>' attribute.
	 * @see #isSetIdMission()
	 * @see #unsetIdMission()
	 * @see #getIdMission()
	 * @generated
	 */
	void setIdMission(int value);

	/**
	 * Unsets the value of the '{@link org.example.ordre.MissionType#getIdMission <em>Id Mission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIdMission()
	 * @see #getIdMission()
	 * @see #setIdMission(int)
	 * @generated
	 */
	void unsetIdMission();

	/**
	 * Returns whether the value of the '{@link org.example.ordre.MissionType#getIdMission <em>Id Mission</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Id Mission</em>' attribute is set.
	 * @see #unsetIdMission()
	 * @see #getIdMission()
	 * @see #setIdMission(int)
	 * @generated
	 */
	boolean isSetIdMission();

} // MissionType
