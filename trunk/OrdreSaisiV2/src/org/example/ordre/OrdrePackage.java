/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.ordre;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.example.ordre.OrdreFactory
 * @model kind="package"
 * @generated
 */
public interface OrdrePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ordre";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/Ordre";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ordre";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OrdrePackage eINSTANCE = org.example.ordre.impl.OrdrePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.example.ordre.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.ordre.impl.DocumentRootImpl
	 * @see org.example.ordre.impl.OrdrePackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Mission</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MISSION = 3;

	/**
	 * The feature id for the '<em><b>New Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__NEW_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.example.ordre.impl.MissionTypeImpl <em>Mission Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.ordre.impl.MissionTypeImpl
	 * @see org.example.ordre.impl.OrdrePackageImpl#getMissionType()
	 * @generated
	 */
	int MISSION_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Etat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TYPE__ETAT = 0;

	/**
	 * The feature id for the '<em><b>Id Ordre Coutant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TYPE__ID_ORDRE_COUTANT = 1;

	/**
	 * The feature id for the '<em><b>Destinataire</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TYPE__DESTINATAIRE = 2;

	/**
	 * The feature id for the '<em><b>Publie</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TYPE__PUBLIE = 3;

	/**
	 * The feature id for the '<em><b>Ordre</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TYPE__ORDRE = 4;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TYPE__DATE = 5;

	/**
	 * The feature id for the '<em><b>Id Mission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TYPE__ID_MISSION = 6;

	/**
	 * The number of structural features of the '<em>Mission Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TYPE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.example.ordre.impl.OrdreTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.ordre.impl.OrdreTypeImpl
	 * @see org.example.ordre.impl.OrdrePackageImpl#getOrdreType()
	 * @generated
	 */
	int ORDRE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Contenu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDRE_TYPE__CONTENU = 0;

	/**
	 * The feature id for the '<em><b>Etat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDRE_TYPE__ETAT = 1;

	/**
	 * The feature id for the '<em><b>Reponse Possible</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDRE_TYPE__REPONSE_POSSIBLE = 2;

	/**
	 * The feature id for the '<em><b>Ordrefinal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDRE_TYPE__ORDREFINAL = 3;

	/**
	 * The feature id for the '<em><b>Fichier Audio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDRE_TYPE__FICHIER_AUDIO = 4;

	/**
	 * The feature id for the '<em><b>Id Ordre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDRE_TYPE__ID_ORDRE = 5;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDRE_TYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.example.ordre.impl.ReponsePossibleTypeImpl <em>Reponse Possible Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.ordre.impl.ReponsePossibleTypeImpl
	 * @see org.example.ordre.impl.OrdrePackageImpl#getReponsePossibleType()
	 * @generated
	 */
	int REPONSE_POSSIBLE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Reponse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPONSE_POSSIBLE_TYPE__REPONSE = 0;

	/**
	 * The feature id for the '<em><b>Ordre Suivant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPONSE_POSSIBLE_TYPE__ORDRE_SUIVANT = 1;

	/**
	 * The feature id for the '<em><b>Id Reponse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPONSE_POSSIBLE_TYPE__ID_REPONSE = 2;

	/**
	 * The number of structural features of the '<em>Reponse Possible Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPONSE_POSSIBLE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.example.ordre.EtatType <em>Etat Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.ordre.EtatType
	 * @see org.example.ordre.impl.OrdrePackageImpl#getEtatType()
	 * @generated
	 */
	int ETAT_TYPE = 4;

	/**
	 * The meta object id for the '{@link org.example.ordre.EtatType1 <em>Etat Type1</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.ordre.EtatType1
	 * @see org.example.ordre.impl.OrdrePackageImpl#getEtatType1()
	 * @generated
	 */
	int ETAT_TYPE1 = 5;

	/**
	 * The meta object id for the '<em>Etat Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.ordre.EtatType
	 * @see org.example.ordre.impl.OrdrePackageImpl#getEtatTypeObject()
	 * @generated
	 */
	int ETAT_TYPE_OBJECT = 6;

	/**
	 * The meta object id for the '<em>Etat Type Object1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.ordre.EtatType1
	 * @see org.example.ordre.impl.OrdrePackageImpl#getEtatTypeObject1()
	 * @generated
	 */
	int ETAT_TYPE_OBJECT1 = 7;


	/**
	 * Returns the meta object for class '{@link org.example.ordre.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.example.ordre.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.example.ordre.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.example.ordre.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.example.ordre.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.example.ordre.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.example.ordre.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.example.ordre.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.example.ordre.DocumentRoot#getMission <em>Mission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mission</em>'.
	 * @see org.example.ordre.DocumentRoot#getMission()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Mission();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.DocumentRoot#getNewAttribute <em>New Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Attribute</em>'.
	 * @see org.example.ordre.DocumentRoot#getNewAttribute()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_NewAttribute();

	/**
	 * Returns the meta object for class '{@link org.example.ordre.MissionType <em>Mission Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mission Type</em>'.
	 * @see org.example.ordre.MissionType
	 * @generated
	 */
	EClass getMissionType();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.MissionType#getEtat <em>Etat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etat</em>'.
	 * @see org.example.ordre.MissionType#getEtat()
	 * @see #getMissionType()
	 * @generated
	 */
	EAttribute getMissionType_Etat();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.MissionType#getIdOrdreCoutant <em>Id Ordre Coutant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Ordre Coutant</em>'.
	 * @see org.example.ordre.MissionType#getIdOrdreCoutant()
	 * @see #getMissionType()
	 * @generated
	 */
	EAttribute getMissionType_IdOrdreCoutant();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.MissionType#getDestinataire <em>Destinataire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destinataire</em>'.
	 * @see org.example.ordre.MissionType#getDestinataire()
	 * @see #getMissionType()
	 * @generated
	 */
	EAttribute getMissionType_Destinataire();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.MissionType#isPublie <em>Publie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publie</em>'.
	 * @see org.example.ordre.MissionType#isPublie()
	 * @see #getMissionType()
	 * @generated
	 */
	EAttribute getMissionType_Publie();

	/**
	 * Returns the meta object for the containment reference list '{@link org.example.ordre.MissionType#getOrdre <em>Ordre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ordre</em>'.
	 * @see org.example.ordre.MissionType#getOrdre()
	 * @see #getMissionType()
	 * @generated
	 */
	EReference getMissionType_Ordre();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.MissionType#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.example.ordre.MissionType#getDate()
	 * @see #getMissionType()
	 * @generated
	 */
	EAttribute getMissionType_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.MissionType#getIdMission <em>Id Mission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Mission</em>'.
	 * @see org.example.ordre.MissionType#getIdMission()
	 * @see #getMissionType()
	 * @generated
	 */
	EAttribute getMissionType_IdMission();

	/**
	 * Returns the meta object for class '{@link org.example.ordre.OrdreType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.example.ordre.OrdreType
	 * @generated
	 */
	EClass getOrdreType();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.OrdreType#getContenu <em>Contenu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contenu</em>'.
	 * @see org.example.ordre.OrdreType#getContenu()
	 * @see #getOrdreType()
	 * @generated
	 */
	EAttribute getOrdreType_Contenu();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.OrdreType#getEtat <em>Etat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etat</em>'.
	 * @see org.example.ordre.OrdreType#getEtat()
	 * @see #getOrdreType()
	 * @generated
	 */
	EAttribute getOrdreType_Etat();

	/**
	 * Returns the meta object for the containment reference list '{@link org.example.ordre.OrdreType#getReponsePossible <em>Reponse Possible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reponse Possible</em>'.
	 * @see org.example.ordre.OrdreType#getReponsePossible()
	 * @see #getOrdreType()
	 * @generated
	 */
	EReference getOrdreType_ReponsePossible();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.OrdreType#isOrdrefinal <em>Ordrefinal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordrefinal</em>'.
	 * @see org.example.ordre.OrdreType#isOrdrefinal()
	 * @see #getOrdreType()
	 * @generated
	 */
	EAttribute getOrdreType_Ordrefinal();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.OrdreType#getFichierAudio <em>Fichier Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fichier Audio</em>'.
	 * @see org.example.ordre.OrdreType#getFichierAudio()
	 * @see #getOrdreType()
	 * @generated
	 */
	EAttribute getOrdreType_FichierAudio();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.OrdreType#getIdOrdre <em>Id Ordre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Ordre</em>'.
	 * @see org.example.ordre.OrdreType#getIdOrdre()
	 * @see #getOrdreType()
	 * @generated
	 */
	EAttribute getOrdreType_IdOrdre();

	/**
	 * Returns the meta object for class '{@link org.example.ordre.ReponsePossibleType <em>Reponse Possible Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reponse Possible Type</em>'.
	 * @see org.example.ordre.ReponsePossibleType
	 * @generated
	 */
	EClass getReponsePossibleType();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.ReponsePossibleType#getReponse <em>Reponse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reponse</em>'.
	 * @see org.example.ordre.ReponsePossibleType#getReponse()
	 * @see #getReponsePossibleType()
	 * @generated
	 */
	EAttribute getReponsePossibleType_Reponse();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.ReponsePossibleType#getOrdreSuivant <em>Ordre Suivant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordre Suivant</em>'.
	 * @see org.example.ordre.ReponsePossibleType#getOrdreSuivant()
	 * @see #getReponsePossibleType()
	 * @generated
	 */
	EAttribute getReponsePossibleType_OrdreSuivant();

	/**
	 * Returns the meta object for the attribute '{@link org.example.ordre.ReponsePossibleType#getIdReponse <em>Id Reponse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Reponse</em>'.
	 * @see org.example.ordre.ReponsePossibleType#getIdReponse()
	 * @see #getReponsePossibleType()
	 * @generated
	 */
	EAttribute getReponsePossibleType_IdReponse();

	/**
	 * Returns the meta object for enum '{@link org.example.ordre.EtatType <em>Etat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Etat Type</em>'.
	 * @see org.example.ordre.EtatType
	 * @generated
	 */
	EEnum getEtatType();

	/**
	 * Returns the meta object for enum '{@link org.example.ordre.EtatType1 <em>Etat Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Etat Type1</em>'.
	 * @see org.example.ordre.EtatType1
	 * @generated
	 */
	EEnum getEtatType1();

	/**
	 * Returns the meta object for data type '{@link org.example.ordre.EtatType <em>Etat Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Etat Type Object</em>'.
	 * @see org.example.ordre.EtatType
	 * @model instanceClass="org.example.ordre.EtatType"
	 *        extendedMetaData="name='Etat_._type:Object' baseType='Etat_._type'"
	 * @generated
	 */
	EDataType getEtatTypeObject();

	/**
	 * Returns the meta object for data type '{@link org.example.ordre.EtatType1 <em>Etat Type Object1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Etat Type Object1</em>'.
	 * @see org.example.ordre.EtatType1
	 * @model instanceClass="org.example.ordre.EtatType1"
	 *        extendedMetaData="name='Etat_._1_._type:Object' baseType='Etat_._1_._type'"
	 * @generated
	 */
	EDataType getEtatTypeObject1();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OrdreFactory getOrdreFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.example.ordre.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.ordre.impl.DocumentRootImpl
		 * @see org.example.ordre.impl.OrdrePackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Mission</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__MISSION = eINSTANCE.getDocumentRoot_Mission();

		/**
		 * The meta object literal for the '<em><b>New Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__NEW_ATTRIBUTE = eINSTANCE.getDocumentRoot_NewAttribute();

		/**
		 * The meta object literal for the '{@link org.example.ordre.impl.MissionTypeImpl <em>Mission Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.ordre.impl.MissionTypeImpl
		 * @see org.example.ordre.impl.OrdrePackageImpl#getMissionType()
		 * @generated
		 */
		EClass MISSION_TYPE = eINSTANCE.getMissionType();

		/**
		 * The meta object literal for the '<em><b>Etat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION_TYPE__ETAT = eINSTANCE.getMissionType_Etat();

		/**
		 * The meta object literal for the '<em><b>Id Ordre Coutant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION_TYPE__ID_ORDRE_COUTANT = eINSTANCE.getMissionType_IdOrdreCoutant();

		/**
		 * The meta object literal for the '<em><b>Destinataire</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION_TYPE__DESTINATAIRE = eINSTANCE.getMissionType_Destinataire();

		/**
		 * The meta object literal for the '<em><b>Publie</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION_TYPE__PUBLIE = eINSTANCE.getMissionType_Publie();

		/**
		 * The meta object literal for the '<em><b>Ordre</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MISSION_TYPE__ORDRE = eINSTANCE.getMissionType_Ordre();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION_TYPE__DATE = eINSTANCE.getMissionType_Date();

		/**
		 * The meta object literal for the '<em><b>Id Mission</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION_TYPE__ID_MISSION = eINSTANCE.getMissionType_IdMission();

		/**
		 * The meta object literal for the '{@link org.example.ordre.impl.OrdreTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.ordre.impl.OrdreTypeImpl
		 * @see org.example.ordre.impl.OrdrePackageImpl#getOrdreType()
		 * @generated
		 */
		EClass ORDRE_TYPE = eINSTANCE.getOrdreType();

		/**
		 * The meta object literal for the '<em><b>Contenu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDRE_TYPE__CONTENU = eINSTANCE.getOrdreType_Contenu();

		/**
		 * The meta object literal for the '<em><b>Etat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDRE_TYPE__ETAT = eINSTANCE.getOrdreType_Etat();

		/**
		 * The meta object literal for the '<em><b>Reponse Possible</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDRE_TYPE__REPONSE_POSSIBLE = eINSTANCE.getOrdreType_ReponsePossible();

		/**
		 * The meta object literal for the '<em><b>Ordrefinal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDRE_TYPE__ORDREFINAL = eINSTANCE.getOrdreType_Ordrefinal();

		/**
		 * The meta object literal for the '<em><b>Fichier Audio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDRE_TYPE__FICHIER_AUDIO = eINSTANCE.getOrdreType_FichierAudio();

		/**
		 * The meta object literal for the '<em><b>Id Ordre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDRE_TYPE__ID_ORDRE = eINSTANCE.getOrdreType_IdOrdre();

		/**
		 * The meta object literal for the '{@link org.example.ordre.impl.ReponsePossibleTypeImpl <em>Reponse Possible Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.ordre.impl.ReponsePossibleTypeImpl
		 * @see org.example.ordre.impl.OrdrePackageImpl#getReponsePossibleType()
		 * @generated
		 */
		EClass REPONSE_POSSIBLE_TYPE = eINSTANCE.getReponsePossibleType();

		/**
		 * The meta object literal for the '<em><b>Reponse</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPONSE_POSSIBLE_TYPE__REPONSE = eINSTANCE.getReponsePossibleType_Reponse();

		/**
		 * The meta object literal for the '<em><b>Ordre Suivant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPONSE_POSSIBLE_TYPE__ORDRE_SUIVANT = eINSTANCE.getReponsePossibleType_OrdreSuivant();

		/**
		 * The meta object literal for the '<em><b>Id Reponse</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPONSE_POSSIBLE_TYPE__ID_REPONSE = eINSTANCE.getReponsePossibleType_IdReponse();

		/**
		 * The meta object literal for the '{@link org.example.ordre.EtatType <em>Etat Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.ordre.EtatType
		 * @see org.example.ordre.impl.OrdrePackageImpl#getEtatType()
		 * @generated
		 */
		EEnum ETAT_TYPE = eINSTANCE.getEtatType();

		/**
		 * The meta object literal for the '{@link org.example.ordre.EtatType1 <em>Etat Type1</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.ordre.EtatType1
		 * @see org.example.ordre.impl.OrdrePackageImpl#getEtatType1()
		 * @generated
		 */
		EEnum ETAT_TYPE1 = eINSTANCE.getEtatType1();

		/**
		 * The meta object literal for the '<em>Etat Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.ordre.EtatType
		 * @see org.example.ordre.impl.OrdrePackageImpl#getEtatTypeObject()
		 * @generated
		 */
		EDataType ETAT_TYPE_OBJECT = eINSTANCE.getEtatTypeObject();

		/**
		 * The meta object literal for the '<em>Etat Type Object1</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.ordre.EtatType1
		 * @see org.example.ordre.impl.OrdrePackageImpl#getEtatTypeObject1()
		 * @generated
		 */
		EDataType ETAT_TYPE_OBJECT1 = eINSTANCE.getEtatTypeObject1();

	}

} //OrdrePackage
