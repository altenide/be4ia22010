/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.ordre;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Etat Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.example.ordre.OrdrePackage#getEtatType()
 * @model extendedMetaData="name='Etat_._type'"
 * @generated
 */
public enum EtatType implements Enumerator {
	/**
	 * The '<em><b>Non Atteint</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NON_ATTEINT_VALUE
	 * @generated
	 * @ordered
	 */
	NON_ATTEINT(0, "NonAtteint", "NonAtteint"),

	/**
	 * The '<em><b>Refuse</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFUSE_VALUE
	 * @generated
	 * @ordered
	 */
	REFUSE(1, "Refuse", "Refuse"),

	/**
	 * The '<em><b>En Cours</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EN_COURS_VALUE
	 * @generated
	 * @ordered
	 */
	EN_COURS(2, "EnCours", "EnCours"),

	/**
	 * The '<em><b>Termine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERMINE_VALUE
	 * @generated
	 * @ordered
	 */
	TERMINE(3, "Termine", "Termine");

	/**
	 * The '<em><b>Non Atteint</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Non Atteint</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NON_ATTEINT
	 * @model name="NonAtteint"
	 * @generated
	 * @ordered
	 */
	public static final int NON_ATTEINT_VALUE = 0;

	/**
	 * The '<em><b>Refuse</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Refuse</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFUSE
	 * @model name="Refuse"
	 * @generated
	 * @ordered
	 */
	public static final int REFUSE_VALUE = 1;

	/**
	 * The '<em><b>En Cours</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>En Cours</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EN_COURS
	 * @model name="EnCours"
	 * @generated
	 * @ordered
	 */
	public static final int EN_COURS_VALUE = 2;

	/**
	 * The '<em><b>Termine</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Termine</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TERMINE
	 * @model name="Termine"
	 * @generated
	 * @ordered
	 */
	public static final int TERMINE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Etat Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EtatType[] VALUES_ARRAY =
		new EtatType[] {
			NON_ATTEINT,
			REFUSE,
			EN_COURS,
			TERMINE,
		};

	/**
	 * A public read-only list of all the '<em><b>Etat Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EtatType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Etat Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EtatType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EtatType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Etat Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EtatType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EtatType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Etat Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EtatType get(int value) {
		switch (value) {
			case NON_ATTEINT_VALUE: return NON_ATTEINT;
			case REFUSE_VALUE: return REFUSE;
			case EN_COURS_VALUE: return EN_COURS;
			case TERMINE_VALUE: return TERMINE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EtatType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //EtatType
