**Attention Mechanism**

    This is a critica and non-obvous components.

    Why? Because you can't process an entire sentences let alone a paragraoh all at ones. So**Attention Mechanism** alows the modle to dynamically fouces on the most relevant parts of the input text when generating each new word of the out put


### Description: The Scaled Dot-Product Attention Method

This is the core mathematical operation behind the famous Transformer architecture (which is the "T" in GPT).

**Purpose:** Given a "query" (what I'm currently interested in), and a set of "keys" (what the input words are), figure out which keys are most relevant to the query. Then, use the corresponding "values" (the actual content of those words) to form a response.

**Imagine you are the model translating this sentence:**
**Input:** "The cat sat on the mat because it was tired."
**Output:** You are generating the word for "it".

The method should:

1. **Calculate Attention Scores:** For the current query ("what is 'it' referring to?"), compare it against the key for every word in the input sentence ("The", "cat", "sat", ...). This gives a score for each input word.
2. **Softmax the Scores:** Convert these scores into a probability distribution (weights that sum to 1.0). The word "cat" should get a very high weight; the word "mat" should get a very low one.
3. **Produce a Context Vector:** Create a weighted sum of all the *value* vectors, using the softmax weights. The value for "cat" will dominate this final vector.
4. **This context vector, rich with information about "cat", is then used to correctly generate the translation.**

Your method will perform this operation for a single query against a set of keys and values.

### Test Case: Resolving the Pronoun "It"

This test case is designed to be simple and check if your attention mechanism can perform its most important job: focusing on the correct antecedent.

**Inputs to Your Method:**

* **Query (`q`):** A vector representing the current decoding step. For this test, it's the state of the model *just before* it needs to output the word "it".
* **Keys (`k`):** An array of vectors, one for each word in the input sentence: `["The", "cat", "sat", "on", "the", "mat", "because", "it", "was", "tired"]`.
* **Values (`v`):** An array of vectors, one for each word in the input sentence (often the same as the keys or derived from them): `["The", "cat", "sat", "on", "the", "mat", "because", "it", "was", "tired"]`.

**Expected Output:**

* **Attention Weights:** An array of probabilities (floats between 0 and 1 that sum to ~1.0).
* **Expected Weight Distribution:** The highest probability in this array should be at the index corresponding to the word  **"cat"** . The weight for "mat" should be significantly lower.
