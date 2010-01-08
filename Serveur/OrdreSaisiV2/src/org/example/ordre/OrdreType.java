/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.ordre;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.ordre.OrdreType#getContenu <em>Contenu</em>}</li>
 *   <li>{@link org.example.ordre.OrdreType#getEtat <em>Etat</em>}</li>
 *   <li>{@link org.example.ordre.OrdreType#getReponsePossible <em>Reponse Possible</em>}</li>
 *   <li>{@link org.example.ordre.OrdreType#isOrdrefinal <em>Ordrefinal</em>}</li>
 *   <li>{@link org.example.ordre.OrdreType#getFichierAudio <em>Fichier Audio</em>}</li>
 *   <li>{@link org.example.ordre.OrdreType#getIdOrdre <em>Id Ordre</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.ordre.OrdrePackage#getOrdreType()
 * @model extendedMetaData="name='OrdreType' kind='elementOnly'"
 * @generated
 */
public interface OrdreType extends EObject {
	/**
	 * Returns the value of the '<em><b>Contenu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contenu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contenu</em>' attribute.
	 * @see #setContenu(String)
	 * @see org.example.ordre.OrdrePackage#getOrdreType_Contenu()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='Contenu' namespace='##targetNamespace'"
	 * @generated
	 */
	String getContenu();

	/**
	 * Sets the value of the '{@link org.example.ordre.OrdreType#getContenu <em>Contenu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contenu</em>' attribute.
	 * @see #getContenu()
	 * @generated
	 */
	void setContenu(String value);

	/**
	 * Returns the value of the '<em><b>Etat</b></em>' attribute.
	 * The literals are from the enumeration {@link org.example.ordre.EtatType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Etat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Etat</em>' attribute.
	 * @see org.example.ordre.EtatType
	 * @see #isSetEtat()
	 * @see #unsetEtat()
	 * @see #setEtat(EtatType)
	 * @see org.example.ordre.OrdrePackage#getOrdreType_Etat()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='element' name='Etat' namespace='##targetNamespace'"
	 * @generated
	 */
	EtatType getEtat();

	/**
	 * Sets the value of the '{@link org.example.ordre.OrdreType#getEtat <em>Etat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Etat</em>' attribute.
	 * @see org.example.ordre.EtatType
	 * @see #isSetEtat()
	 * @see #unsetEtat()
	 * @see #getEtat()
	 * @generated
	 */
	void setEtat(EtatType value);

	/**
	 * Unsets the value of the '{@link org.example.ordre.OrdreType#getEtat <em>Etat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEtat()
	 * @see #getEtat()
	 * @see #setEtat(EtatType)
	 * @generated
	 */
	void unsetEtat();

	/**
	 * Returns whether the value of the '{@link org.example.ordre.OrdreType#getEtat <em>Etat</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Etat</em>' attribute is set.
	 * @see #unsetEtat()
	 * @see #getEtat()
	 * @see #setEtat(EtatType)
	 * @generated
	 */
	boolean isSetEtat();

	/**
	 * Returns the value of the '<em><b>Reponse Possible</b></em>' containment reference list.
	 * The list contents are of type {@link org.example.ordre.ReponsePossibleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reponse Possible</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reponse Possible</em>' containment reference list.
	 * @see org.example.ordre.OrdrePackage#getOrdreType_ReponsePossible()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='ReponsePossible' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ReponsePossibleType> getReponsePossible();

	/**
	 * Returns the value of the '<em><b>Ordrefinal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordrefinal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordrefinal</em>' attribute.
	 * @see #isSetOrdrefinal()
	 * @see #unsetOrdrefinal()
	 * @see #setOrdrefinal(boolean)
	 * @see org.example.ordre.OrdrePackage#getOrdreType_Ordrefinal()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 *        extendedMetaData="kind='element' name='Ordrefinal' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isOrdrefinal();

	/**
	 * Sets the value of the '{@link org.example.ordre.OrdreType#isOrdrefinal <em>Ordrefinal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordrefinal</em>' attribute.
	 * @see #isSetOrdrefinal()
	 * @see #unsetOrdrefinal()
	 * @see #isOrdrefinal()
	 * @generated
	 */
	void setOrdrefinal(boolean value);

	/**
	 * Unsets the value of the '{@link org.example.ordre.OrdreType#isOrdrefinal <em>Ordrefinal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOrdrefinal()
	 * @see #isOrdrefinal()
	 * @see #setOrdrefinal(boolean)
	 * @generated
	 */
	void unsetOrdrefinal();

	/**
	 * Returns whether the value of the '{@link org.example.ordre.OrdreType#isOrdrefinal <em>Ordrefinal</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ordrefinal</em>' attribute is set.
	 * @see #unsetOrdrefinal()
	 * @see #isOrdrefinal()
	 * @see #setOrdrefinal(boolean)
	 * @generated
	 */
	boolean isSetOrdrefinal();

	/**
	 * Returns the value of the '<em><b>Fichier Audio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fichier Audio</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fichier Audio</em>' attribute.
	 * @see #setFichierAudio(String)
	 * @see org.example.ordre.OrdrePackage#getOrdreType_FichierAudio()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='FichierAudio' namespace='##targetNamespace'"
	 * @generated
	 */
	String getFichierAudio();

	/**
	 * Sets the value of the '{@link org.example.ordre.OrdreType#getFichierAudio <em>Fichier Audio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fichier Audio</em>' attribute.
	 * @see #getFichierAudio()
	 * @generated
	 */
	void setFichierAudio(String value);

	/**
	 * Returns the value of the '<em><b>Id Ordre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Ordre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Ordre</em>' attribute.
	 * @see #isSetIdOrdre()
	 * @see #unsetIdOrdre()
	 * @see #setIdOrdre(int)
	 * @see org.example.ordre.OrdrePackage#getOrdreType_IdOrdre()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='IdOrdre'"
	 * @generated
	 */
	int getIdOrdre();

	/**
	 * Sets the value of the '{@link org.example.ordre.OrdreType#getIdOrdre <em>Id Ordre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Ordre</em>' attribute.
	 * @see #isSetIdOrdre()
	 * @see #unsetIdOrdre()
	 * @see #getIdOrdre()
	 * @generated
	 */
	void setIdOrdre(int value);

	/**
	 * Unsets the value of the '{@link org.example.ordre.OrdreType#getIdOrdre <em>Id Ordre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIdOrdre()
	 * @see #getIdOrdre()
	 * @see #setIdOrdre(int)
	 * @generated
	 */
	void unsetIdOrdre();

	/**
	 * Returns whether the value of the '{@link org.example.ordre.OrdreType#getIdOrdre <em>Id Ordre</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Id Ordre</em>' attribute is set.
	 * @see #unsetIdOrdre()
	 * @see #getIdOrdre()
	 * @see #setIdOrdre(int)
	 * @generated
	 */
	boolean isSetIdOrdre();

} // OrdreType
