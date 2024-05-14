# Writing unit tests for mappers

A little bird told me that you can write unit tests for mappers comparing the source and target objects as JSON strings. So, I set out to compare that approach with my current favourite one for that matter: [AssertJ recursive comparison API](https://assertj.github.io/doc/#assertj-core-recursive-comparison).

A good solution for the problem at hand should meet two requirements: to be compact, elegant and expressive and to yield an informative error report.

## Conclusions

They say a picture (almost) is worth a thousand words:

```
java.lang.AssertionError: 
Expecting:
  <UserDTO{firstName='Miguel', genre='MALE', balance=MoneyDTO{amount=100.0, currency='null'}}>
to be equal to:
  <User{name='Miguel', genre=MALE, balance=Money{amount=100.0}}>
when recursively comparing field by field, but found the following 2 differences:

field/property 'balance' differ:
- actual value   : MoneyDTO{amount=100.0, currency='null'}
- expected value : Money{amount=100.0}
MoneyDTO can't be compared to Money as Money does not declare all MoneyDTO fields, it lacks these: [currency]

field/property 'genre' differ:
- actual value   : "MALE"
- expected value : MALE
expected field is an enum but actual field is not (java.lang.String)
```

The above is the error output when using AssertJ.

```
[ERROR] Failures: 
[ERROR]   UserMapperJsonTest.asUserDTO:38 expected: <{
  "firstName" : "Miguel",
  "genre" : "MALE",
  "balance" : {
    "amount" : 100.0,
    "currency" : null
  }
}> but was: <{
  "name" : "Miguel",
  "genre" : "MALE",
  "balance" : {
    "amount" : 100.0
  }
}>
```

And this is the error output when using JSON strings. This time though you get a nice `Click here to see the difference` link when running the test inside IntelliJ IDEA:

![image](https://user-images.githubusercontent.com/43891734/98333957-20f6ca00-2002-11eb-8e69-72502ab60bd2.png)

Tada 🎉

And this is, in my opinion, where this approach shines when compared to the other one. Although not nearly as expressive as the nice assertions from the AssertJ library, you obtain a more clear picture of what went wrong **as long as you are running your unit tests inside the IDE**. 

If, on the contrary, your tests are going to run mostly on CI and therefore rely solely on the text-based output then I personally find more descriptive the error report from the AssertJ method.

As a final note I should say that the JSON mapping method can be trickier to set up because of the use of [mixins](https://medium.com/@shankar.ganesh.1234/jackson-mixin-a-simple-guide-to-a-powerful-feature-d984341dc9e2), a convenient but not-so-obvious feature of the Jackson library. With AssertJ everything is laid out with proper naming within the chained call assertion.