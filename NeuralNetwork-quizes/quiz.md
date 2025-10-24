### 🧠 Neural Network OOP Practice Version

**1.** Write Java code to define a class  **"Neuron"** .

A neuron has a **"type"** (String) and an **"activationValue"** (double).

Please include a method **"toString()"** to print the neuron’s type and activation value on the screen.

---

**2.** Write Java code to define a class  **"InputNeuron"** , as a subclass of class  **"Neuron"** .

An input neuron has an additional property called **"inputSignal"** (double).

Please include **TWO methods** to **overload** and **override** the **"toString()"** method in the class  **"Neuron"** .

The overridden version should display the input signal and activation value,

and the overloaded version should include a label or description for debugging purposes.

---

**3.** Write a **Test** class that includes the **main** method.

In this Test class, instantiate/create **ONE object of Neuron** and  **ONE object of InputNeuron** .

Print all the attributes/data and call/test **ALL the "toString()"** methods.

Then, demonstrate how both objects can be treated as **Neuron** types to show **polymorphism** when calling methods like `fire()`.
