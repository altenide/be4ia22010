/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.ordre;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reponse Possible Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.ordre.ReponsePossibleType#getReponse <em>Reponse</em>}</li>
 *   <li>{@link org.example.ordre.ReponsePossibleType#getOrdreSuivant <em>Ordre Suivant</em>}</li>
 *   <li>{@link org.example.ordre.ReponsePossibleType#getIdReponse <em>Id Reponse</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.ordre.OrdrePackage#getReponsePossibleType()
 * @model extendedMetaData="name='ReponsePossibleType' kind='elementOnly'"
 * @generated
 */
public interface ReponsePossibleType extends EObject {
	/**
	 * Returns the value of the '<em><b>Reponse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reponse</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reponse</em>' attribute.
	 * @see #setReponse(String)
	 * @see org.example.ordre.OrdrePackage#getReponsePossibleType_Reponse()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='Reponse' namespace='##targetNamespace'"
	 * @generated
	 */
	String getReponse();

	/**
	 * Sets the value of the '{@link org.example.ordre.ReponsePossibleType#getReponse <em>Reponse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reponse</em>' attribute.
	 * @see #getReponse()
	 * @generated
	 */
	void setReponse(String value);

	/**
	 * Returns the value of the '<em><b>Ordre Suivant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordre Suivant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordre Suivant</em>' attribute.
	 * @see #isSetOrdreSuivant()
	 * @see #unsetOrdreSuivant()
	 * @see #setOrdreSuivant(int)
	 * @see org.example.ordre.OrdrePackage#getReponsePossibleType_OrdreSuivant()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='element' name='OrdreSuivant' namespace='##targetNamespace'"
	 * @generated
	 */
	int getOrdreSuivant();

	/**
	 * Sets the value of the '{@link org.example.ordre.ReponsePossibleType#getOrdreSuivant <em>Ordre Suivant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordre Suivant</em>' attribute.
	 * @see #isSetOrdreSuivant()
	 * @see #unsetOrdreSuivant()
	 * @see #getOrdreSuivant()
	 * @generated
	 */
	void setOrdreSuivant(int value);

	/**
	 * Unsets the value of the '{@link org.example.ordre.ReponsePossibleType#getOrdreSuivant <em>Ordre Suivant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOrdreSuivant()
	 * @see #getOrdreSuivant()
	 * @see #setOrdreSuivant(int)
	 * @generated
	 */
	void unsetOrdreSuivant();

	/**
	 * Returns whether the value of the '{@link org.example.ordre.ReponsePossibleType#getOrdreSuivant <em>Ordre Suivant</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ordre Suivant</em>' attribute is set.
	 * @see #unsetOrdreSuivant()
	 * @see #getOrdreSuivant()
	 * @see #setOrdreSuivant(int)
	 * @generated
	 */
	boolean isSetOrdreSuivant();

	/**
	 * Returns the value of the '<em><b>Id Reponse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Reponse</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Reponse</em>' attribute.
	 * @see #isSetIdReponse()
	 * @see #unsetIdReponse()
	 * @see #setIdReponse(int)
	 * @see org.example.ordre.OrdrePackage#getReponsePossibleType_IdReponse()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='IdReponse'"
	 * @generated
	 */
	int getIdReponse();

	/**
	 * Sets the value of the '{@link org.example.ordre.ReponsePossibleType#getIdReponse <em>Id Reponse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Reponse</em>' attribute.
	 * @see #isSetIdReponse()
	 * @see #unsetIdReponse()
	 * @see #getIdReponse()
	 * @generated
	 */
	void setIdReponse(int value);

	/**
	 * Unsets the value of the '{@link org.example.ordre.ReponsePossibleType#getIdReponse <em>Id Reponse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIdReponse()
	 * @see #getIdReponse()
	 * @see #setIdReponse(int)
	 * @generated
	 */
	void unsetIdReponse();

	/**
	 * Returns whether the value of the '{@link org.example.ordre.ReponsePossibleType#getIdReponse <em>Id Reponse</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Id Reponse</em>' attribute is set.
	 * @see #unsetIdReponse()
	 * @see #getIdReponse()
	 * @see #setIdReponse(int)
	 * @generated
	 */
	boolean isSetIdReponse();

} // ReponsePossibleType
