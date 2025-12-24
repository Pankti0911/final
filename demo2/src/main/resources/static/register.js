const form = document.getElementById("registerForm");
const offline = document.getElementById("offline");

function checkStatus() {
  offline.style.display = navigator.onLine ? "none" : "block";
}

window.addEventListener("online", checkStatus);
window.addEventListener("offline", checkStatus);
checkStatus();

form.addEventListener("submit", e => {
  e.preventDefault();

  const data = {
    name: name.value,
    email: email.value
  };

  if (!navigator.onLine) {
    localStorage.setItem("offlineUser", JSON.stringify(data));
    alert("Offline. Data saved.");
  } else {
    send(data);
  }
});

window.addEventListener("online", () => {
  const saved = localStorage.getItem("offlineUser");
  if (saved) {
    send(JSON.parse(saved));
    localStorage.removeItem("offlineUser");
  }
});

function send(data) {
  fetch("/register", {
    method: "POST",
    headers: {"Content-Type":"application/json"},
    body: JSON.stringify(data)
  }).then(() => alert("Registered successfully"));
}
