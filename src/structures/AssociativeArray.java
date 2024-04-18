package structures;

import static java.lang.reflect.Array.newInstance;

/**
 * A basic implementation of Associative Arrays with keys of type K
 * and values of type V. Associative Arrays store key/value pairs
 * and permit you to look up values by key.
 *
 * @author Lucas Willett
 * @author Samuel A. Rebelsky
 */
public class AssociativeArray<K, V> {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The default capacity of the initial array.
   */
  static final int DEFAULT_CAPACITY = 16;

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The size of the associative array (the number of key/value pairs).
   */
  int size;

    /**
   * The capacity of the associative array (the number of key/value pairs).
   */
  int capacity;

  /**
   * The array of key/value pairs.
   */
  KVPair<K, V> pairs[];

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty associative array.
   */
  @SuppressWarnings({ "unchecked" })
  public AssociativeArray() {
    // Creating new arrays is sometimes a PITN.
    this.pairs = (KVPair<K, V>[]) newInstance((new KVPair<K, V>()).getClass(),
        DEFAULT_CAPACITY);
    this.size = 0;
    this.capacity = DEFAULT_CAPACITY;
  } // AssociativeArray()

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Create a copy of this AssociativeArray.
   */
  public AssociativeArray<K, V> clone() {
    AssociativeArray<K, V> clone = new AssociativeArray<K, V>();
    clone.pairs = this.pairs;
    clone.size = this.size;
    clone.capacity = this.capacity;
    return clone;
  } // clone()

  /**
   * Convert the array to a string.
   */
  public String toString() {
    String str = "{ ";
    if(this.size == 0){
      return "{}";
    } //if
    int i = 0;
    do {
      if((this.pairs[i] != null) && (this.pairs[i].key != null)){
        str = str+ this.pairs[i].key + ": " + this.pairs[i].value + ", " ;
      } //if
      i++;
    } while(i < this.capacity); //do while
    str = str.substring(0, str.length() -2);
    str = str + " }";
    return str; 
  } // toString()

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * Set the value associated with key to value. Future calls to
   * get(key) will return value.
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public void set(K key, V value) throws NullKeyException {
    if(this.hasKey(key)){
      int key_no = find(key);
      this.pairs[key_no].value = value;
      return;
    } else { //if else
      if(this.isFull()){
        this.expand();
      } //if
      for(int i = 0; i < this.capacity; i++){
        if(this.pairs[i] == null){
          this.pairs[i] = new KVPair(key, value);
          this.size++;
          break;
        } //if
      } //for
    } //else
  } // set(K,V)

  /**
   * Get the value associated with key.
   *
   * @throws KeyNotFoundException
   *                              when the key is null or does not 
   *                              appear in the associative array.
   */
  public V get(K key) throws KeyNotFoundException {
    try {
      int key_no = find(key);
      return this.pairs[key_no].value;
    } catch (Exception e) {
      throw new KeyNotFoundException();
    }
  } // get(K)

  /**
   * Determine if key appears in the associative array. Should
   * return false for the null key.
   */
  public boolean hasKey(K key) {
    for(int i = 0; i < this.size; i++){
      if ((this.pairs[i] != null) && (this.pairs[i].key != null) && (this.pairs[i].key.equals(key))){
        return true;
      } //if
    } //for
    return false;
  } // hasKey(K)

    /**
   * Determine if an array is maxed capacity
   */
  public boolean isFull() {
    for(int i = 0; i < this.capacity; i++){
      if (this.pairs[i] == null){
        return false;
      } //if
    } //for
    return true;
  } // hasKey(K)

  /**
   * Remove the key/value pair associated with a key. Future calls
   * to get(key) will throw an exception. If the key does not appear
   * in the associative array, does nothing.
   */
  public void remove(K key) {
    int key_no = find(key);
    if(key_no == -1){
      return;
    } //if
    this.pairs[key_no].key = null;
    this.pairs[key_no].value = null;
    this.size--;
    return;
  } // remove(K)

  /**
   * Determine how many key/value pairs are in the associative array.
   */
  public int size() {
    return this.size;
  } // size()

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Expand the underlying array.
   */
  void expand() {
    this.pairs = java.util.Arrays.copyOf(this.pairs, this.pairs.length * 2);
    this.capacity *= 2;
  } // expand()

  /**
   * Find the index of the first entry in `pairs` that contains key.
   * If no such entry is found, throws an exception.
   */
  int find(K key){
    int index = 0;
    int has_key = -1;
    for(int i = 0; i < this.capacity; i++){
      if ((this.pairs[i] != null) && (this.pairs[i].key != null) && (this.pairs[i].key.equals(key))){
        has_key = 0;
        break;
      } //if
      index++;
    } //for
    if(has_key == -1){
      return -1;
    } //if
    return index;
  } // find(K)

} // class AssociativeArray
