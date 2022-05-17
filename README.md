<div id="top"></div>

<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![Apache 2.0 License][license-shield]][license-url]

# wichtel-matcher

### DISCLAIMER

This project was not intended to be used by other people at the start of development and is only tested via starting it
from my dev environment.

USE AT YOUR OWN RISK

<!-- ABOUT THE PROJECT -->

## About The Project

This project intends to match each person in a list of participants with another participant (opponent). A requirement
is that nobody is matched with themselves, and the operator should not be able to see each pairing.

This is done via sending an e-mail to each participant that includes the opponent.

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->

## Getting Started

This is an example of how you may give instructions on setting up your project locally. To get a local copy up and
running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.

* Java 17 (temurin)
* configured ```participants.txt```
* configured ```mailerconfig.txt``` (if ```MailOutput``` should be used)

For the configured ```*.txt``` files, check the corresponding ```TEMPLATE``` files. This should bring you on the right
tracks and check [Configuration](#configuration-of-txt-files).

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/JoKrus/wichtel-matcher.git
   ```
2. Configure the ```*.txt``` files (see in [Configuration](#configuration-of-txt-files))
3. Execute Maven project
   ```sh
   mvn clean compile exec:java
   ```

<p align="right">(<a href="#top">back to top</a>)</p>

## Configuration of ```*.txt``` files

All files that need to be configured are located in ```src/main/resources``` and have a
corresponding ```*TEMPLATE.txt``` file that showcases the structure of the file that should be created.

So for ```participantsTEMPLATE.txt```, you need to create a ```participants.txt``` and so on.

### Config of ```participants.txt```

This file should contain one participant per line.

Each participant consists out of a name and a mail address. They are delimited via ```;```.

### Config of ```mailerconfig.txt```

This file should contain the configuration of your web mailer.

It consists of 5 lines.

- smtp server of host
- smtp port of host (587)
- sender mail address
- sender password
- sender name

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ROADMAP -->

## Roadmap

- [x] Custom list of participants
- [x] Customizable sender
- [ ] Customizable message
- [ ] Improve matchmaking

See the [open issues](https://github.com/JoKrus/wichtel-matcher/issues) for a full list of proposed features (and known
issues).

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please create an issue that proposes the feature.

If this gets approved by me, please fork the repo and create a pull request. You can also simply open an issue with the
tag "enhancement". Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- LICENSE -->

## License

Distributed under the Apache 2.0 License. See `LICENSE` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- ACKNOWLEDGMENTS -->

## Acknowledgments

* [RedRem95](https://www.github.com/RedRem95), he motivated me to write this README

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/JoKrus/wichtel-matcher.svg?style=for-the-badge

[contributors-url]: https://github.com/JoKrus/wichtel-matcher/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/JoKrus/wichtel-matcher.svg?style=for-the-badge

[forks-url]: https://github.com/JoKrus/wichtel-matcher/network/members

[stars-shield]: https://img.shields.io/github/stars/JoKrus/wichtel-matcher.svg?style=for-the-badge

[stars-url]: https://github.com/JoKrus/wichtel-matcher/stargazers

[issues-shield]: https://img.shields.io/github/issues/JoKrus/wichtel-matcher.svg?style=for-the-badge

[issues-url]: https://github.com/JoKrus/wichtel-matcher/issues

[license-shield]: https://img.shields.io/github/license/JoKrus/wichtel-matcher.svg?style=for-the-badge

[license-url]: https://github.com/JoKrus/wichtel-matcher/blob/master/LICENSE.txt
