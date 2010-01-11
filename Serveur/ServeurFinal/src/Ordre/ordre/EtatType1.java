/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Ordre.ordre;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Etat Type1</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.example.ordre.OrdrePackage#getEtatType1()
 * @model extendedMetaData="name='Etat_._1_._type'"
 * @generated
 */
public enum EtatType1 implements Enumerator {
	/**
	 * The '<em><b>En Cours</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EN_COURS_VALUE
	 * @generated
	 * @ordered
	 */
	EN_COURS(0, "EnCours", "EnCours"),

	/**
	 * The '<em><b>Termine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERMINE_VALUE
	 * @generated
	 * @ordered
	 */
	TERMINE(1, "Termine", "Termine"),

	/**
	 * The '<em><b>Disponible</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISPONIBLE_VALUE
	 * @generated
	 * @ordered
	 */
	DISPONIBLE(2, "Disponible", "Disponible"),

	/**
	 * The '<em><b>Non Disponible</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NON_DISPONIBLE_VALUE
	 * @generated
	 * @ordered
	 */
	NON_DISPONIBLE(3, "NonDisponible", "NonDisponible");

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
	public static final int EN_COURS_VALUE = 0;

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
	public static final int TERMINE_VALUE = 1;

	/**
	 * The '<em><b>Disponible</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Disponible</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISPONIBLE
	 * @model name="Disponible"
	 * @generated
	 * @ordered
	 */
	public static final int DISPONIBLE_VALUE = 2;

	/**
	 * The '<em><b>Non Disponible</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Non Disponible</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NON_DISPONIBLE
	 * @model name="NonDisponible"
	 * @generated
	 * @ordered
	 */
	public static final int NON_DISPONIBLE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Etat Type1</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EtatType1[] VALUES_ARRAY =
		new EtatType1[] {
			EN_COURS,
			TERMINE,
			DISPONIBLE,
			NON_DISPONIBLE,
		};

	/**
	 * A public read-only list of all the '<em><b>Etat Type1</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EtatType1> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Etat Type1</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EtatType1 get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EtatType1 result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Etat Type1</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EtatType1 getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EtatType1 result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Etat Type1</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EtatType1 get(int value) {
		switch (value) {
			case EN_COURS_VALUE: return EN_COURS;
			case TERMINE_VALUE: return TERMINE;
			case DISPONIBLE_VALUE: return DISPONIBLE;
			case NON_DISPONIBLE_VALUE: return NON_DISPONIBLE;
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
	private EtatType1(int value, String name, String literal) {
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
	
} //EtatType1
