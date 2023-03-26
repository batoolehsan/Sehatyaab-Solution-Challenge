// Firebase configuration
var firebaseConfig = {
    apiKey: "AIzaSyAS2cyezqEYULg5so5GrJnfoA2KeKNIdEY",
    authDomain: "sehatyaab-ae014.firebaseapp.com",
    databaseURL: "https://sehatyaab-ae014-default-rtdb.firebaseio.com",
    projectId: "sehatyaab-ae014",
    storageBucket: "sehatyaab-ae014.appspot.com",
    messagingSenderId: "351620671683",
    appId: "1:351620671683:web:cf1d5c94c4915710e35a76"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);

// Refernece contactInfo collections
let contactInfo = firebase.database().ref("messages");

// Listen for a submit
document.querySelector(".php-email-form").addEventListener("submit", submitForm);

function submitForm(e) {
  e.preventDefault();

  //   Get input Values
  let name = document.querySelector(".name").value;
  let email = document.querySelector(".email").value;
  let message = document.querySelector(".message").value;
  console.log(name, email, message);

  saveContactInfo(name, email, message);
//display alert
document.querySelector(".alert").style.display = "block";

//remove alert
setTimeout(() =>{
  document.querySelector(".alert").style.display = "none";
}, 5000);

//reset form
  document.querySelector(".php-email-form").reset();
}

// Save infos to Firebase
function saveContactInfo(name, email, message) {
  let newContactInfo = contactInfo.push();

  newContactInfo.set({
    name: name,
    email: email,
    message: message,
  });
}
