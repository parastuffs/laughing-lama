/**
 * BookList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package librarysearch.soft;

public class BookList  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private org.apache.axis.message.MessageElement [] _any;

    private librarysearch.soft.Book[] book;

    public BookList() {
    }

    public BookList(
           org.apache.axis.message.MessageElement [] _any,
           librarysearch.soft.Book[] book) {
           this._any = _any;
           this.book = book;
    }


    /**
     * Gets the _any value for this BookList.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this BookList.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the book value for this BookList.
     * 
     * @return book
     */
    public librarysearch.soft.Book[] getBook() {
        return book;
    }


    /**
     * Sets the book value for this BookList.
     * 
     * @param book
     */
    public void setBook(librarysearch.soft.Book[] book) {
        this.book = book;
    }

    public librarysearch.soft.Book getBook(int i) {
        return this.book[i];
    }

    public void setBook(int i, librarysearch.soft.Book _value) {
        this.book[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BookList)) return false;
        BookList other = (BookList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any()))) &&
            ((this.book==null && other.getBook()==null) || 
             (this.book!=null &&
              java.util.Arrays.equals(this.book, other.getBook())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (get_any() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_any());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_any(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBook() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBook());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBook(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BookList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:soft.librarysearch", "BookList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("book");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soft.librarysearch", "book"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:soft.librarysearch", "Book"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
