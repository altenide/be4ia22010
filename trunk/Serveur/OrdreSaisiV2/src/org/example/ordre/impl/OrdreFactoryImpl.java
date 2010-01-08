/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.ordre.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.example.ordre.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrdreFactoryImpl extends EFactoryImpl implements OrdreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OrdreFactory init() {
		try {
			OrdreFactory theOrdreFactory = (OrdreFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.example.org/Ordre"); 
			if (theOrdreFactory != null) {
				return theOrdreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OrdreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrdreFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OrdrePackage.DOCUMENT_ROOT: return createDocumentRoot();
			case OrdrePackage.MISSION_TYPE: return createMissionType();
			case OrdrePackage.ORDRE_TYPE: return createOrdreType();
			case OrdrePackage.REPONSE_POSSIBLE_TYPE: return createReponsePossibleType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OrdrePackage.ETAT_TYPE:
				return createEtatTypeFromString(eDataType, initialValue);
			case OrdrePackage.ETAT_TYPE1:
				return createEtatType1FromString(eDataType, initialValue);
			case OrdrePackage.ETAT_TYPE_OBJECT:
				return createEtatTypeObjectFromString(eDataType, initialValue);
			case OrdrePackage.ETAT_TYPE_OBJECT1:
				return createEtatTypeObject1FromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OrdrePackage.ETAT_TYPE:
				return convertEtatTypeToString(eDataType, instanceValue);
			case OrdrePackage.ETAT_TYPE1:
				return convertEtatType1ToString(eDataType, instanceValue);
			case OrdrePackage.ETAT_TYPE_OBJECT:
				return convertEtatTypeObjectToString(eDataType, instanceValue);
			case OrdrePackage.ETAT_TYPE_OBJECT1:
				return convertEtatTypeObject1ToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MissionType createMissionType() {
		MissionTypeImpl missionType = new MissionTypeImpl();
		return missionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrdreType createOrdreType() {
		OrdreTypeImpl ordreType = new OrdreTypeImpl();
		return ordreType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReponsePossibleType createReponsePossibleType() {
		ReponsePossibleTypeImpl reponsePossibleType = new ReponsePossibleTypeImpl();
		return reponsePossibleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatType createEtatTypeFromString(EDataType eDataType, String initialValue) {
		EtatType result = EtatType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEtatTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatType1 createEtatType1FromString(EDataType eDataType, String initialValue) {
		EtatType1 result = EtatType1.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEtatType1ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatType createEtatTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createEtatTypeFromString(OrdrePackage.Literals.ETAT_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEtatTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertEtatTypeToString(OrdrePackage.Literals.ETAT_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatType1 createEtatTypeObject1FromString(EDataType eDataType, String initialValue) {
		return createEtatType1FromString(OrdrePackage.Literals.ETAT_TYPE1, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEtatTypeObject1ToString(EDataType eDataType, Object instanceValue) {
		return convertEtatType1ToString(OrdrePackage.Literals.ETAT_TYPE1, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrdrePackage getOrdrePackage() {
		return (OrdrePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OrdrePackage getPackage() {
		return OrdrePackage.eINSTANCE;
	}

} //OrdreFactoryImpl
