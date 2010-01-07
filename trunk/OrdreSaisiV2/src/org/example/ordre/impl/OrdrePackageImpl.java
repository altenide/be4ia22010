/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.ordre.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.example.ordre.DocumentRoot;
import org.example.ordre.EtatType;
import org.example.ordre.EtatType1;
import org.example.ordre.MissionType;
import org.example.ordre.OrdreFactory;
import org.example.ordre.OrdrePackage;
import org.example.ordre.OrdreType;
import org.example.ordre.ReponsePossibleType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrdrePackageImpl extends EPackageImpl implements OrdrePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass missionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ordreTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reponsePossibleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum etatTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum etatType1EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType etatTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType etatTypeObject1EDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.example.ordre.OrdrePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OrdrePackageImpl() {
		super(eNS_URI, OrdreFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OrdrePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OrdrePackage init() {
		if (isInited) return (OrdrePackage)EPackage.Registry.INSTANCE.getEPackage(OrdrePackage.eNS_URI);

		// Obtain or create and register package
		OrdrePackageImpl theOrdrePackage = (OrdrePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OrdrePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OrdrePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOrdrePackage.createPackageContents();

		// Initialize created meta-data
		theOrdrePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOrdrePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OrdrePackage.eNS_URI, theOrdrePackage);
		return theOrdrePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Mission() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_NewAttribute() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMissionType() {
		return missionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMissionType_Etat() {
		return (EAttribute)missionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMissionType_IdOrdreCoutant() {
		return (EAttribute)missionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMissionType_Destinataire() {
		return (EAttribute)missionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMissionType_Publie() {
		return (EAttribute)missionTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMissionType_Ordre() {
		return (EReference)missionTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMissionType_Date() {
		return (EAttribute)missionTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMissionType_IdMission() {
		return (EAttribute)missionTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrdreType() {
		return ordreTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrdreType_Contenu() {
		return (EAttribute)ordreTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrdreType_Etat() {
		return (EAttribute)ordreTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrdreType_ReponsePossible() {
		return (EReference)ordreTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrdreType_Ordrefinal() {
		return (EAttribute)ordreTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrdreType_FichierAudio() {
		return (EAttribute)ordreTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrdreType_IdOrdre() {
		return (EAttribute)ordreTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReponsePossibleType() {
		return reponsePossibleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReponsePossibleType_Reponse() {
		return (EAttribute)reponsePossibleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReponsePossibleType_OrdreSuivant() {
		return (EAttribute)reponsePossibleTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReponsePossibleType_IdReponse() {
		return (EAttribute)reponsePossibleTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEtatType() {
		return etatTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEtatType1() {
		return etatType1EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEtatTypeObject() {
		return etatTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEtatTypeObject1() {
		return etatTypeObject1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrdreFactory getOrdreFactory() {
		return (OrdreFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MISSION);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__NEW_ATTRIBUTE);

		missionTypeEClass = createEClass(MISSION_TYPE);
		createEAttribute(missionTypeEClass, MISSION_TYPE__ETAT);
		createEAttribute(missionTypeEClass, MISSION_TYPE__ID_ORDRE_COUTANT);
		createEAttribute(missionTypeEClass, MISSION_TYPE__DESTINATAIRE);
		createEAttribute(missionTypeEClass, MISSION_TYPE__PUBLIE);
		createEReference(missionTypeEClass, MISSION_TYPE__ORDRE);
		createEAttribute(missionTypeEClass, MISSION_TYPE__DATE);
		createEAttribute(missionTypeEClass, MISSION_TYPE__ID_MISSION);

		ordreTypeEClass = createEClass(ORDRE_TYPE);
		createEAttribute(ordreTypeEClass, ORDRE_TYPE__CONTENU);
		createEAttribute(ordreTypeEClass, ORDRE_TYPE__ETAT);
		createEReference(ordreTypeEClass, ORDRE_TYPE__REPONSE_POSSIBLE);
		createEAttribute(ordreTypeEClass, ORDRE_TYPE__ORDREFINAL);
		createEAttribute(ordreTypeEClass, ORDRE_TYPE__FICHIER_AUDIO);
		createEAttribute(ordreTypeEClass, ORDRE_TYPE__ID_ORDRE);

		reponsePossibleTypeEClass = createEClass(REPONSE_POSSIBLE_TYPE);
		createEAttribute(reponsePossibleTypeEClass, REPONSE_POSSIBLE_TYPE__REPONSE);
		createEAttribute(reponsePossibleTypeEClass, REPONSE_POSSIBLE_TYPE__ORDRE_SUIVANT);
		createEAttribute(reponsePossibleTypeEClass, REPONSE_POSSIBLE_TYPE__ID_REPONSE);

		// Create enums
		etatTypeEEnum = createEEnum(ETAT_TYPE);
		etatType1EEnum = createEEnum(ETAT_TYPE1);

		// Create data types
		etatTypeObjectEDataType = createEDataType(ETAT_TYPE_OBJECT);
		etatTypeObject1EDataType = createEDataType(ETAT_TYPE_OBJECT1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Mission(), this.getMissionType(), null, "mission", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_NewAttribute(), theXMLTypePackage.getString(), "newAttribute", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(missionTypeEClass, MissionType.class, "MissionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMissionType_Etat(), this.getEtatType1(), "etat", null, 1, 1, MissionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMissionType_IdOrdreCoutant(), theXMLTypePackage.getInt(), "idOrdreCoutant", null, 1, 1, MissionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMissionType_Destinataire(), theXMLTypePackage.getString(), "destinataire", null, 0, 1, MissionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMissionType_Publie(), theXMLTypePackage.getBoolean(), "publie", null, 1, 1, MissionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMissionType_Ordre(), this.getOrdreType(), null, "ordre", null, 1, -1, MissionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMissionType_Date(), theXMLTypePackage.getDateTime(), "date", null, 1, 1, MissionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMissionType_IdMission(), theXMLTypePackage.getInt(), "idMission", null, 0, 1, MissionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ordreTypeEClass, OrdreType.class, "OrdreType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrdreType_Contenu(), theXMLTypePackage.getString(), "contenu", null, 1, 1, OrdreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrdreType_Etat(), this.getEtatType(), "etat", null, 1, 1, OrdreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOrdreType_ReponsePossible(), this.getReponsePossibleType(), null, "reponsePossible", null, 1, -1, OrdreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrdreType_Ordrefinal(), theXMLTypePackage.getBoolean(), "ordrefinal", null, 1, 1, OrdreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrdreType_FichierAudio(), theXMLTypePackage.getString(), "fichierAudio", null, 0, 1, OrdreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrdreType_IdOrdre(), theXMLTypePackage.getInt(), "idOrdre", null, 0, 1, OrdreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reponsePossibleTypeEClass, ReponsePossibleType.class, "ReponsePossibleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReponsePossibleType_Reponse(), theXMLTypePackage.getString(), "reponse", null, 1, 1, ReponsePossibleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReponsePossibleType_OrdreSuivant(), theXMLTypePackage.getInt(), "ordreSuivant", null, 0, 1, ReponsePossibleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReponsePossibleType_IdReponse(), theXMLTypePackage.getInt(), "idReponse", null, 0, 1, ReponsePossibleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(etatTypeEEnum, EtatType.class, "EtatType");
		addEEnumLiteral(etatTypeEEnum, EtatType.NON_ATTEINT);
		addEEnumLiteral(etatTypeEEnum, EtatType.REFUSE);
		addEEnumLiteral(etatTypeEEnum, EtatType.EN_COURS);
		addEEnumLiteral(etatTypeEEnum, EtatType.TERMINE);

		initEEnum(etatType1EEnum, EtatType1.class, "EtatType1");
		addEEnumLiteral(etatType1EEnum, EtatType1.EN_COURS);
		addEEnumLiteral(etatType1EEnum, EtatType1.TERMINE);
		addEEnumLiteral(etatType1EEnum, EtatType1.DISPONIBLE);
		addEEnumLiteral(etatType1EEnum, EtatType1.NON_DISPONIBLE);

		// Initialize data types
		initEDataType(etatTypeObjectEDataType, EtatType.class, "EtatTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(etatTypeObject1EDataType, EtatType1.class, "EtatTypeObject1", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_Mission(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Mission",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_NewAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "NewAttribute",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (etatTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "Etat_._type"
		   });		
		addAnnotation
		  (etatType1EEnum, 
		   source, 
		   new String[] {
			 "name", "Etat_._1_._type"
		   });		
		addAnnotation
		  (etatTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "Etat_._type:Object",
			 "baseType", "Etat_._type"
		   });		
		addAnnotation
		  (etatTypeObject1EDataType, 
		   source, 
		   new String[] {
			 "name", "Etat_._1_._type:Object",
			 "baseType", "Etat_._1_._type"
		   });		
		addAnnotation
		  (missionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "MissionType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMissionType_Etat(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Etat",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getMissionType_IdOrdreCoutant(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "IdOrdreCoutant",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMissionType_Destinataire(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Destinataire",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMissionType_Publie(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Publie",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMissionType_Ordre(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Ordre",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMissionType_Date(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Date",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMissionType_IdMission(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "IdMission"
		   });		
		addAnnotation
		  (ordreTypeEClass, 
		   source, 
		   new String[] {
			 "name", "OrdreType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getOrdreType_Contenu(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Contenu",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOrdreType_Etat(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Etat",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOrdreType_ReponsePossible(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ReponsePossible",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOrdreType_Ordrefinal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Ordrefinal",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOrdreType_FichierAudio(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FichierAudio",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOrdreType_IdOrdre(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "IdOrdre"
		   });		
		addAnnotation
		  (reponsePossibleTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ReponsePossibleType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getReponsePossibleType_Reponse(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Reponse",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getReponsePossibleType_OrdreSuivant(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "OrdreSuivant",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getReponsePossibleType_IdReponse(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "IdReponse"
		   });
	}

} //OrdrePackageImpl
