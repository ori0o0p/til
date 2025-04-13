import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

class RandomInterviewQuestion {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String[] directories = {
            "./interview/java",
            "./interview/mysql",
            "./interview/network",
            "./interview/spring",
            "./interview/web-develop"
    };

    // TODO: 4/14/25 중복 질문 제거
    public static void main(final String[] args) throws InterruptedException {
        interviewStartMessage();

        while (true) {
            int input = scanner.nextInt();

            if (input == 0) {
                System.out.println("인터뷰 종료!!!");
                break;
            }

            while (input-- > 0) {
                execute();
            }
        }

        return;
    }

    private static void interviewStartMessage() throws InterruptedException {
        System.out.println("안녕하세요! 지원자님. 지금부터 직무 면접 시작하겠습니다.");

        Thread.sleep(3 * 1000);

        System.out.println("간단한 자기소개(1분)를 부탁드립니다!");

        Thread.sleep(60 * 1000); // 1분 자기소개 인터럽트

        System.out.println("자기소개 잘 들었습니다. 저는 현재 엔지니어링 헤드로 일하고 있는 코드라고 합니다. 반가워요.");
        System.out.println("질문을 받으시려면 질문의 개수를 입력해주세요! 0을 입력하시면, 인터뷰가 종료됩니다.");
    }

    private static void execute() {
        final String randomFileAddress = getRandomMdFile(directories);

        if (randomFileAddress != null) {
            //  ./interview/  제거
            final String interviewQuestion =  randomFileAddress.substring(12);

            System.out.println(interviewQuestion);
        } else {
            System.out.println("파일이 존재하지 않음.");
        }
    }

    private static String getRandomMdFile(final String[] directories) {
        final List<String> mdFiles = new ArrayList<>();

        for (String dir : directories) {
            try {
                final Path path = Paths.get(dir);
                if (Files.exists(path) && Files.isDirectory(path)) {
                    try (Stream<Path> paths = Files.walk(path, 1)) {
                        mdFiles.addAll(
                                paths
                                        .filter(Files::isRegularFile)
                                        .map(Path::toString)
                                        .filter(file -> file.toLowerCase().endsWith(".md"))
                                        .toList()
                        );
                    }
                }
            } catch (IOException e) {
                System.err.println("에러. 발생: " + dir + ": " + e.getMessage());
            }
        }

        if (!mdFiles.isEmpty()) {
            final Random random = new Random();
            final int randomIndex = random.nextInt(mdFiles.size());

            return mdFiles.get(randomIndex);
        }

        return null;
    }

}
